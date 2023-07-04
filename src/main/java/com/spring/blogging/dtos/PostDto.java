package com.spring.blogging.dtos;

import java.util.Date;
import javax.validation.constraints.NotNull;

import com.spring.blogging.beans.Category;
import com.spring.blogging.beans.User;
import org.hibernate.validator.constraints.Length;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
public class PostDto {

	private int id;
	
	@NotNull
	@Length(max = 100, min = 5)
	private String title;
	
	@NotNull
	@Length(max = 100, min = 5)
	private String about;
	
	private Date updated_on;
	
	private UserDto user;
	
	private CategoryDto category;


}
