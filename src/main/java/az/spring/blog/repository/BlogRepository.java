package az.spring.blog.repository;

import az.spring.blog.entity.blog.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRepository extends JpaRepository<Blog, Long> {



}