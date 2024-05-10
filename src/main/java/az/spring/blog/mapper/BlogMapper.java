package az.spring.blog.mapper;

import az.spring.blog.entity.blog.Blog;
import az.spring.blog.request.blog.BlogCreateServiceDTO;
import az.spring.blog.response.blog.BlogCreateResponse;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedSourcePolicy = ReportingPolicy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface BlogMapper {

    Blog requestToEntity(BlogCreateServiceDTO createServiceDTO);

    BlogCreateResponse entityToResponse(Blog blog);

}