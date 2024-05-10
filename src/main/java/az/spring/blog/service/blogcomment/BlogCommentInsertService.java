package az.spring.blog.service.blogcomment;

import az.spring.blog.entity.blog.Blog;
import az.spring.blog.entity.blog.BlogComment;
import az.spring.blog.entity.user.User;
import az.spring.blog.exception.BlogNotFoundException;
import az.spring.blog.exception.UserNotFoundException;
import az.spring.blog.exception.error.ErrorMessage;
import az.spring.blog.mapper.BlogCommentMapper;
import az.spring.blog.repository.BlogCommentRepository;
import az.spring.blog.repository.BlogRepository;
import az.spring.blog.repository.UserRepository;
import az.spring.blog.request.blogcomment.BlogCommentInsertRequest;
import az.spring.blog.response.blogcomment.BlogCommentInsertResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class BlogCommentInsertService {

    private final UserRepository userRepository;
    private final BlogRepository blogRepository;
    private final BlogCommentRepository blogCommentRepository;
    private final BlogCommentMapper blogCommentMapper;

    public BlogCommentInsertResponse insertComment(BlogCommentInsertRequest insertRequest) {
        User user = userRepository.findById(insertRequest.getFkUserId())
                .orElseThrow(() -> new UserNotFoundException(HttpStatus.NOT_FOUND.name(), ErrorMessage.USER_NOT_FOUND));
        Blog blog = blogRepository.findById(insertRequest.getFkBlogId())
                .orElseThrow(() -> new BlogNotFoundException(HttpStatus.NOT_FOUND.name(), ErrorMessage.BLOG_NOT_FOUND));
        BlogComment blogComment = blogCommentMapper.requestToEntity(insertRequest);
        blogComment.setFkBlogId(blog.getId());
        blogComment.setCreatedBy(user.getId());
        return blogCommentMapper.entityToResponse(blogCommentRepository.save(blogComment));
    }

}