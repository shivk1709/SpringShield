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

import java.util.List;
import java.util.stream.Collectors;


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
	public PostDto createPost(PostDto postDto, int categoryId, String name) {
		// TODO Auto-generated method stub
		Category category = this.categoryDao.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException("Category", "Not Exist For Id", Long.valueOf(categoryId)));
		User user = this.userDao.findByUsername(name);
		
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
		Post postById = this.postDao.findById(id).orElseThrow(() -> new ResourceNotFoundException("Post not Exist", " for the given Id: ", Long.valueOf(id)));
		return this.modelMapper.map(postById,PostDto.class);
	}

	@Override
	public List<PostDto> findAllPosts() {
		// TODO Auto-generated method stub
		List<Post> listOfallPost = this.postDao.findAll();
		return listOfallPost.stream().map(post -> this.modelMapper.map(post, PostDto.class)).collect(Collectors.toList());
	}

	@Override
	public PostDto updatePostById(PostDto postDto, int postId) {
		// TODO Auto-generated method stub
		Post postfindByGivenId = this.postDao.findById(postId).orElseThrow(() -> new ResourceNotFoundException("Post not there", "for the given id", Long.valueOf(postId)));
		postfindByGivenId.setAbout(postDto.getAbout());
		postfindByGivenId.setTitle(postDto.getTitle());		
		postDao.save(postfindByGivenId);
		return this.modelMapper.map(postfindByGivenId, PostDto.class);
	}

	@Override
	public String deletePostById(int postId) {
		// TODO Auto-generated method stub
		this.postDao.deleteById(postId);
		return "Post Deleted Successfully";
		
	}

	@Override
	public List<PostDto> getPostsByCategoryId(int categoryId) {
		Category category = this.categoryDao.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException("Category Not Exist", "with the Id", Long.valueOf(categoryId)));
		List<Post> postsByCategory = this.postDao.findByCategory(category);
		return postsByCategory.stream().map(post  -> this.modelMapper.map(post, PostDto.class)).collect(Collectors.toList());
	}

	@Override
	public List<PostDto> getPostsByUserId(String name) {
		User user = this.userDao.findByUsername(name);
		List<Post> allPostsByUserId = this.postDao.findByUser(user);
		return allPostsByUserId.stream().map(post -> this.modelMapper.map(post, PostDto.class)).collect(Collectors.toList());
	}

}
