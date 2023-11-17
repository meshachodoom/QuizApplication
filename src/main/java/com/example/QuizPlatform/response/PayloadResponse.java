package com.example.QuizPlatform.response;

public class PayloadResponse {

	private boolean error;
	private int error_code;
	private String message;
	
	public PayloadResponse() {
		
	}

	public PayloadResponse(boolean error, int error_code, String message) {
		super();
		this.error = error;
		this.error_code = error_code;
		this.message = message;
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
	
	
}
