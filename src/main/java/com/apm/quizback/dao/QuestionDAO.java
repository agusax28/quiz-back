package com.apm.quizback.dao;

import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.apm.quizback.model.Question;

@Repository
public interface QuestionDAO extends PagingAndSortingRepository<Question, Integer>{
	
	//1
	Optional<Question> findOneByIdQuestion(int id);
	
	//Nombre
	Optional<Question> findOneByName(String name);

}
