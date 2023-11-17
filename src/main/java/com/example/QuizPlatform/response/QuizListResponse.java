package com.example.QuizPlatform.response;

import java.util.List;

import com.example.QuizPlatform.entity.QuizName;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"error", "error_code", "message", "quizzes"})
public class QuizListResponse {

	 private List<QuizName> quizzes;
	 private boolean error;
	 private int error_code;
	 private String message;

	    
	    public QuizListResponse(List<QuizName> quizzes) {
	    	this.setQuizzes(quizzes);
	    	this.setError(false);
	    	this.setError_code(111);
	        this.setMessage("Success");
	   
	    }

	    public QuizListResponse(String message) {
	    	this.setError(true);
	    	this.setError_code(112);
	    	this.setMessage(message);
	        this.setQuizzes(quizzes);
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

		public List<QuizName> getQuizzes() {
			return quizzes;
		}

		public void setQuizzes(List<QuizName> quizzes) {
			this.quizzes = quizzes;
		}
	    
}
