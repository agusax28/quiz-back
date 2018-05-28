package com.apm.quizback.service;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.apm.quizback.dao.QuestionaryDAO;
import com.apm.quizback.exception.InvalidDataException;
import com.apm.quizback.exception.NotFoundException;
import com.apm.quizback.model.Questionary;

@Service
public class QuestionaryServiceImpl implements QuestionaryService {

	@Autowired
	QuestionaryDAO questionaryDao;

	@Override
	public Questionary create(Questionary t) throws InvalidDataException {
		if (validate(t)) {
			return questionaryDao.save(t);
		}
		throw new InvalidDataException("Questionary: Invalid Data");
	}

	@Override
	public void update(Questionary t) throws InvalidDataException {
		if (validate(t)) {
			questionaryDao.save(t);
		} else {
			throw new InvalidDataException("Questionary: Invalid Data");
		}
	}

	@Override
	public Optional<Questionary> findById(Integer id) throws NotFoundException {
		// return questionaryDao.findById(id);
		final Optional<Questionary> questionary = questionaryDao.findById(id);
		if (questionary.isPresent()) {
			return questionary;
		}
		throw new NotFoundException("Questionary " + id + " not found.");
	}

	@Override
	public Set<Questionary> findAll(Pageable p) {
		int page = p.getPageNumber();
		int size = p.getPageSize();
		return questionaryDao.findAll(PageRequest.of(page, size)).stream().collect(Collectors.toSet());
	}

	@Override
	public void delete(Questionary t) {
		questionaryDao.delete(t);
	}

	@Override
	public boolean validate(Questionary t) {
		return t != null && t.getName() != null && t.getCourse() != null;
	}

}
