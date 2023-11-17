package com.example.QuizPlatform.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
//@Table(name = "quiz_name")
public class QuizName {
	
	@Id
	private int id;
	private String title;
	private String code;
	private int userId;
	
//	@ManyToOne
//	private Instructor instructor;

	
	public QuizName() {
		
	}
	
	public QuizName(int id, String title, String code, int userId) {
		super();
		this.id = id;
		this.title = title;
		this.code = code;
		this.userId = userId;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
//	public Instructor getInstructor() {
//		return instructor;
//	}
//	public void setInstructor(Instructor instructor) {
//		this.instructor = instructor;
//	}

}
