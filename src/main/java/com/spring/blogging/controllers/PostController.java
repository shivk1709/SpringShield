package com.spring.blogging.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.spring.blogging.dtos.PostDto;
import com.spring.blogging.services.PostService;

import java.util.List;

@RestController
@RequestMapping(path = "/post")
public class PostController {
	
	@Autowired
	private PostService postService;
	
	@PostMapping(path = "/create/categoryId/{categoryId}/userId/{userId}")
	public ResponseEntity<PostDto> createPostUsingCategoryandUser(@Valid @RequestBody PostDto postDto,@PathVariable int categoryId,@PathVariable int userId){
		PostDto createdPost = this.postService.createPost(postDto, categoryId, userId);
		return new ResponseEntity<PostDto>(createdPost, HttpStatus.CREATED);
	}

	@GetMapping(path = "/byCategoryId/{categoryId}")
	public ResponseEntity<List<PostDto>> getAllPostsByCategoryId(@PathVariable int categoryId){
		List<PostDto> allPostByCategoryId = this.postService.getPostsByCategoryId(categoryId);
		return new ResponseEntity<List<PostDto>>(allPostByCategoryId, HttpStatus.OK);
	}
	
	@GetMapping(path = "/byUserId/{userId}")
	public ResponseEntity<List<PostDto>> getAllPostsByUserId(@PathVariable int userId){
		List<PostDto> posts = this.postService.getPostsByUserId(userId);
		return new ResponseEntity<List<PostDto>>(posts, HttpStatus.FOUND);
	}
	
	@GetMapping(path = "/byPostId/{postId}")
	public ResponseEntity<PostDto> findPostById(@PathVariable int postId){
		PostDto postDto = this.postService.findPostById(postId);
		return new ResponseEntity<PostDto>(postDto,HttpStatus.FOUND);
	}
	
	@GetMapping(path = "/allPosts")
	public ResponseEntity<List<PostDto>> allPosts(){
		List<PostDto> listOfAllPosts = this.postService.findAllPosts();
		return new ResponseEntity<List<PostDto>>(listOfAllPosts, HttpStatus.FOUND);
	}
	
	@DeleteMapping("/deleteByPostId/{postId}")
	public ResponseEntity<String> deletePostByPostId(@PathVariable int postId){
		String deleteMessage = this.postService.deletePostById(postId);
		return new ResponseEntity<String>(deleteMessage, HttpStatus.OK);
	}

}
