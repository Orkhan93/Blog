package az.spring.blog.controller;

import az.spring.blog.request.user.*;
import az.spring.blog.response.user.UserReadResponse;
import az.spring.blog.response.user.UserRegisterResponse;
import az.spring.blog.service.user.*;
import jakarta.mail.MessagingException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users/auth")
public class UserController {

    private final UserRegisterService registerService;
    private final UserLoginService loginService;
    private final UserChangePasswordService changePasswordService;
    private final UserReadService readService;
    private final UserForgotPasswordService forgotPasswordService;

    @PostMapping("/register")
    public ResponseEntity<UserRegisterResponse> register(@RequestBody UserRegisterRequest registerRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(registerService.registerUser(registerRequest));
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody UserLoginRequest loginRequest) {
        return ResponseEntity.status(HttpStatus.OK).body(loginService.login(loginRequest));
    }

    @PostMapping("/change-password")
    @ResponseStatus(HttpStatus.OK)
    public void changePassword(@RequestBody UserChangePasswordRequest request) {
        changePasswordService.changePassword(request);
    }

    @PostMapping("/get")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<UserReadResponse> changePassword(@RequestBody UserReadRequest request) {
        return ResponseEntity.ok(readService.read(request));
    }

    @PostMapping("/forgot-password")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> forgotPassword(@RequestBody UserForgotPasswordRequest forgotPasswordRequest) throws MessagingException {
        return ResponseEntity.ok(forgotPasswordService.forgotPassword(forgotPasswordRequest));
    }

}