package az.spring.blog.repository;

import az.spring.blog.entity.blog.BlogComment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogCommentRepository extends JpaRepository<BlogComment, Long> {



}