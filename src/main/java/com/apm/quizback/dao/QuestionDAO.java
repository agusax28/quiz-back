package com.apm.quizback.dao;

import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.apm.quizback.model.Question;

public interface QuestionDAO extends PagingAndSortingRepository<Question, Integer>{
	
	//Todos
	Optional<Question> findOrderByIdQuestionDesc();
	
	//1
	Optional<Question> findOneByIdQuestiony(int id);
	
	//Nombre
	Optional<Question> findOneByName(String name);

}
