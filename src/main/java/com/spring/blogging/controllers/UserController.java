package com.spring.blogging.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.blogging.dtos.UserDto;
import com.spring.blogging.services.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping(path = "/all")
	public ResponseEntity<List<UserDto>> getAllUsers(){
		return new ResponseEntity<List<UserDto>>(this.userService.getAllUsers(), HttpStatus.FOUND);
	}

	@PostMapping(path = "/save")
	public ResponseEntity <UserDto> saveUser(@RequestBody UserDto userData) {
		UserDto user = this.userService.saveUser(userData);
		return new ResponseEntity <UserDto>(user, HttpStatus.CREATED);
	}
	
	@GetMapping(path = "/findById/{id}")
	public ResponseEntity<UserDto> findUserById(@PathVariable int id) {	
		UserDto userDto = this.userService.findById(id);
		return new ResponseEntity<UserDto>(userDto, HttpStatus.FOUND);
	}
	
	
	@DeleteMapping(path = "/deleteById/{id}")
	public ResponseEntity<String> deleteUserById(@PathVariable int id) {
		String response = this.userService.deleteById(id);
		return new ResponseEntity<String>(response, HttpStatus.OK);
	}
	
	@PutMapping(path = "/update/{id}")
	public ResponseEntity<UserDto> updateUser(@RequestBody UserDto userDto, @PathVariable int id){
		UserDto updatedUser = this.userService.updateUser(userDto, id);
		return new ResponseEntity<UserDto>(updatedUser, HttpStatus.ACCEPTED);
	}
}
