package com.SpringbootBlog.UdemyBlog.Repository;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.SpringbootBlog.UdemyBlog.Entity.Role;

public interface RoleRepository extends JpaRepository<Role,Long>
{
           Optional<Role> findByName(String name); 
}
