package az.spring.blog.request.blog;

import az.spring.blog.request.blogimage.BlogImageCreateDTO;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class BlogCreateServiceRequest {

    BlogCreateServiceDTO blogRequest;
    BlogImageCreateDTO blogImageRequest;
//    BlogCommentCreateDTO blogCommentRequest;

}