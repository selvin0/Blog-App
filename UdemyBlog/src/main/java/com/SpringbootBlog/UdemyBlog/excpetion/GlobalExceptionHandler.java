package com.SpringbootBlog.UdemyBlog.excpetion;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.SpringbootBlog.UdemyBlog.payload.ErrorDetails;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler
{
    //handler specific Exception
	@ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorDetails>handleResourceException(ResourceNotFoundException exception, 
			                                               WebRequest webRequest)
	{
		ErrorDetails errorDetails=new ErrorDetails(new Date(),
				exception.getMessage(),webRequest.getDescription(false));
		return new ResponseEntity<>(errorDetails,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(BlogApiException.class)
    public ResponseEntity<ErrorDetails>handleBlogException(ResourceNotFoundException exception, 
			                                               WebRequest webRequest)
	{
		ErrorDetails errorDetails=new ErrorDetails(new Date(),
				exception.getMessage(),webRequest.getDescription(false));
		return new ResponseEntity<>(errorDetails,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDetails>handleBlogException(Exception exception, 
			                                               WebRequest webRequest)
	{
		ErrorDetails errorDetails=new ErrorDetails(new Date(),
				exception.getMessage(),webRequest.getDescription(false));
		return new ResponseEntity<>(errorDetails,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatusCode status, WebRequest request)
	{
		Map<String,String> errors=new HashMap<String,String>();
		      ex.getBindingResult().getAllErrors().forEach((error)->{
		         String fieldName=((FieldError)error).getField();
		         String Message =error.getDefaultMessage();
		                 errors.put(fieldName, Message);
		      });
		return  new ResponseEntity<>(errors,HttpStatus.BAD_REQUEST);
	}
	
	 
//	@ExceptionHandler(MethodArgumentNotValidException.class)
//    public ResponseEntity<Object>MethodArgumentNotValidExceptionException(MethodArgumentNotValidException exception, 
//			                                                                    WebRequest webRequest)
//	{
//		Map<String,String> errors=new HashMap<String,String>();
//	      exception.getBindingResult().getAllErrors().forEach((error)->{
//	         String fieldName=((FieldError)error).getField();
//	         String Message =error.getDefaultMessage();
//	                 errors.put(fieldName, Message);
//	      });
//		
//		return new ResponseEntity<>(errors,HttpStatus.BAD_REQUEST);
//	}
	
}
