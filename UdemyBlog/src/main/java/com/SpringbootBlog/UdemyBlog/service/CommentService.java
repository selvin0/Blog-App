package com.SpringbootBlog.UdemyBlog.service;
import java.util.List;

import com.SpringbootBlog.UdemyBlog.payload.CommentDto;

public interface CommentService
{
     CommentDto createComment(long postId,CommentDto commentDto);
     
     List<CommentDto> getCommentByPostId(long postId);
     
     CommentDto getCommentById(long postId,long commentId);
     
     CommentDto updateComment(Long postId,long commentId,CommentDto commentRequest);
     
     void deleteComment(Long postId,Long commentId);
     
}
