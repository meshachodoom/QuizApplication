package com.example.QuizPlatform.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "student")
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "studentId", length = 45)
	private int studentId;
	
	@NotEmpty
	@Column(name = "name", length = 255)
	private String name;
	
	@Column( name = "email", length = 255)
	@Email
	@NotEmpty
	private String email;
	
	@NotEmpty
	@Column(name = "institution", length = 255)
	private String institution;
	
	@Column( name = "password", length = 255)
	@Size(min = 6, max = 60)
	@NotEmpty
	private String password;

	public Student() {
		
	}

	public Student(int studentId, @NotEmpty String name, @Email @NotEmpty String email, @NotEmpty String institution,
			@Size(min = 6, max = 60) @NotEmpty String password) {
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
