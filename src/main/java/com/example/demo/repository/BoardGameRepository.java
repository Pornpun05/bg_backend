package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.BoardGame;

@Repository
public interface BoardGameRepository extends JpaRepository<BoardGame, Integer> {

}
