package com.spring.blogging.servicesImpl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.blogging.beans.User;
import com.spring.blogging.daos.UserDao;
import com.spring.blogging.dtos.UserDto;
import com.spring.blogging.exceptions.ResourceNotFoundException;
import com.spring.blogging.services.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	private List<UserDto> userDto;
	
	@Autowired
	private UserDao userDao;
	@Autowired
	private ModelMapper modelmapper;
	
	public UserServiceImpl() {
		super();
		userDto = new ArrayList<>();
		userDto.add(new UserDto(1,"Shiv", LocalDate.now().minusYears(30)));
		userDto.add(new UserDto(2,"Kumar",LocalDate.now().minusYears(22)));	
		
	}

	@Override
	public List<UserDto> getAllUsers() {
		// TODO Auto-generated method stub
		userDto.stream().collect(Collectors.toList());
		return userDto.stream().map(user -> this.modelmapper.map(user, UserDto.class)).collect(Collectors.toList());
	}

	@Override
	public UserDto saveUser(UserDto userData) {
		// TODO Auto-generated method stub
		User user = this.modelmapper.map(userData, User.class);
//		this.userDao.save(user);
		
		return this.modelmapper.map(this.userDao.save(user), UserDto.class);
//		this.userDto.add(userData);
//		return userData;
	}

	@Override
	public UserDto findById(int id) {
		// TODO Auto-generated method stub
//		return this.userDto.stream()
//				.filter(user -> user.getId().equals(id))
//				.findFirst().get();
		User user =  this.userDao.findById(id).orElseThrow(()-> new ResourceNotFoundException("User", " Id ", Long.valueOf(id)));
		return this.modelmapper.map(user, UserDto.class);
		 
	}


	@Override
	public UserDto updateUser(UserDto userData, int id) {
		// TODO Auto-generated method stub
		User user = this.userDao.findById(id).orElseThrow(() -> new ResourceNotFoundException("User", " Not found having Id ", Long.valueOf(id)));
		user.setName(userData.getName());
		user.setAge(userData.getAge());
		User updatedUser = this.userDao.save(user);
		UserDto converUserBeantToUserDto = this.modelmapper.map(updatedUser, UserDto.class);
		return converUserBeantToUserDto;
	}

	@Override
	public String deleteById(int id) {
		// TODO Auto-generated method stub
//		UserDto userData = this.userDto.stream().filter(user -> user.getId().equals(id)).findFirst().orElse(null);
//		this.userDto.remove(userData);
//		System.out.println("Removed Successfully");
		this.userDao.deleteById(id);
		return "Deleted Successfully";
	}

}
