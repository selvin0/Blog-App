package com.SpringbootBlog.UdemyBlog.excpetion;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException
{
     private String resourceName;
     private String FieldName;
     private Long FieldValue;
     
	 public ResourceNotFoundException(String resourceName, String fieldName, Long fieldValue)
	 {
	 super(String.format("%s not found with %s: %s",resourceName,fieldName,fieldValue));
	 //post not found with id:1;
		this.resourceName = resourceName;
		FieldName = fieldName;
		FieldValue = fieldValue;
	 }
		
	 public String getResourceName()
	 {
		return resourceName;
	 }
	 public String getFieldName()
	 {
		return FieldName;
	 }
	 public Long getFieldValue()
	 {
		return FieldValue;
	 }
}
