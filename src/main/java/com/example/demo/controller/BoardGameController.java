package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.BoardGame;
import com.example.demo.repository.BoardGameRepository;


@RestController
public class BoardGameController {
	
	@Autowired
	BoardGameRepository boardGameRepository;
	
	@PostMapping("/boardgame")
	public ResponseEntity<Object> addBoardGame(@RequestBody BoardGame body){
		try {
			
			BoardGame newboardgame = boardGameRepository.save(body);
			return new ResponseEntity<>(newboardgame,HttpStatus.CREATED);
			
		} catch (Exception e) {
			System.out.print(e.getMessage());
			return new ResponseEntity<>("Internal server error",HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/boardgame")
	public ResponseEntity<Object> addAllBoardGame(){
		try {
			
			List<BoardGame> listboardgame = boardGameRepository.findAll();
			return new ResponseEntity<>(listboardgame,HttpStatus.OK);
			
		} catch (Exception e) {
			System.out.print(e.getMessage());
			return new ResponseEntity<>("Internal server error",HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/boardgame/{gameId}")
	public ResponseEntity<Object> getBoardGameById(@PathVariable("gameId")Integer gameId){
		try {
			
			Optional<BoardGame> foundboardgame = boardGameRepository.findById(gameId);
			if(foundboardgame.isPresent()) {
				BoardGame boardGame =foundboardgame.get();
				return new ResponseEntity<>(boardGame,HttpStatus.OK);
			}else {
				return new ResponseEntity<>("Bord Game Not Found",HttpStatus.BAD_REQUEST);
			}
			
		} catch (Exception e) {
			System.out.print(e.getMessage());
			return new ResponseEntity<>("Internal server error",HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping("boardgame/{gameId}")
	public ResponseEntity<Object> deleteBoardGameById(@PathVariable("gameId")Integer gameId){
		try {
			
			Optional<BoardGame> foundboardgame = boardGameRepository.findById(gameId);
			if(foundboardgame.isPresent()) {
				BoardGame boardGame =foundboardgame.get();
				
				boardGameRepository.delete(boardGame);
				
				return new ResponseEntity<>(boardGame,HttpStatus.OK);
			}else {
				return new ResponseEntity<>("Delete Game Not Found",HttpStatus.BAD_REQUEST);
			}
			
		} catch (Exception e) {
			System.out.print(e.getMessage());
			return new ResponseEntity<>("Internal server error",HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
