package az.spring.blog.response.blog;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class BlogReadDTO {

    private Long id;
    private String name;
    private String title;
    private String content;
    private String cover;
    private Long viewedCount;
    private Boolean published;
    private LocalDateTime publishedDate;
    private Long createdBy;
    private LocalDateTime createdAt;

}