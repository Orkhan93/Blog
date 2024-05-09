package az.spring.blog.response.user;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserLoginResponse {

    private String jwt;
    private boolean success;
    private String failureReason;

}