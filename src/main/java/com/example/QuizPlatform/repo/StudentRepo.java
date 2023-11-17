package com.example.QuizPlatform.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.QuizPlatform.entity.Student;

public interface StudentRepo extends JpaRepository<Student, Integer>{

	public Boolean existsByEmail(String email);

}
