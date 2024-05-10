package az.spring.blog.response.blogimage;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class BlogImageResponse {

    private Long id;
    private String filePath;
    private String altText;

}