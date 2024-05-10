package az.spring.blog.service.filter;

import az.spring.blog.request.search.SearchRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FilterSpecificationService<T> {

    public Specification<T> getObjectWithSpecification(SearchRequest searchRequest) {
        return ((root, query, criteriaBuilder) ->
                criteriaBuilder.like(root.get(searchRequest.getColumn()), "%" + searchRequest.getValue() + "%"));
    }

}