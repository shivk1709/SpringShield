package com.spring.blogging.servicesImpl;

import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.spring.blogging.beans.User;
import com.spring.blogging.daos.UserDao;
import com.spring.blogging.dtos.UserDto;
import com.spring.blogging.exceptions.ResourceNotFoundException;
import com.spring.blogging.services.UserService;

@Service
public class UserServiceImpl implements UserService {
		
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private ModelMapper modelmapper;
	
	@Autowired    
	private PasswordEncoder passwordEncoder;
	
	
	@Override
	public List<UserDto> getAllUsers() {
		// TODO Auto-generated method stub
		List<User> users = this.userDao.findAll();
		return users.stream().map(user -> this.modelmapper.map(user, UserDto.class)).collect(Collectors.toList());
	}

	@Override
	public UserDto saveUser(UserDto userData) {
		// TODO Auto-generated method stub
		User user = this.modelmapper.map(userData, User.class);
		user.setRole("ROLE_"+user.getRole().toUpperCase());
		user.setPassword(this.passwordEncoder.encode(user.getPassword()));
		return this.modelmapper.map(this.userDao.save(user), UserDto.class);
	}

	@Override
	public UserDto findById(String name) {
		// TODO Auto-generated method stub
		User user =  this.userDao.findByUsername(name);
		return this.modelmapper.map(user, UserDto.class); 
	}
	
	@Override
	public UserDto updateUser(UserDto userData, String name) {
		// TODO Auto-generated method stub
		User user = this.userDao.findByUsername(name);
		user.setUsername(userData.getUsername());
		user.setEmail(userData.getEmail());
		User updatedUser = this.userDao.save(user);
		UserDto converUserBeantToUserDto = this.modelmapper.map(updatedUser, UserDto.class);
		return converUserBeantToUserDto;
	}

	@Override
	public String deleteById(String name) {
		// TODO Auto-generated method stub
		this.userDao.deleteByUsername(name);
		return "Deleted Successfully";
	}

}
