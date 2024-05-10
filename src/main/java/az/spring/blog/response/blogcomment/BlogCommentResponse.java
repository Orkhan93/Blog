package az.spring.blog.response.blogcomment;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class BlogCommentResponse {

    private String comment;
    private Long createdBy;
    private Boolean status;

}