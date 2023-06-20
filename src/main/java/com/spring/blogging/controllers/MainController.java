package com.spring.blogging.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.spring.blogging.beans.MessageBean;

@RestController
public class MainController {

	@GetMapping(path = "/message")
	public String print_hello_world() {
		return "Hello-World";
	}
	
	@GetMapping(path = "bean-message")
	public MessageBean message() {
		return new MessageBean("Hello-World by Bean");
	}
	
	@GetMapping(path = "username/{name}")
	public MessageBean username(@PathVariable String sname) {
		return new MessageBean(String.format("Hello World %s", sname));
	}
}
