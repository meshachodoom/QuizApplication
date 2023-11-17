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
@Table(name = "users")
public class Instructor {
	
	
	@Id
	@Column( name = "instructorId")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int instructorId;
	
	@Column( name = "name", length = 255)
	@NotEmpty
	private String name;
	
	@Column( name = "role", length = 255)
	@NotEmpty
	private String role;
	
	@Column( name = "email", length = 255)
	@Email
	@NotEmpty
	private String email;
	
	@Column( name = "password", length = 255)
	@Size(min = 6, max = 60)
	@NotEmpty
    String password;

	public Instructor() {
		
	}

	public Instructor(int instructorId, String name, String role, String email, String password) {
		super();
		this.instructorId = instructorId;
		this.name = name;
		this.role = role;
		this.email = email;
		this.password = password;
	}

	public int getInstructorId() {
		return instructorId;
	}

	public void setInstructorId(int instructorId) {
		this.instructorId = instructorId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	

}
