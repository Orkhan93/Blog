package az.spring.blog.request.search;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SearchRequest {

    private String column;
    private String value;

}