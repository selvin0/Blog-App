package com.SpringbootBlog.UdemyBlog.payload;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class PostDto
{
    private long id;
    
    //title should not null
  	//title should have least two characters
    @NotEmpty
	@Size(min=2,message ="post title should have 2 characters")
    private String title;
    
    //title should not null
  	//title should have least ten characters
    @NotEmpty
    @Size(min=10,message="post description should have 10 characters")
    private String description;
    
    //title should be not null or empty
    @NotEmpty
    private String content;
    
    
	public PostDto() {
	}
	public PostDto(long id, String title, String description, String content) {
		this.id = id;
		this.title = title;
		this.description = description;
		this.content = content;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
    
}
