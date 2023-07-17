package com.spring.blogging.services;

import java.util.List;

import com.spring.blogging.dtos.UserDto;

public interface UserService {
	
	public List<UserDto> getAllUsers();
	public UserDto saveUser(UserDto userData);
	public UserDto findById(String id);
	public String deleteById(String id);
	public UserDto updateUser(UserDto userData, String id);

}
