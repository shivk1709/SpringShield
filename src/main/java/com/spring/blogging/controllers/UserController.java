package com.spring.blogging.controllers;

import java.util.List;

import javax.validation.Valid;

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

	@PostMapping(path = "/create")
	public ResponseEntity <UserDto> saveUser(@Valid @RequestBody UserDto userData) {
		UserDto user = this.userService.saveUser(userData);
		return new ResponseEntity <UserDto>(user, HttpStatus.CREATED);
	}
	
	@GetMapping(path = "/findById/{name}")
	public ResponseEntity<UserDto> findUserById(@PathVariable String name) {	
		UserDto userDto = this.userService.findById(name);
		return new ResponseEntity<UserDto>(userDto, HttpStatus.FOUND);
	}
	
	@DeleteMapping(path = "/delete/{name}")
	public ResponseEntity<String> deleteUserById(@PathVariable String name) {
		String response = this.userService.deleteById(name);
		return new ResponseEntity<String>(response, HttpStatus.OK);
	}
	
	@PutMapping(path = "/update/{name}")
	public ResponseEntity<UserDto> updateUser(@Valid @RequestBody UserDto userDto, @PathVariable String name){
		UserDto updatedUser = this.userService.updateUser(userDto, name);
		return new ResponseEntity<UserDto>(updatedUser, HttpStatus.ACCEPTED);
	}
}
