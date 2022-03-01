package com.te.markupcar.dto;

import com.fasterxml.jackson.annotation.JsonIncludeProperties;

@JsonIncludeProperties
public class AdminResponse {
	private boolean error;
	private String message;
	private String token;
	
	public boolean isError() {
		return error;
	}
	public void setError(boolean error) {
		this.error = error;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	
	public AdminResponse(boolean error, String message, String token) {
		super();
		this.error = error;
		this.message = message;
		this.token = token;
		
	}
	
	
	
	


}
