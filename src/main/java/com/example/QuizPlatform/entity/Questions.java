package com.example.QuizPlatform.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Questions {

	@Id
	private int id;
	private int quiz_id;
	private int user_id;
	private String question_text;
	
	public Questions() {
		
	}
	
	public Questions(int id, int quiz_id, int user_id, String question_text) {
		this.id = id;
		this.quiz_id = quiz_id;
		this.user_id = user_id;
		this.setQuestions(question_text);
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getQuiz_id() {
		return quiz_id;
	}
	public void setQuiz_id(int quiz_id) {
		this.quiz_id = quiz_id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getQuestions() {
		return question_text;
	}

	public void setQuestions(String question_text) {
		this.question_text = question_text;
	}
}
