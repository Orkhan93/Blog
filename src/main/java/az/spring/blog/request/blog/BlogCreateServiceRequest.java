package az.spring.blog.request.blog;

import az.spring.blog.request.blogimage.BlogImageCreateDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class BlogCreateServiceRequest {

    BlogCreateServiceDTO blogRequest;
    List<BlogImageCreateDTO> blogImageRequest;

}