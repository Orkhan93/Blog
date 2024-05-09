package az.spring.blog.exception;

public class IncorrectPasswordException extends RuntimeException {

    public IncorrectPasswordException(String code, String message) {
        super(message);
    }

}