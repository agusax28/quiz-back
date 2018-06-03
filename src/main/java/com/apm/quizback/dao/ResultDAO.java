package com.apm.quizback.dao;

import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.apm.quizback.model.Result;

@Repository
public interface ResultDAO extends PagingAndSortingRepository<Result, Integer>{
	
	//1
	Optional<Result> findOneByIdResult(int id);

	Result findOneByQuestionaryAndUser(int idQuestionary, int idUser);
}
