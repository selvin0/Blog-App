package com.SpringbootBlog.UdemyBlog;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class UdemyBlogApplication
{
	@Bean
	public ModelMapper modelMapper ()
	{
		return new ModelMapper();
	}
	
	public static void main(String[] args)
	{
		SpringApplication.run(UdemyBlogApplication.class, args);
	}
}
