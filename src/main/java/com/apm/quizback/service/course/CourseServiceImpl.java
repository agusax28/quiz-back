package com.apm.quizback.service.course;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.apm.quizback.dao.CourseDAO;
import com.apm.quizback.exception.InvalidDataException;
import com.apm.quizback.exception.NotFoundException;
import com.apm.quizback.model.Course;

@Service
public class CourseServiceImpl implements CourseService {

	@Autowired
	CourseDAO courseDao;

	@Override
	public Course create(Course t) throws InvalidDataException {
		if (validate(t)) {
			return courseDao.save(t);
		}
		throw new InvalidDataException("Course: Invalid Data");
	}

	@Override
	public void update(Course t) throws InvalidDataException {
		if (validate(t)) {
			courseDao.save(t);
		} else {
			throw new InvalidDataException("Course: Invalid Data");
		}
	}

	@Override
	public Optional<Course> findById(Integer id) throws NotFoundException {
		// return courseDao.findById(id);
		final Optional<Course> course = courseDao.findById(id);
		if (course.isPresent()) {
			return course;
		}
		throw new NotFoundException("Course " + id + " not found.");
	}

	@Override
	public Set<Course> findAll(Pageable p) {
		int page = p.getPageNumber();
		int size = p.getPageSize();
		return courseDao.findAll(PageRequest.of(page, size)).stream().collect(Collectors.toSet());
	}

	@Override
	public void delete(Course t) {
		courseDao.delete(t);
	}

	@Override
	public boolean validate(Course t) {
		return t != null && t.getName() != null;
	}

}
