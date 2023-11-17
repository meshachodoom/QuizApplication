package com.example.QuizPlatform.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.QuizPlatform.dto.LoginDTO;
import com.example.QuizPlatform.entity.Instructor;
import com.example.QuizPlatform.repo.InstructorRepo;
import com.example.QuizPlatform.response.LoginResponse;
import com.example.QuizPlatform.response.PayloadResponse;

@Service
public class UserLoginService {
	
	@Autowired
	private InstructorRepo instructorRepo;
	
	@Autowired
	BCryptPasswordEncoder passwordEncoder;

	public LoginResponse loginInstructor (LoginDTO loginDTO) {
		Instructor instructor1 = instructorRepo.findByEmail(loginDTO.getEmail());
		if(instructor1 != null) {
			String password = loginDTO.getPassword();
	        String encodedPassword = instructor1.getPassword();
	        String userRole = instructor1.getRole();
	        String name = instructor1.getName();
	        int userId = instructor1.getInstructorId();
	        Boolean isPwdRight = passwordEncoder.matches(password, encodedPassword);
	       
	        Optional<Instructor> instructor = instructorRepo.findOneByEmailAndPassword(loginDTO.getEmail(), encodedPassword);
	        if(instructor.isPresent() && isPwdRight) {
	        	return new LoginResponse(false, 111, "Login Successful", userRole, name, userId);
	        }
	        else {
	        	return new LoginResponse(true, 112, "Wrong Password", " ", " ", 0);
	        }
		}
		else {
			return new LoginResponse(true, 113, "Email does not exist", " ", " ", 0);
		}

	}

}
