package com.apm.quizback.service.question;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.apm.quizback.exception.InvalidDataException;
import com.apm.quizback.exception.NotFoundException;
import com.apm.quizback.model.Question;
import com.apm.quizback.service.AbstractCRUDService;

public interface QuestionService extends AbstractCRUDService<Question, Integer>{

	List<Question> findAll(Pageable p, Integer idQuestionary) throws NotFoundException;

	Question create(Question question, Integer idQuestionary, Integer tag, Integer difficulty) throws NotFoundException, InvalidDataException;

	void update(Question question, Integer tag, Integer difficulty) throws InvalidDataException, NotFoundException;
	
}
