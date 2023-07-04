package com.spring.blogging.services;

import com.spring.blogging.dtos.PostDto;
import java.util.List;

public interface PostService {
	
	public PostDto createPost(PostDto postDto, int categoryId, int userId);
	public PostDto findPostById(int id);
	public List<PostDto> findAllPosts();
	public PostDto updatePostById(PostDto postDto, int id);
	public String deletePostById(int id);

	public List<PostDto> getPostsByCategoryId(int categoryId);

	public List<PostDto> getPostsByUserId(int userId);

}
