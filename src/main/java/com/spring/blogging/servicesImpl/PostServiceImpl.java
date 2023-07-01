package com.spring.blogging.servicesImpl;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.blogging.beans.Category;
import com.spring.blogging.beans.Post;
import com.spring.blogging.beans.User;
import com.spring.blogging.daos.CategoryDao;
import com.spring.blogging.daos.PostDao;
import com.spring.blogging.daos.UserDao;
import com.spring.blogging.dtos.PostDto;
import com.spring.blogging.exceptions.ResourceNotFoundException;
import com.spring.blogging.services.PostService;


@Service
public class PostServiceImpl implements PostService {
	
	@Autowired
	private CategoryDao categoryDao;
	@Autowired
	private UserDao userDao;
	@Autowired
	private PostDao postDao;
	@Autowired
	private ModelMapper modelMapper;
	
	Logger logger = LoggerFactory.getLogger(PostServiceImpl.class);

	@Override
	public PostDto createPost(PostDto postDto, int categoryId, int userId) {
		
		// TODO Auto-generated method stub
		
		Category category = this.categoryDao.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException("Category", "Not Exist For Id", Long.valueOf(categoryId)));
		User user = this.userDao.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User", "Not Exist for Id", Long.valueOf(userId)));
		
		Post post = this.modelMapper.map(postDto, Post.class);
		post.setCategory(category);
		post.setUser(user);
		Post createdData = this.postDao.save(post);
		PostDto convertPostToPostDto = this.modelMapper.map(createdData, PostDto.class);
		return convertPostToPostDto;
	}

	@Override
	public PostDto findPostById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PostDto findAllPosts() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PostDto updatePostById(PostDto postDto, int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deletePostById(int id) {
		// TODO Auto-generated method stub
		
	}

}
