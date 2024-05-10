package az.spring.blog.controller;

import az.spring.blog.request.blog.BlogCreateServiceRequest;
import az.spring.blog.request.blogcomment.BlogCommentInsertRequest;
import az.spring.blog.response.blog.BlogCreateResponse;
import az.spring.blog.response.blogcomment.BlogCommentInsertResponse;
import az.spring.blog.service.blog.BlogCreateService;
import az.spring.blog.service.blogcomment.BlogCommentInsertService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/blogs")
public class BlogController {

    private final BlogCreateService createService;
    private final BlogCommentInsertService insertService;

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<BlogCreateResponse> createBlog(@RequestBody BlogCreateServiceRequest request) {
        return ResponseEntity.ok(createService.createBlog(request));
    }

    @PostMapping("/insert-comment")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<BlogCommentInsertResponse> insertComment(@RequestBody BlogCommentInsertRequest request) {
        return ResponseEntity.ok(insertService.insertComment(request));
    }

}