package com.spring.blogging.services;

import com.spring.blogging.dtos.PostDto;
import java.util.List;

public interface PostService {
	
	public PostDto createPost(PostDto postDto, int categoryId, String name);
	public PostDto findPostById(int postId);
	public List<PostDto> findAllPosts();
	public PostDto updatePostById(PostDto postDto, int psotId);
	public String deletePostById(int id);

	public List<PostDto> getPostsByCategoryId(int categoryId);

	public List<PostDto> getPostsByUserId(String name);

}
