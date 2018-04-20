package com.FYP.Club.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.FYP.Club.model.Game;

@Repository
public interface GameRepository extends JpaRepository<Game, Long> {

	Game findByFinalScore(String v);


	ArrayList<Game> findByHomeSideId(Long id);

	ArrayList<Game> findByAwaySideId(Long id);

}