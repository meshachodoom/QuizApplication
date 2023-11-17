package com.example.QuizPlatform.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.QuizPlatform.entity.Questions;
import com.example.QuizPlatform.repo.QuestionsRepo;

@Service
public class QuestionsService {

	@Autowired
	QuestionsRepo questionsRepo;
	
	public void createQuestions(Questions questions) {
		questionsRepo.save(questions);
	}
}
