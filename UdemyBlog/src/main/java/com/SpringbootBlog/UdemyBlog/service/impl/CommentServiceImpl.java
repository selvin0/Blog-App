package com.SpringbootBlog.UdemyBlog.service.impl;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.SpringbootBlog.UdemyBlog.Entity.Comment;
import com.SpringbootBlog.UdemyBlog.Entity.Post;
import com.SpringbootBlog.UdemyBlog.Repository.CommentRepository;
import com.SpringbootBlog.UdemyBlog.Repository.PostRepository;
import com.SpringbootBlog.UdemyBlog.excpetion.BlogApiException;
import com.SpringbootBlog.UdemyBlog.excpetion.ResourceNotFoundException;
import com.SpringbootBlog.UdemyBlog.payload.CommentDto;
import com.SpringbootBlog.UdemyBlog.service.CommentService;

@Service
public class CommentServiceImpl implements CommentService
{
	private CommentRepository commentRepository;
	private PostRepository postRepository;
	private ModelMapper mapper;
	
	public CommentServiceImpl(CommentRepository commentRepository,PostRepository postRepository,ModelMapper mapper)
	{
		this.commentRepository = commentRepository;
		this.postRepository=postRepository;
		this.mapper=mapper;
	}

	@Override
	public CommentDto createComment(long postId, CommentDto commentDto)
	{		
		Comment comment=mapToEntity(commentDto);
		//retrive post entity By id
		Post post=postRepository.findById(postId).orElseThrow(()->new ResourceNotFoundException("Post","id",postId));
		
		//set post to comment entity
		comment.setPost(post);
		//comment entity to db
		Comment newComment=commentRepository.save(comment);
		return mapToDto(newComment);
	}
	
	@Override
	public List<CommentDto> getCommentByPostId(long postId)
	{  //retrieve comments by postId
		List<Comment> comments=commentRepository.findByPostId(postId);
		
		//convert list of comment entities to list of comment dto's
		return comments.stream().map(com->mapToDto(com)).collect(Collectors.toList());
	}
	
	@Override
	public CommentDto getCommentById(long postId, long commentId)
	{
		Post post=postRepository.findById(postId).orElseThrow(
				()->new ResourceNotFoundException("Post","id",postId));
		
	Comment comment=commentRepository.findById(commentId).orElseThrow(
			()->new ResourceNotFoundException("comment","commentId",postId));
	
	      if(!comment.getPost().getId().equals(post.getId()))
	      {
	    	throw new BlogApiException(HttpStatus.BAD_REQUEST,"comment does not belong to post");
	      }
		return mapToDto(comment);
	}
	
	
	@Override
	public CommentDto updateComment(Long postId, long commentId, CommentDto commentRequest)
	{
		Post post=postRepository.findById(postId).orElseThrow(
				()->new ResourceNotFoundException("Post","id",postId));
		
		Comment comment=commentRepository.findById(commentId).orElseThrow(
				()->new ResourceNotFoundException("comment","commentId",postId));
		
		  if(!comment.getPost().getId().equals(post.getId()))
		  {
			  throw new BlogApiException(HttpStatus.BAD_REQUEST,"Comment does not belongs to post");
		  }
		  
		  comment.setName(commentRequest.getName());
		  comment.setEmail(commentRequest.getEmail());
		  comment.setBody(commentRequest.getBody());
		  
		  Comment updateComment=commentRepository.save(comment);
			return mapToDto(updateComment);
	}
	
	
	@Override
	public void deleteComment(Long postId,Long commentId)
	{
		//retrive post entity by id
		Post post=postRepository.findById(postId).orElseThrow(
				()->new ResourceNotFoundException("Post","id",postId));
		
		//retrive comment by id
		Comment comment=commentRepository.findById(commentId).orElseThrow(
				()->new ResourceNotFoundException("comment","commentId",postId));
		
		  if(!comment.getPost().getId().equals(post.getId()))
		  {
			  throw new BlogApiException(HttpStatus.BAD_REQUEST,"Comment does not belongs to post");
		  }
		  
		  commentRepository.delete(comment);
		
	}
	
	private CommentDto mapToDto(Comment comment)
	{
//		CommentDto commentDto=new CommentDto();
//		           commentDto.setId(comment.getId());
//		           commentDto.setName(comment.getName());
//		           commentDto.setEmail(comment.getEmail());
//		           commentDto.setBody(comment.getBody());
		CommentDto commentDto=mapper.map(comment,CommentDto.class);
		           return commentDto;
	}
	
	
	private Comment mapToEntity(CommentDto commentDto)
	{
//		    Comment comment=new Comment();
//		            comment.setId(commentDto.getId());
//		            comment.setName(commentDto.getName());
//		            comment.setEmail(commentDto.getEmail());
//		            comment.setBody(commentDto.getBody());
		     Comment comment= mapper.map(commentDto,Comment.class);
		return comment;
	}

}
