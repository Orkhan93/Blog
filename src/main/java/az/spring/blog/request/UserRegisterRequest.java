package az.spring.blog.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserRegisterRequest {

    private String email;
    private String username;
    private String name;
    private String password;
    private String surname;
    private String phoneNumber;

}