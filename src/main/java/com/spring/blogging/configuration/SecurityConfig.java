package com.spring.blogging.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.spring.blogging.beans.CustomUserDetail;
import com.spring.blogging.servicesImpl.UserDetailsServiceImpl;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private UserDetailsServiceImpl userDetailsServiceImpl;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		http
			.csrf().disable()
			.authorizeRequests()
//			.antMatchers("/post/**").permitAll()
			.antMatchers("/post/**").hasRole("NORMAL")
			.antMatchers("/user/**", "/post/**", "/category/**").hasRole("ADMIN")
			.anyRequest()
			.authenticated()
			.and()
			.httpBasic();
//			.loginPage("/signin/"); to change the login page URL
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// TODO Auto-generated method stub
//		auth.inMemoryAuthentication().withUser("shiv").password(this.passwordEncoder().encode("shiv")).roles("NORMAL");
//		auth.inMemoryAuthentication().withUser("mahak").password(this.passwordEncoder().encode("mahak")).roles("ADMIN");
		
		auth.userDetailsService(userDetailsServiceImpl).passwordEncoder(passwordEncoder());
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
