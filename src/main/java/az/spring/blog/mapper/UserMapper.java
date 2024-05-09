package az.spring.blog.mapper;

import az.spring.blog.entity.user.User;
import az.spring.blog.request.user.UserRegisterRequest;
import az.spring.blog.response.user.UserReadResponse;
import az.spring.blog.response.user.UserRegisterResponse;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedSourcePolicy = ReportingPolicy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {

    User requestToEntity(UserRegisterRequest request);

    UserRegisterResponse entityToRegisterResponse(User user);

    UserReadResponse entityToReadResponse(User user);

}