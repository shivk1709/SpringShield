package com.spring.blogging.dtos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.spring.blogging.beans.Post;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserDto {
	
	private Integer id;
	
	@NotEmpty
	@Size(max = 10, message = "Username too long")
	private String name;
	
	@NotEmpty
	@Email(message = "Please enter the valid email !!")
	private String email;
	
	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate age;
	
	private Set<Post> postSet = new HashSet<>();
		
}
