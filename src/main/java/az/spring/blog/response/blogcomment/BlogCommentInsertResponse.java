package az.spring.blog.response.blogcomment;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class BlogCommentInsertResponse {

    private String comment;
    private Long createdBy;
    private Boolean status;

}