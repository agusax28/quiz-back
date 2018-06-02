package com.apm.quizback.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.apm.quizback.model.Answer;
import com.apm.quizback.model.Question;

@Repository
public interface AnswerDAO extends PagingAndSortingRepository<Answer, Integer>{

	Optional<Answer> findOneByQuestionOrderByIdAnswerDesc(Question question);
	
	Optional<List<Answer>> findByQuestionOrderByIdAnswer(Question question);
	
}
