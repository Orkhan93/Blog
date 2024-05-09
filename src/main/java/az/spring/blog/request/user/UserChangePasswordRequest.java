package az.spring.blog.request.user;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserChangePasswordRequest {

    private Long userId;
    private String oldPassword;
    private String newPassword;
    private String confirmPassword;

}