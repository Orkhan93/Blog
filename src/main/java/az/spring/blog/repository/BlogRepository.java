package az.spring.blog.repository;

import az.spring.blog.entity.blog.Blog;
import az.spring.blog.response.blog.BlogReadDTO;
import az.spring.blog.response.blogcomment.BlogCommentResponse;
import az.spring.blog.response.blogimage.BlogImageResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BlogRepository extends JpaRepository<Blog, Long>, JpaSpecificationExecutor<Blog> {

    @Query("""
                select distinct new az.spring.blog.response.blog.BlogReadDTO(
                b.id,
                b.name,
                b.title,
                b.content,
                b.cover,
                b.viewedCount,
                b.published,
                b.publishedDate,
                b.createdBy,
                b.createdAt)
                from User u
                left join Blog b on b.createdBy =:fkUserId
                where b.createdBy = u.id and b.published = true
            """)
    List<BlogReadDTO> blogList(Long fkUserId);

    @Query("""
                select distinct new az.spring.blog.response.blogimage.BlogImageResponse(bi.id,bi.filePath,bi.altText)
                from User u
                left join Blog b on b.createdBy =:fkUserId
                left join BlogImage bi on b.id = bi.fkBlogId 
                where b.createdBy = bi.createdBy
            """)
    List<BlogImageResponse> imageList(Long fkUserId);

    @Query("""
            select distinct new az.spring.blog.response.blog.BlogReadDTO(
            b.id,
                b.name,
                b.title,
                b.content,
                b.cover,
                b.viewedCount,
                b.published,
                b.publishedDate,
                b.createdBy,
                b.createdAt)
            from Blog b left join BlogComment bc on bc.fkBlogId =:fkBlogId
            where b.id = bc.fkBlogId
            """)
    BlogReadDTO specificBlog(Long fkBlogId);

    @Query("""
                select distinct new az.spring.blog.response.blogimage.BlogImageResponse(bi.id,bi.filePath,bi.altText)
                from Blog b
                left join BlogImage bi on bi.fkBlogId =:fkBlogId
                where b.id = bi.fkBlogId
            """)
    List<BlogImageResponse> blogImageList(Long fkBlogId);

    @Query("""
            select distinct new az.spring.blog.response.blogcomment.BlogCommentResponse(
            bc.comment,bc.createdBy,bc.status)
            from Blog b
            left join BlogComment bc on bc.fkBlogId =:fkBlogId
            where b.id = bc.fkBlogId
            """)
    List<BlogCommentResponse> commentList(Long fkBlogId);

}