package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Review;
import com.example.demo.repository.ReviewRepository;


@RestController
public class RevivewController {
	
	@Autowired
	ReviewRepository reviewRepository;
	
	@PostMapping("/review")
	public ResponseEntity<Object> addReview(@RequestBody Review body){
		try {
			
			Review newReview = reviewRepository.save(body);
			return new ResponseEntity<>(newReview,HttpStatus.CREATED);
			
		} catch (Exception e) {
			System.out.print(e.getMessage());
			return new ResponseEntity<>("Internal server error",HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
