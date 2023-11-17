package com.example.QuizPlatform.Controller;

import java.util.List;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.QuizPlatform.entity.Instructor;
import com.example.QuizPlatform.entity.QuizName;
import com.example.QuizPlatform.response.PayloadResponse;
import com.example.QuizPlatform.response.QuizListResponse;
import com.example.QuizPlatform.service.CreateQuizService;
import com.example.QuizPlatform.service.InstructorService;

import jakarta.validation.Valid;

@RestController
public class CreateQuizController {
	
	private static final Logger logger = LoggerFactory.getLogger(AuthController.class);
	
	@Autowired
	CreateQuizService createQuizService;
	
	@Autowired
	InstructorService instructorService;
	
	private static final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
	
	
	@PostMapping("create/quiz")
	public Object createQuiz(@Valid @RequestBody QuizName quizName) {
		
		quizName.setCode(generateString(7));
		
		try {
			  createQuizService.createQuiz(quizName);
			  PayloadResponse response = new PayloadResponse();
			  response.setError(false);
			  response.setError_code(111);
			  response.setMessage("Quiz created successfully");
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
	
	@PostMapping("get/all/quiz")
	public ResponseEntity<QuizListResponse> getAllQuizzes(@Valid @RequestBody QuizName quizName){
		
		int userId = quizName.getUserId();
		if(isUserValid(userId)) {
			List<QuizName> quizzes = createQuizService.getAllQuizzes(userId);
			return ResponseEntity.ok(new QuizListResponse(quizzes));
	    } else {
	        return ResponseEntity.badRequest().body(new QuizListResponse("Unauthorised user"));
	    }
				
	}
	private boolean isUserValid(int userId) {
		if(instructorService.userExists(userId)) {
			return true;
		}
	    
	    return false;
	}
	
	public String generateString(int length) {
	    Random random = new Random();
	    StringBuilder builder = new StringBuilder(length);

	    for (int i = 0; i < length; i++) {
	        builder.append(ALPHABET.charAt(random.nextInt(ALPHABET.length())));
	    }

	    return builder.toString();
	}
	
	@PostMapping("/instructor/quiz")
	public ResponseEntity<QuizListResponse> getInstructorQuizzes(@Valid @RequestBody QuizName quizName){
		
		int userId = quizName.getUserId();
		if(isUserValid(userId)) {
			List<QuizName> quizzes = createQuizService.getInstructorQuizzes(userId);
			return ResponseEntity.ok(new QuizListResponse(quizzes));
	    } else if(isUserValid(userId)) {
	    	List<QuizName> quizzes = createQuizService.getInstructorQuizzes(userId);
	    	if(quizzes.isEmpty()) {
	    		return ResponseEntity.ok(new QuizListResponse(quizzes));
	    	}
			return ResponseEntity.ok(new QuizListResponse(quizzes));
	    }
		else {
	        return ResponseEntity.badRequest().body(new QuizListResponse("Unauthorised user"));
	    }
				
	}

}
