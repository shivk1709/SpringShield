package com.spring.blogging.dtos;

import java.time.LocalDate;

public class UserDto {
	
	private Integer id;
	private String name;
	private LocalDate age;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public LocalDate getAge() {
		return age;
	}
	public void setAge(LocalDate age) {
		this.age = age;
	}
	public UserDto(Integer id, String name, LocalDate age) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
	}
	public UserDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "UserDto [id=" + id + ", name=" + name + ", age=" + age + "]";
	}

	
}
