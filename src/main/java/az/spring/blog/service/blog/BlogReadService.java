package az.spring.blog.service.blog;

import az.spring.blog.entity.user.User;
import az.spring.blog.exception.UserNotFoundException;
import az.spring.blog.exception.error.ErrorMessage;
import az.spring.blog.repository.BlogRepository;
import az.spring.blog.repository.UserRepository;
import az.spring.blog.request.blog.BlogReadRequest;
import az.spring.blog.response.blog.BlogReadDTO;
import az.spring.blog.response.blog.BlogReadResponse;
import az.spring.blog.response.blogimage.BlogImageResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class BlogReadService {

    private final UserRepository userRepository;
    private final BlogRepository blogRepository;

    public BlogReadResponse read(BlogReadRequest readRequest) {
        User user = userRepository.findById(readRequest.getFkUserId()).orElseThrow(
                () -> new UserNotFoundException(HttpStatus.NOT_FOUND.name(), ErrorMessage.USER_NOT_FOUND));
        List<BlogReadDTO> blogList = blogRepository.blogList(user.getId());
        List<BlogImageResponse> imagesList = blogRepository.imageList(user.getId());
        return BlogReadResponse.builder()
                .blogList(blogList)
                .imageList(imagesList)
                .build();
    }

}