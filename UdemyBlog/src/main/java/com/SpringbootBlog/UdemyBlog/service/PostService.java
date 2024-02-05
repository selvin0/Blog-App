package com.SpringbootBlog.UdemyBlog.service;
import com.SpringbootBlog.UdemyBlog.payload.PostDto;
import com.SpringbootBlog.UdemyBlog.payload.PostResponse;

public interface PostService
{
     PostDto createPost(PostDto postDto);
     
     PostResponse getAllPosts(int pageNo,int pageSize,String sortBy,String sortDir);
     
     PostDto getPostById(Long id);
     
     PostDto updatePost(PostDto postDto,long id);
     
     void deletePostById(long id);
}
