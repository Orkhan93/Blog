package az.spring.blog.request.blogcomment;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class BlogCommentInsertRequest {

    private Long fkBlogId;
    private Long fkUserId;
    private String comment;

}