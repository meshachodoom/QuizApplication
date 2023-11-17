package com.example.QuizPlatform.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.QuizPlatform.entity.Instructor;
import com.example.QuizPlatform.entity.QuizName;
import com.example.QuizPlatform.repo.QuizNameRepo;


@Service
public class CreateQuizService {

	@Autowired
	private QuizNameRepo quizNameRepo;
	
	
	public void createQuiz(QuizName quizName) {
		quizNameRepo.save(quizName);
	}
	
	public List<QuizName> getAllQuizzes(int userId){
		List<QuizName> quizzes = new ArrayList<>();
		quizNameRepo.findAll()
		.forEach(quizzes::add);
		return quizzes;	
	}
	
	public List<QuizName> getInstructorQuizzes(int userId){
		List<QuizName> quizzes = new ArrayList<>();
		quizNameRepo.findByUserId(userId)
		.forEach(quizzes::add);
		return quizzes;	
	}
}
