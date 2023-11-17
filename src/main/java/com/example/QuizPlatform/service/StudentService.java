package com.example.QuizPlatform.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.QuizPlatform.entity.Student;
import com.example.QuizPlatform.repo.StudentRepo;

@Service
public class StudentService {

	@Autowired
	private StudentRepo studentRepo;
	
	public void addStudent(Student student) {
		studentRepo.save(student);
	}
	
	public boolean emailExists(String email) {
		studentRepo.existsByEmail(email);
		return studentRepo.existsByEmail(email);
	}
}
