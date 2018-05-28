package com.apm.quizback.service;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.apm.quizback.dao.QuestionDAO;
import com.apm.quizback.exception.InvalidDataException;
import com.apm.quizback.exception.NotFoundException;
import com.apm.quizback.model.Question;

@Service
public class QuestionServiceImpl implements QuestionService {

	@Autowired
	QuestionDAO questionDao;

	@Override
	public Question create(Question t) throws InvalidDataException {
		if (validate(t)) {
			return questionDao.save(t);
		}
		throw new InvalidDataException("Question: Invalid Data");
	}

	@Override
	public void update(Question t) throws InvalidDataException {
		if (validate(t)) {
			questionDao.save(t);
		} else {
			throw new InvalidDataException("Question: Invalid Data");
		}
	}

	@Override
	public Optional<Question> findById(Integer id) throws NotFoundException {
		// return questionDao.findById(id);
		final Optional<Question> question = questionDao.findById(id);
		if (question.isPresent()) {
			return question;
		}
		throw new NotFoundException("Question " + id + " not found.");
	}

	@Override
	public Set<Question> findAll(Pageable p) {
		int page = p.getPageNumber();
		int size = p.getPageSize();
		return questionDao.findAll(PageRequest.of(page, size)).stream().collect(Collectors.toSet());
	}

	@Override
	public void delete(Question t) {
		questionDao.delete(t);
	}

	@Override
	public boolean validate(Question t) {
		return t != null && t.getName() != null && t.getDifficulty() != null && t.getTag() != null;
	}

}
