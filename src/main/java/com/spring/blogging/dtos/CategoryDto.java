package com.spring.blogging.dtos;


import java.util.Date;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class CategoryDto {
	
	private Integer id;
	
	@NotEmpty
	@Size(max = 12, message = "Username too long")
	private String categoryName;
	
	@NotEmpty
	@Size(min = 5, message = "Please give brief description")
	private String categoryDescription;
	
	@JsonFormat(pattern = "yyyy-mm-dd")
	private Date insertDate;
	

}
