package az.spring.blog.exception;

public class BlogNotFoundException extends RuntimeException {

    public BlogNotFoundException(String code, String message) {
        super(message);
    }

}