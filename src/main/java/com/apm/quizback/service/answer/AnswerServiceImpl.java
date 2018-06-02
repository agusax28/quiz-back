package com.apm.quizback.service.answer;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.apm.quizback.dao.AnswerDAO;
import com.apm.quizback.exception.InvalidDataException;
import com.apm.quizback.exception.NotFoundException;
import com.apm.quizback.model.Answer;
import com.apm.quizback.model.Question;
import com.apm.quizback.service.question.QuestionService;

@Service
public class AnswerServiceImpl implements AnswerService {

	@Autowired
	AnswerDAO answerDao;
	
	@Autowired
	QuestionService questionService;

	@Override
	public Answer create(Answer t) throws InvalidDataException {
		if (validate(t)) {
			return answerDao.save(t);
		}
		throw new InvalidDataException("Answer: Invalid Data");
	}

	@Override
	public void update(Answer t) throws InvalidDataException {
		if (validate(t)) {
			answerDao.save(t);
		} else {
			throw new InvalidDataException("Answer: Invalid Data");
		}
	}

	@Override
	public Optional<Answer> findById(Integer id) throws NotFoundException {
		final Optional<Answer> answer = answerDao.findById(id);
		if (answer.isPresent()) {
			return answer;
		}
		throw new NotFoundException("Answer " + id + " not found.");
	}

	@Override
	public List<Answer> findAll(Pageable p) {
		int page = p.getPageNumber();
		int size = p.getPageSize();
		return answerDao.findAll(PageRequest.of(page, size)).stream().collect(Collectors.toList());
	}

	@Override
	public void delete(Answer t) {
		answerDao.delete(t);
	}

	@Override
	public boolean validate(Answer t) {
		return t != null && t.getName() != null;
	}

	@Override
	public List<Answer> findAll(Integer idQuestion) throws NotFoundException {
		final Optional<Question> question = questionService.findById(idQuestion);
		if(question.isPresent()) {
			Optional<List<Answer>> answer = answerDao.findByQuestionOrderByIdAnswer(question.get());
			return answer.get();
		}
		throw new NotFoundException("Question " + idQuestion + " not found.");
	}

	@Override
	public Answer create(Answer answer, Integer idQuestion) throws NotFoundException, InvalidDataException {
		final Optional<Question> question = questionService.findById(idQuestion);
		Optional<List<Answer>> answers = answerDao.findByQuestionOrderByIdAnswer(question.get());
		if(question.isPresent() && answers.get().size()<4) {
			answer.setQuestion(question.get());
			return create(answer);
		}
		throw new InvalidDataException("Question " + idQuestion + " has 4 answers.");
	}

	@Override
	public void update(Answer answer, Integer idQuestion) throws NotFoundException, InvalidDataException {
		final Optional<Question> question = questionService.findById(idQuestion);
		if(question.isPresent()) {
			answer.setQuestion(question.get());
			answerDao.save(answer);
		}
		throw new NotFoundException("Question " + idQuestion + " not found.");
	}

}
