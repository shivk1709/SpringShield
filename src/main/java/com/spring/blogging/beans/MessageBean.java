package com.spring.blogging.beans;

public class MessageBean {
	
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "MessageBean [message=" + message + "]";
	}

	public MessageBean(String message) {
		super();
		this.message = message;
	}

}
