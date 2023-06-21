package com.spring.blogging.beans;

import java.time.LocalDate;

public class User {
	
	private Integer id;
	private String name;
	private LocalDate age;
	
	public User(Integer id, String name, LocalDate age) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

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

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", age=" + age + "]";
	}
	
	
	
	
	

}
