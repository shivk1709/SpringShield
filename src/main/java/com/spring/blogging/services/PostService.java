package com.spring.blogging.services;

import com.spring.blogging.dtos.PostDto;

public interface PostService {
	
	public PostDto createPost(PostDto postDto, int categoryId, int userId);
	public PostDto findPostById(int id);
	public PostDto findAllPosts();
	public PostDto updatePostById(PostDto postDto, int id);
	public void deletePostById(int id);

}
