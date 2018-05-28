package com.apm.quizback.service.difficulty;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.apm.quizback.dao.DifficultyDAO;
import com.apm.quizback.exception.InvalidDataException;
import com.apm.quizback.exception.NotFoundException;
import com.apm.quizback.model.Difficulty;

@Service
public class DifficultyServiceImpl implements DifficultyService {

	@Autowired
	DifficultyDAO difficultyDao;

	public Difficulty create(Difficulty t) throws InvalidDataException {
		if (validate(t)) {
			return difficultyDao.save(t);
		}
		throw new InvalidDataException("Course: Invalid Data");
	}

	public void update(Difficulty t) throws InvalidDataException {
		if (validate(t)) {
			difficultyDao.save(t);
		} else {
			throw new InvalidDataException("Course: Invalid Data");
		}
	}

	public Optional<Difficulty> findById(Integer id) throws NotFoundException {
		// return courseDao.findById(id);
		final Optional<Difficulty> difficulty = difficultyDao.findById(id);
		if (difficulty.isPresent()) {
			return difficulty;
		}
		throw new NotFoundException("Course " + id + " not found.");
	}

	public Set<Difficulty> findAll(Pageable p) {
		int page = p.getPageNumber();
		int size = p.getPageSize();
		return difficultyDao.findAll(PageRequest.of(page, size)).stream().collect(Collectors.toSet());
	}

	public void delete(Difficulty t) {
		difficultyDao.delete(t);
	}

	public boolean validate(Difficulty t) {
		return t != null && t.getName() != null;
	}
	
}
