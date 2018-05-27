package com.apm.quizback.dao;

import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.apm.quizback.model.Questionary;

@Repository
public interface QuestionaryDAO extends PagingAndSortingRepository<Questionary, Integer>{
	
	//1
	Optional<Questionary> findOneByIdQuestionary(int id);
	
	//Nombre
	Optional<Questionary> findOneByName(String name);

}
