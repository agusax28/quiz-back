package com.apm.quizback.service.question;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.apm.quizback.exception.NotFoundException;
import com.apm.quizback.model.Question;
import com.apm.quizback.service.AbstractCRUDService;

public interface QuestionService extends AbstractCRUDService<Question, Integer>{

	List<Question> findAll(Pageable p, Integer idQuestionary) throws NotFoundException;
	
}
