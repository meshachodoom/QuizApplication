package com.example.QuizPlatform.dto;


public class InstructorDTO {
	
	
	private int instructorId;
	private String name;
	private String role;
	//Role role;
	private String email;
	private String password;
	
	public InstructorDTO() {
		
	}

	public InstructorDTO(int instructorId, String name, String role, String email, String password) {
		super();
		this.instructorId = instructorId;
		this.name = name;
		this.setRole(role);
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

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

//	public Role getRole() {
//		return role;
//	}
//
//	public void setRole(Role role) {
//		if(role.toString() != "test") {
//			throw new IllegalArgumentException("Invalid role");
//		}
//       if (role == null || (!role.equals(Role.Admin) && !role.equals(Role.Instructor) && !role.equals(Role.Student)) ) {
//    	   throw new IllegalArgumentException("Invalid role");
//	    }
//	      this.role = role;
//	  }
	
}
