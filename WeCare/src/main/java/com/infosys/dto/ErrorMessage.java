package com.infosys.dto;

import org.springframework.stereotype.Component;

@Component
public class ErrorMessage {
	String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "ErrorMessage [message=" + message + "]";
	}

	
}
