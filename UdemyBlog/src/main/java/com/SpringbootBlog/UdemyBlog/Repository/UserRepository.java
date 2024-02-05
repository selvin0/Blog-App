package com.SpringbootBlog.UdemyBlog.Repository;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.SpringbootBlog.UdemyBlog.Entity.User;

public interface UserRepository extends JpaRepository<User,Long>
{
     Optional<User> findByEmail(String email);
     
     Optional<User> findByUsernameOrEmail(String username,String email);
     
     Optional<User> findByUsername(String name);
     
     Boolean exitsByUsername(String username);  // check this username exists or not
     
     Boolean existsByEmail(String email);       //check this email is exists or not
}
