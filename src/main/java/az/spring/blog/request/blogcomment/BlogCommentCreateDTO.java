package az.spring.blog.request.blogcomment;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class BlogCommentCreateDTO {

    private Long fkBlogId;
    private String comment;

}