package az.spring.blog.service.user;

import az.spring.blog.entity.user.User;
import az.spring.blog.exception.UserAlreadyExistsException;
import az.spring.blog.exception.error.ErrorMessage;
import az.spring.blog.mapper.UserMapper;
import az.spring.blog.repository.UserRepository;
import az.spring.blog.request.user.UserRegisterRequest;
import az.spring.blog.response.user.UserRegisterResponse;
import az.spring.blog.security.EncryptionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserRegisterService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final EncryptionService encryptionService;

    public UserRegisterResponse registerUser(UserRegisterRequest userRegistration) throws UserAlreadyExistsException {
        log.info("Inside userRegistration {}", userRegistration);
        if (userRepository.findByEmailIgnoreCase(userRegistration.getEmail()).isPresent() ||
                userRepository.findByUsernameIgnoreCase(userRegistration.getUsername()).isPresent()) {
            throw new UserAlreadyExistsException(BAD_REQUEST.name(), ErrorMessage.USER_ALREADY_EXISTS);
        }
        User user = userMapper.requestToEntity(userRegistration);
        user.setPassword(encryptionService.encryptPassword(userRegistration.getPassword()));
        log.info("Inside register {}", user);
        return userMapper.entityToRegisterResponse(userRepository.save(user));
    }

}