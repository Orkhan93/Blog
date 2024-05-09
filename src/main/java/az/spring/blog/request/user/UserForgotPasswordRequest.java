package az.spring.blog.request.user;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserForgotPasswordRequest {

    private String email;

}