package com.SpringbootBlog.UdemyBlog.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.SpringbootBlog.UdemyBlog.Entity.Post;

public interface PostRepository extends JpaRepository<Post,Long>
{
     
}
