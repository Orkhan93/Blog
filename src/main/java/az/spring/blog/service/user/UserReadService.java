package az.spring.blog.service.user;

import az.spring.blog.entity.user.User;
import az.spring.blog.exception.UserNotFoundException;
import az.spring.blog.exception.error.ErrorMessage;
import az.spring.blog.mapper.UserMapper;
import az.spring.blog.repository.UserRepository;
import az.spring.blog.request.user.UserReadRequest;
import az.spring.blog.response.user.UserReadResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserReadService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserReadResponse read(UserReadRequest readRequest) {
       User user =  userRepository.findById(readRequest.getUserId()).orElseThrow(
                ()-> new UserNotFoundException(HttpStatus.NOT_FOUND.name(), ErrorMessage.USER_NOT_FOUND));
       return userMapper.entityToReadResponse(user);
    }

}