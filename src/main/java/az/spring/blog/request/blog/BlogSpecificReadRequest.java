package az.spring.blog.request.blog;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class BlogSpecificReadRequest {

    private Long fkBlogId;

}