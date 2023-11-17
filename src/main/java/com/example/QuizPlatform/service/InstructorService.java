package com.example.QuizPlatform.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.QuizPlatform.dto.LoginDTO;
import com.example.QuizPlatform.entity.Instructor;
import com.example.QuizPlatform.repo.InstructorRepo;
import com.example.QuizPlatform.response.PayloadResponse;

@Service
public class InstructorService {
	
	@Autowired
	private InstructorRepo instructorRepo;
	
	@Autowired
	BCryptPasswordEncoder passwordEncoder;
	
	public void addInstructor(Instructor instructor) {
		instructorRepo.save(instructor);
	}
	
	public Boolean emailExists(String email) {
		instructorRepo.existsByEmail(email);
		return instructorRepo.existsByEmail(email);
	}
	
	public boolean userExists(int userId) {
		return instructorRepo.existsById(userId);
	}
	
//	public Boolean loadUserByEmail(String email) {
//		instructorRepo.findByEmail(email);
//		return instructorRepo.existsByEmail(email);
//	}
}
