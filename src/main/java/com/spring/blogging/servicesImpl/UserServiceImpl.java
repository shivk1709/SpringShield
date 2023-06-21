package com.spring.blogging.servicesImpl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.spring.blogging.dtos.UserDto;
import com.spring.blogging.services.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	private List<UserDto> userDto;
	
	public UserServiceImpl() {
		super();
		userDto = new ArrayList<>();
		userDto.add(new UserDto(1,"Shiv", LocalDate.now().minusYears(30)));
		userDto.add(new UserDto(2,"Kumar",LocalDate.now().minusYears(22)));	
		
	}

	@Override
	public List<UserDto> getAllUsers() {
		// TODO Auto-generated method stub
		return userDto.stream().collect(Collectors.toList());
	}

	@Override
	public UserDto saveUser(UserDto userData) {
		// TODO Auto-generated method stub
		this.userDto.add(userData);
		return userData;
	}

	@Override
	public UserDto findById(int id) {
		// TODO Auto-generated method stub
		return this.userDto.stream()
				.filter(user -> user.getId().equals(id))
				.findFirst().get();
	}


	@Override
	public UserDto updateUser(UserDto userData, int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub
//		Optional<UserDto> userData = this.userDto.stream().filter(user -> user.getId().equals(id)).findFirst().get();
//		System.out.println(userData.get());
		
	}

}
