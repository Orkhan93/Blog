package az.spring.blog.mapper;

import az.spring.blog.entity.blog.BlogComment;
import az.spring.blog.request.blogcomment.BlogCommentInsertRequest;
import az.spring.blog.response.blogcomment.BlogCommentInsertResponse;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedSourcePolicy = ReportingPolicy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface BlogCommentMapper {

    BlogComment requestToEntity(BlogCommentInsertRequest createDTO);

    BlogCommentInsertResponse entityToResponse(BlogComment blogComment);

}