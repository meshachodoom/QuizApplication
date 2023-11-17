package com.example.QuizPlatform.dto;


public class StudentDTO {

	private int studentId;
	private String name;
	private String email;
	private String institution;
	private String password;
	
	public StudentDTO() {
		super();
	}

	public StudentDTO(int studentId, String name, String email, String institution, String password) {
		super();
		this.studentId = studentId;
		this.name = name;
		this.email = email;
		this.institution = institution;
		this.password = password;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getInstitution() {
		return institution;
	}

	public void setInstitution(String institution) {
		this.institution = institution;
	}
	

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
}
