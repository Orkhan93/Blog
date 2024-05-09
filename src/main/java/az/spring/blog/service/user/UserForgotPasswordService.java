package az.spring.blog.service.user;

import az.spring.blog.constant.BlogConstant;
import az.spring.blog.entity.user.User;
import az.spring.blog.exception.error.ErrorMessage;
import az.spring.blog.repository.UserRepository;
import az.spring.blog.request.user.UserForgotPasswordRequest;
import az.spring.blog.service.email.EmailService;
import jakarta.mail.MessagingException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserForgotPasswordService {

    private final UserRepository userRepository;
    private final EmailService emailService;

    public String forgotPassword(UserForgotPasswordRequest forgotPasswordRequest) throws MessagingException {
        log.info("Inside forgotPassword {}", forgotPasswordRequest);
        Optional<User> user = userRepository.findByEmailIgnoreCase(forgotPasswordRequest.getEmail());
        if (user.isPresent()) {
            emailService.forgetMail(user.get().getEmail(), BlogConstant.BY_BLOG_APPLICATION, user.get().getPassword());
            return BlogConstant.CHECK_EMAIL;
        } else
            return ErrorMessage.USER_NOT_FOUND;
    }

}