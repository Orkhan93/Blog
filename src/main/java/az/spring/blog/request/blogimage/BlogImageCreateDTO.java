package az.spring.blog.request.blogimage;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class BlogImageCreateDTO {

    private String filePath;
    private Long fkBlogId;
    private String altText;

}