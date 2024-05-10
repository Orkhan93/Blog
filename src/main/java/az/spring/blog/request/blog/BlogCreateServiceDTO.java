package az.spring.blog.request.blog;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
public class BlogCreateServiceDTO {

    private Long fkUserId;
    private String name;
    private String title;
    private String content;
    private String cover;
    private LocalDateTime createdAt;
    private Long createdBy;
    private Long updatedBy;

}