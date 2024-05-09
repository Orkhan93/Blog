package az.spring.blog.request.user;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserLoginRequest {

    private String username;
    private String password;

}