package com.spring.blogging.dtos;

import java.time.LocalDate;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

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
		
}
