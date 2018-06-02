package com.apm.quizback.service.answer;

import java.util.List;

import com.apm.quizback.exception.InvalidDataException;
import com.apm.quizback.exception.NotFoundException;
import com.apm.quizback.model.Answer;
import com.apm.quizback.service.AbstractCRUDService;

public interface AnswerService extends AbstractCRUDService<Answer, Integer>{

	List<Answer> findAll(Integer idQuestion) throws NotFoundException;

	Answer create(Answer answer, Integer idQuestion) throws NotFoundException, InvalidDataException;

}
