package com.apm.quizback.service.course;

import java.util.List;
import java.util.Set;

import org.springframework.data.domain.Pageable;

import com.apm.quizback.exception.NotFoundException;
import com.apm.quizback.model.Course;
import com.apm.quizback.model.User;
import com.apm.quizback.service.AbstractCRUDService;

public interface CourseService extends AbstractCRUDService<Course, Integer> {

	List<User> findAllUser(Pageable p, Integer id) throws NotFoundException;

	void setCourseUser(Course course, Integer idUser) throws NotFoundException;

}
