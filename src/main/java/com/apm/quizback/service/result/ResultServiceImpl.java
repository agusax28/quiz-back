package com.apm.quizback.service.result;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.apm.quizback.dao.ResultDAO;
import com.apm.quizback.exception.InvalidDataException;
import com.apm.quizback.exception.NotFoundException;
import com.apm.quizback.model.Course;
import com.apm.quizback.model.Questionary;
import com.apm.quizback.model.Result;
import com.apm.quizback.service.course.CourseService;
import com.apm.quizback.service.questionary.QuestionaryService;
import com.apm.quizback.service.user.UserService;

@Service
public class ResultServiceImpl implements ResultService {

	@Autowired
	ResultDAO resultDao;
	
	@Autowired
	UserService userService;
	
	@Autowired
	QuestionaryService questionaryService;
	
	@Autowired
	CourseService courseService;

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

	@Override
	public List<Result> findAll(Pageable p, Integer idUser, Integer idCourse) throws NotFoundException {
		int page = p.getPageNumber();
		int size = p.getPageSize();
		final Optional<Course> course = courseService.findById(idCourse);
		List<Questionary> questionary = course.get().getCuestionary();
		List<Result> res = new ArrayList<Result>();
		questionary.forEach(item -> {
			res.add(resultDao.findOneByQuestionaryAndUser(item.getIdQuestionary(), idUser));
        });
		return new PageImpl<Result>(res, PageRequest.of(page, size), questionary.size()).stream().collect(Collectors.toList());
	}

}
