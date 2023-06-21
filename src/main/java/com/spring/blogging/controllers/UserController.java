package com.spring.blogging.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.blogging.dtos.UserDto;
import com.spring.blogging.services.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping(path = "/getUsers")
	public List<UserDto> getAllUsers(){
		return this.userService.getAllUsers();
	}

	@PostMapping(path = "/userData")
	public UserDto saveUser(@RequestBody UserDto userData) {
		return this.userService.saveUser(userData);
	}
	
	public UserDto findUserById(int id) {	
	}
	
	
	@DeleteMapping(path = "/deleteById/{id}")
	public void deleteUserById(int id) {
		this.userService.deleteById(id);
		System.out.println("Data deleted Successfully");
	}
}
