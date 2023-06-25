package com.spring.blogging.dtos;


import java.util.Date;
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
	private String name;
	private String description;
	private Date insertDate;

}
