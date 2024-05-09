package az.spring.blog.service.user;

import az.spring.blog.entity.user.User;
import az.spring.blog.exception.error.ErrorMessage;
import az.spring.blog.repository.UserRepository;
import az.spring.blog.request.user.UserLoginRequest;
import az.spring.blog.security.EncryptionService;
import az.spring.blog.security.JwtService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserLoginService {

    private final UserRepository userRepository;
    private final EncryptionService encryptionService;
    private final JwtService jwtService;

    public String login(UserLoginRequest userLoginRequest) {
        log.info("Inside userLoginRequest {}", userLoginRequest);
        Optional<User> optionalUser = userRepository.findByUsernameIgnoreCase(userLoginRequest.getUsername());
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            if (encryptionService.verifyPassword(userLoginRequest.getPassword(), user.getPassword())) {
                return jwtService.generateJwt(user);
            } else if ((!encryptionService.verifyPassword(userLoginRequest.getPassword(), user.getPassword()))) {
                return ErrorMessage.INCORRECT_PASSWORD;
            }
        }
        return ErrorMessage.USER_NOT_FOUND;
    }

}