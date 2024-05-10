package az.spring.blog.service.blog;

import az.spring.blog.repository.BlogRepository;
import az.spring.blog.request.blog.BlogSpecificReadRequest;
import az.spring.blog.response.blog.BlogReadDTO;
import az.spring.blog.response.blog.BlogSpecificReadResponse;
import az.spring.blog.response.blogcomment.BlogCommentResponse;
import az.spring.blog.response.blogimage.BlogImageResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class BlogByIdReadService {

    private final BlogRepository blogRepository;

    public BlogSpecificReadResponse specificReadBlog(BlogSpecificReadRequest readRequest) {
        BlogReadDTO blogReadDTO = blogRepository.specificBlog(readRequest.getFkBlogId());
        List<BlogImageResponse> imagesList = blogRepository.blogImageList(readRequest.getFkBlogId());
        List<BlogCommentResponse> commentList = blogRepository.commentList(readRequest.getFkBlogId());
        return BlogSpecificReadResponse.builder()
                .main(blogReadDTO)
                .commentList(commentList)
                .imageList(imagesList)
                .build();
    }

}