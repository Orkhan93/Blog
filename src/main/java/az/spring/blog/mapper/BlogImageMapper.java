package az.spring.blog.mapper;

import az.spring.blog.entity.blog.BlogImage;
import az.spring.blog.request.blogimage.BlogImageCreateDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedSourcePolicy = ReportingPolicy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface BlogImageMapper {

    BlogImage requestToEntity(BlogImageCreateDTO createDTO);

}