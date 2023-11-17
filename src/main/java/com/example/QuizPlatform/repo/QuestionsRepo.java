package com.example.QuizPlatform.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.QuizPlatform.entity.Questions;

public interface QuestionsRepo extends JpaRepository<Questions, Integer>{

}
