package az.spring.blog.service.blog;

import az.spring.blog.entity.blog.Blog;
import az.spring.blog.entity.blog.BlogImage;
import az.spring.blog.entity.user.User;
import az.spring.blog.exception.UserNotFoundException;
import az.spring.blog.exception.error.ErrorMessage;
import az.spring.blog.mapper.BlogImageMapper;
import az.spring.blog.mapper.BlogMapper;
import az.spring.blog.repository.BlogImageRepository;
import az.spring.blog.repository.BlogRepository;
import az.spring.blog.repository.UserRepository;
import az.spring.blog.request.blog.BlogCreateServiceDTO;
import az.spring.blog.request.blog.BlogCreateServiceRequest;
import az.spring.blog.response.blog.BlogCreateResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import az.spring.blog.repository.BlogRepository;
import az.spring.blog.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class BlogCreateService {

    private final UserRepository userRepository;
    private final BlogRepository blogRepository;
    private final BlogImageRepository blogImageRepository;
    private final BlogMapper blogMapper;
    private final BlogImageMapper blogImageMapper;

    public BlogCreateResponse createBlog(BlogCreateServiceRequest createRequest) {
        User user = userRepository.findById(createRequest.getBlogRequest().getFkUserId())
                .orElseThrow(() -> new UserNotFoundException(HttpStatus.NOT_FOUND.name(), ErrorMessage.USER_NOT_FOUND));

        BlogCreateServiceDTO blogRequest = createRequest.getBlogRequest();
        blogRequest.setCreatedBy(user.getId());
        Blog saveBlog = blogRepository.save(blogMapper.requestToEntity(blogRequest));

        BlogImage blogImage = blogImageMapper.requestToEntity(createRequest.getBlogImageRequest());
        blogImage.setCreatedBy(user.getId());
        blogImageRepository.save(blogImage);
        return blogMapper.entityToResponse(saveBlog);
    }

}