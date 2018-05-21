package com.apm.quizback.dao;

import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.apm.quizback.model.Result;

public interface ResultDAO extends PagingAndSortingRepository<Result, Integer>{
	
	//Todos
	Optional<Result> findOrderByIdResultDesc();
	
	//1
	Optional<Result> findOneByIdResult(int id);
	
	//Nombre
	Optional<Result> findOneByName(String name);

}