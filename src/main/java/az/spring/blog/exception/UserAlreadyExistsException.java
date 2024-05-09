package az.spring.blog.exception;

public class UserAlreadyExistsException extends RuntimeException {

    public UserAlreadyExistsException(String message, String code) {
        super(message);
    }

}