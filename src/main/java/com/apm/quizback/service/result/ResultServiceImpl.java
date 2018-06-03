package com.apm.quizback.service.result;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.apm.quizback.dao.ResultDAO;
import com.apm.quizback.exception.InvalidDataException;
import com.apm.quizback.exception.NotFoundException;
import com.apm.quizback.model.Result;

@Service
public class ResultServiceImpl implements ResultService {

	@Autowired
	ResultDAO resultDao;

	@Override
	public Result create(Result t) throws InvalidDataException {
		if (validate(t)) {
			return resultDao.save(t);
		}
		throw new InvalidDataException("Result: Invalid Data");
	}

	@Override
	public void update(Result t) throws InvalidDataException {
		if (validate(t)) {
			resultDao.save(t);
		} else {
			throw new InvalidDataException("Result: Invalid Data");
		}
	}

	@Override
	public Optional<Result> findById(Integer id) throws NotFoundException {
		final Optional<Result> result = resultDao.findById(id);
		if (result.isPresent()) {
			return result;
		}
		throw new NotFoundException("Result " + id + " not found.");
	}

	@Override
	public List<Result> findAll(Pageable p) {
		int page = p.getPageNumber();
		int size = p.getPageSize();
		return resultDao.findAll(PageRequest.of(page, size)).stream().collect(Collectors.toList());
	}

	@Override
	public void delete(Result t) {
		resultDao.delete(t);

	}

	@Override
	public boolean validate(Result t) {
		return t != null;
	}

}
