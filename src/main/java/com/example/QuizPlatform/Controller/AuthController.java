package com.example.QuizPlatform.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.QuizPlatform.dto.InstructorDTO;
import com.example.QuizPlatform.dto.LoginDTO;
import com.example.QuizPlatform.entity.Instructor;
import com.example.QuizPlatform.entity.Student;
import com.example.QuizPlatform.response.LoginResponse;
import com.example.QuizPlatform.response.PayloadResponse;
import com.example.QuizPlatform.service.InstructorService;
import com.example.QuizPlatform.service.StudentService;
import com.example.QuizPlatform.service.UserLoginService;

import jakarta.validation.Valid;

@RestController
public class AuthController {
	
	private static final Logger logger = LoggerFactory.getLogger(AuthController.class);
	
	@Autowired
	InstructorService instructorService;
	
	@Autowired
	StudentService studentService;
	
	@Autowired
	UserLoginService userLoginService;
	
	@Autowired
	BCryptPasswordEncoder passwordEncoder;
	
	
	@RequestMapping("/hello")
	public String welcome() {
		return "Here I am";
	}
	
	@PostMapping("/instructor/signup")
	public Object signup(@Valid @RequestBody Instructor instructor) {
		
		String hashedPassword = passwordEncoder.encode(instructor.getPassword());
		instructor.setPassword(hashedPassword);
		
		
		if(instructor != null && instructorService.emailExists(instructor.getEmail())) {
			  PayloadResponse response = new PayloadResponse();
				response.setError(true);
				response.setError_code(112);
				response.setMessage("Email already exists");
				return ResponseEntity.status(HttpStatus.OK).body(response);
		  }
		else if(instructor != null && !instructor.getRole().equals("student") && !instructor.getRole().equals("instructor") && !instructor.getRole().equals("admin")) {
			  PayloadResponse response = new PayloadResponse();
				response.setError(true);
				response.setError_code(112);
				response.setMessage("Invalid role");
				return ResponseEntity.status(HttpStatus.OK).body(response);
		  }
		  
		try {
		  
		  instructorService.addInstructor(instructor);
		  PayloadResponse response = new PayloadResponse();
		  response.setError(false);
		  response.setError_code(111);
		  response.setMessage("Registration Successful");
		  return ResponseEntity.status(HttpStatus.OK).body(response);
		 
	 }
		catch(Exception e) {
			PayloadResponse response = new PayloadResponse();
			response.setError(true);
			response.setError_code(113);
			response.setMessage("Error occured");
			logger.error("An error occurred: " + e.getMessage());

			
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
		}
	}
	 @PostMapping("/student/signup")
	public Object studentSignup(@Valid @RequestBody Student student) {
		
		String hashedPassword = passwordEncoder.encode(student.getPassword());
		student.setPassword(hashedPassword);
		
		
		if(student != null && studentService.emailExists(student.getEmail())) {
			PayloadResponse response = new PayloadResponse();
			response.setError(true);
			response.setError_code(112);
			response.setMessage("Email already exists");
			return ResponseEntity.status(HttpStatus.OK).body(response);
		}
		
		try {
		  
			studentService.addStudent(student);
			
			PayloadResponse response = new PayloadResponse();
			response.setError(false);
			response.setError_code(111);
			response.setMessage("Registration Successful");
			return ResponseEntity.status(HttpStatus.OK).body(response);
		
	   }
		catch(Exception e) {
			PayloadResponse response = new PayloadResponse();
			response.setError(true);
			response.setError_code(112);
			response.setMessage("Error occured");
			logger.error("An error occurred: " + e.getMessage());
			
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
		}
	}
	
	 @PostMapping("/login")
	 public ResponseEntity<?> loginUser(@RequestBody LoginDTO loginDTO)
	    {
	        LoginResponse loginResponse = userLoginService.loginInstructor(loginDTO);
	        return ResponseEntity.ok(loginResponse);
	    }
}
