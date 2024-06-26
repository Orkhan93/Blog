package az.spring.blog.controller;

import az.spring.blog.entity.blog.Blog;
import az.spring.blog.request.blog.BlogCreateServiceRequest;
import az.spring.blog.request.blog.BlogInfoReadRequest;
import az.spring.blog.request.blog.BlogReadRequest;
import az.spring.blog.request.blogcomment.BlogCommentInsertRequest;
import az.spring.blog.request.search.FilterSearchRequest;
import az.spring.blog.response.blog.BlogCreateResponse;
import az.spring.blog.response.blog.BlogInfoReadResponse;
import az.spring.blog.response.blog.BlogReadResponse;
import az.spring.blog.response.blogcomment.BlogCommentInsertResponse;
import az.spring.blog.service.blog.BlogCreateService;
import az.spring.blog.service.blog.BlogInfoReadService;
import az.spring.blog.service.blog.BlogReadService;
import az.spring.blog.service.blog.filter.BlogFilterService;
import az.spring.blog.service.blogcomment.BlogCommentInsertService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/blogs")
public class BlogController {

    private final BlogCreateService createService;
    private final BlogCommentInsertService insertService;
    private final BlogReadService readService;
    private final BlogInfoReadService byIdReadService;
    private final BlogFilterService filterService;

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

    @PostMapping("/get")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<BlogReadResponse> getBlogs(@RequestBody BlogReadRequest request) {
        return ResponseEntity.ok(readService.read(request));
    }

    @PostMapping("/get-blog-id")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<BlogInfoReadResponse> getBlogsById(@RequestBody BlogInfoReadRequest request) {
        return ResponseEntity.ok(byIdReadService.specificReadBlog(request));
    }

    @PostMapping("/specification")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<Blog>> blogFilter(@RequestBody FilterSearchRequest request) {
        return ResponseEntity.ok(filterService.getProductsWithSpecification(request));
    }

}