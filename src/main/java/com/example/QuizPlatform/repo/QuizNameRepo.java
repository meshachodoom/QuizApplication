package com.example.QuizPlatform.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.QuizPlatform.entity.QuizName;


public interface QuizNameRepo extends JpaRepository<QuizName, Integer>{

	public List<QuizName> findByUserId(int id);
}
