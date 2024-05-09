package az.spring.blog.service;

import az.spring.blog.entity.user.User;
import az.spring.blog.exception.IncorrectPasswordException;
import az.spring.blog.exception.UserNotFoundException;
import az.spring.blog.exception.error.ErrorMessage;
import az.spring.blog.repository.UserRepository;
import az.spring.blog.request.user.UserChangePasswordRequest;
import az.spring.blog.security.EncryptionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserChangePasswordService {

    private final UserRepository userRepository;
    private final EncryptionService encryptionService;
    private final PasswordEncoder passwordEncoder;

    public void changePassword(UserChangePasswordRequest changePasswordRequest) {
        log.info("Inside changePassword {}", changePasswordRequest);
        User user = userRepository.findById(changePasswordRequest.getUserId()).orElseThrow(
                () -> new UserNotFoundException(HttpStatus.NOT_FOUND.name(), ErrorMessage.USER_NOT_FOUND));
        if (!encryptionService.verifyPassword(changePasswordRequest.getOldPassword(), user.getPassword())) {
            throw new IncorrectPasswordException(BAD_REQUEST.name(), ErrorMessage.INCORRECT_PASSWORD);
        }
        if (!changePasswordRequest.getNewPassword().equals(changePasswordRequest.getConfirmPassword())) {
            throw new IncorrectPasswordException(BAD_REQUEST.name(), ErrorMessage.NOT_MATCHES);
        }
        user.setPassword(passwordEncoder.encode(changePasswordRequest.getNewPassword()));
        log.info("Inside savedUser {}", user);
        userRepository.save(user);
    }

}