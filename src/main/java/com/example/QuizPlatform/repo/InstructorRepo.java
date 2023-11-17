package com.example.QuizPlatform.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.example.QuizPlatform.dto.InstructorDTO;
import com.example.QuizPlatform.entity.Instructor;

public interface InstructorRepo extends JpaRepository<Instructor, Integer>{

	public Boolean existsByEmail(String email);
	
	Optional<Instructor> findOneByEmailAndPassword(String email, String password);
	Instructor findByEmail(String email);
	
}
