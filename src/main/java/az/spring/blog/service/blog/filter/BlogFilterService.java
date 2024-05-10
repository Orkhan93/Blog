package az.spring.blog.service.blog.filter;

import az.spring.blog.entity.blog.Blog;
import az.spring.blog.repository.BlogRepository;
import az.spring.blog.request.search.FilterSearchRequest;
import az.spring.blog.service.filter.FilterSpecificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BlogFilterService {

    private final BlogRepository blogRepository;
    private final FilterSpecificationService<Blog> filterSpecificationService;

    public List<Blog> getProductsWithSpecification(FilterSearchRequest filterSearchRequest) {
        Specification<Blog> productSpecification =
                filterSpecificationService.getObjectWithSpecification(filterSearchRequest.getSearchRequest());
        return blogRepository.findAll(productSpecification);
    }

}