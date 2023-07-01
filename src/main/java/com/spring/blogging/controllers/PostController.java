package com.spring.blogging.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.blogging.dtos.PostDto;
import com.spring.blogging.services.PostService;

@RestController
@RequestMapping(path = "/post")
public class PostController {
	
	@Autowired
	private PostService postService;
	
	@PostMapping(path = "/create/categoryId/{categoryId}/userId/{userId}")
	public ResponseEntity<PostDto> createPostUsingCategoryandUser(@Valid @RequestBody PostDto postDto,@PathVariable int categoryId,@PathVariable int userId){
		PostDto createdPost = this.postService.createPost(postDto, categoryId, userId);
		System.out.println(createdPost);
		return new ResponseEntity<PostDto>(createdPost, HttpStatus.CREATED);
	}

}
