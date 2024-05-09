package az.spring.blog.controller;

import az.spring.blog.request.user.UserRegisterRequest;
import az.spring.blog.response.user.UserRegisterResponse;
import az.spring.blog.service.UserRegisterService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserRegisterService registerService;

    @PostMapping("/register")
    public ResponseEntity<UserRegisterResponse> register(@RequestBody UserRegisterRequest registerRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(registerService.registerUser(registerRequest));
    }

}