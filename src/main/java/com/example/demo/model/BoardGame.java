package com.example.demo.model;


import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "BoardGame")
public class BoardGame {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer gameId;
	
	private String title;
	private String description;
	
	@OneToMany
	@JoinColumn(name = "gameId")
	private List<Review>review;
	
	public BoardGame() {
		super();
	}

	public BoardGame(Integer gameId, String title, String description, List<Review> review) {
		super();
		this.gameId = gameId;
		this.title = title;
		this.description = description;
		this.review = review;
	}

	public Integer getGameId() {
		return gameId;
	}

	public void setGameId(Integer gameId) {
		this.gameId = gameId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Review> getReview() {
		return review;
	}

	public void setReview(List<Review> review) {
		this.review = review;
	}

	
}
