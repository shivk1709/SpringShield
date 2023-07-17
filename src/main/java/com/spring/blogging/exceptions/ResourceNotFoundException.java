package com.spring.blogging.exceptions;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ResourceNotFoundException extends RuntimeException {
	private String resourceName;
	private String columnName;
	private Long value;
	private String name;
	
	public ResourceNotFoundException(String resourceName, String columnName, Long value) {
		super(String.format("%s not found with %s : %s", resourceName, columnName, value));
		this.resourceName = resourceName;
		this.columnName = columnName;
		this.value = value;
	}
	

}
