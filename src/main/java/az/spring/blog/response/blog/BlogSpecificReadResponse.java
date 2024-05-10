package az.spring.blog.response.blog;

import az.spring.blog.response.blogcomment.BlogCommentResponse;
import az.spring.blog.response.blogimage.BlogImageResponse;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@Builder
public class BlogSpecificReadResponse {

    BlogReadDTO main;
    List<BlogCommentResponse> commentList;
    List<BlogImageResponse> imageList;

}