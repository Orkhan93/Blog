package az.spring.blog.repository;

import az.spring.blog.entity.blog.BlogImage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogImageRepository extends JpaRepository<BlogImage, Long> {



}