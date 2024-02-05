package com.SpringbootBlog.UdemyBlog.excpetion;
import org.springframework.http.HttpStatus;

public class BlogApiException extends RuntimeException
{
       private HttpStatus status;
       private String messge;
       
	public BlogApiException(HttpStatus status, String messge)
	{
		super();
		this.status = status;
		this.messge = messge;
	}

	public HttpStatus getStatus() {
		return status;
	}

	public String getMessge() {
		return messge;
	}
	
	
       
       
}
