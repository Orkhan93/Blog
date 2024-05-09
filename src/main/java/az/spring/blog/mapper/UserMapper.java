package az.spring.blog.mapper;

import az.spring.blog.entity.User;
import az.spring.blog.request.UserRegisterRequest;
import az.spring.blog.response.UserRegisterResponse;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedSourcePolicy = ReportingPolicy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {

    User requestToEntity(@MappingTarget User user, UserRegisterRequest request);

    UserRegisterResponse entityToResponse(@MappingTarget UserRegisterResponse response, User user);

}