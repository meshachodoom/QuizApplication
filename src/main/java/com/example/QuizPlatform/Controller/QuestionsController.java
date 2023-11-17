package com.example.QuizPlatform.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.QuizPlatform.entity.Questions;
import com.example.QuizPlatform.response.PayloadResponse;
import com.example.QuizPlatform.service.QuestionsService;

import jakarta.validation.Valid;

@RestController
public class QuestionsController {
	
	private static final Logger logger = LoggerFactory.getLogger(AuthController.class);

	@Autowired
	QuestionsService questionsService;
	
	@PostMapping("instructor/create/question")
	public Object createQuestions(@Valid @RequestBody Questions questions) {
		try {
			  questionsService.createQuestions(questions);
			  PayloadResponse response = new PayloadResponse();
			  response.setError(false);
			  response.setError_code(111);
			  response.setMessage("Questions created successfully");
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
}
