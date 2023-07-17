package com.spring.blogging.beans;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "user")
public class User{
	
	@Id
	private String username;
	
	private String email;
	
	private String password;
	
	private String role;
	
	@JsonFormat(pattern = "yyyy-MM-dd")
	@Column(name = "DOB")
	private LocalDate age;
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)	
	private List<Post> posts;


}
