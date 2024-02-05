package com.SpringbootBlog.UdemyBlog.Repository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.SpringbootBlog.UdemyBlog.Entity.Comment;

public interface CommentRepository extends JpaRepository<Comment,Long>
{
    List<Comment> findByPostId(long postId);
}
