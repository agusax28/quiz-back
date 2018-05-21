package com.apm.quizback.dao;

import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.apm.quizback.model.Difficulty;

public interface DifficultyDAO extends PagingAndSortingRepository<Difficulty, Integer>{
	
	//1
	Optional<Difficulty> findOneByIdDifficulty(int id);
	
	//Nombre
	Optional<Difficulty> findOneByName(String name);

}
