package com.spring.blogging.servicesImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.spring.blogging.beans.CustomUserDetail;
import com.spring.blogging.beans.User;
import com.spring.blogging.daos.UserDao;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
	private UserDao userDao;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
		// TODO Auto-generated method stub
		User user = this.userDao.findByUsername(username);
		if(user == null) {
			throw new UsernameNotFoundException("Not Found");
		}
		return new CustomUserDetail(user);
	}

}
