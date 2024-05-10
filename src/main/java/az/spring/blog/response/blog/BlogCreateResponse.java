package az.spring.blog.response.blog;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
public class BlogCreateResponse {

    private String name;
    private String title;
    private String content;
    private String cover;
    private Long viewedCount;
    private Boolean published;
    private LocalDateTime publishedDate;
    private Boolean status;
    private Long createdBy;

}