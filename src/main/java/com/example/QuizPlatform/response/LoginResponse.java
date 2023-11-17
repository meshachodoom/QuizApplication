package com.example.QuizPlatform.response;

public class LoginResponse {

	private boolean error;
	private int error_code;
	private int userId;
	private String message;
	private String role;
	private String name;
	
	public LoginResponse() {
		
	}

	public LoginResponse(boolean error, int error_code, String message, String role, String name, int userId) {
		super();
		this.error = error;
		this.error_code = error_code;
		this.message = message;
		this.role = role;
		this.name = name;
		this.setUserId(userId);
	}
	
	public boolean isError() {
		return error;
	}
	public void setError(boolean error) {
		this.error = error;
	}
	
	public int getError_code() {
		return error_code;
	}
	public void setError_code(int error_code) {
		this.error_code = error_code;
	}
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	
}
