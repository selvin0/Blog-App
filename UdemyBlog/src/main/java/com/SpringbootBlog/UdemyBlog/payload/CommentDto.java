package com.SpringbootBlog.UdemyBlog.payload;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class CommentDto
{
    private long id;
    //name should not be null or empty
    @NotEmpty(message="Name should not be null or empty")
    private String name;
    
    //Email should not be null or empty
    //Email field validation
    @NotEmpty(message="Email should not be null or Empty")
    @Email
    private String email;
    //comment body should not be empty
    //comment body must be contain 10 Characters
    
    @NotEmpty
    @Size(min=10,message="comment body must be contain 10 Characters")
    private String body;
    
    
    
	public CommentDto() {
	}
	public CommentDto(long id, String name, String email, String body) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.body = body;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	@Override
	public String toString() {
		return "CommentDto [id=" + id + ", name=" + name + ", email=" + email + ", body=" + body + "]";
	}
	
	
}
