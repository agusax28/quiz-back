package com.apm.quizback.service.course;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.apm.quizback.dao.CourseDAO;
import com.apm.quizback.exception.InvalidDataException;
import com.apm.quizback.exception.NotFoundException;
import com.apm.quizback.model.Course;
import com.apm.quizback.model.User;
import com.apm.quizback.service.user.UserService;

@Service
public class CourseServiceImpl implements CourseService {

	@Autowired
	CourseDAO courseDao;
	
	@Autowired
	UserService userService;

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
	public List<Course> findAll(Pageable p) {
		int page = p.getPageNumber();
		int size = p.getPageSize();
		return courseDao.findAll(PageRequest.of(page, size)).stream().collect(Collectors.toList());
	}

	@Override
	public void delete(Course t) {
		courseDao.delete(t);
	}

	@Override
	public boolean validate(Course t) {
		return t != null && t.getName() != null;
	}

	@Override
	public List<User> findAllUser(Pageable p, Integer id) throws NotFoundException {
		int page = p.getPageNumber();
		int size = p.getPageSize();
		Optional<Course> course = courseDao.findById(id);
		if(course.isPresent()) {
			List<User> user = course.get().getUser();
			return new PageImpl<User>(user, PageRequest.of(page, size), user.size()).stream().collect(Collectors.toList());
		}
		throw new NotFoundException("Course " + id + " not found.");
	}

	@Override
	public void setCourseUser(Course course, Integer idUser) throws NotFoundException {
		if (validate(course)) {
			Optional<User> user = userService.findById(idUser);
			course.getUser().add(user.get());
			courseDao.save(course);
		}
	}
	
}
