package com.apm.quizback.controller;

import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.apm.quizback.component.mapper.course.CourseMapper;
import com.apm.quizback.component.mapper.user.UserMapper;
import com.apm.quizback.dto.CourseDTO;
import com.apm.quizback.dto.UserDTO;
import com.apm.quizback.exception.InvalidDataException;
import com.apm.quizback.exception.NotFoundException;
import com.apm.quizback.model.Course;
import com.apm.quizback.model.User;
import com.apm.quizback.service.course.CourseService;

@RestController
@RequestMapping(value = "/course")
public class CourseController {

	@Autowired
	CourseService courseService;
	
	@Autowired
	CourseMapper courseMapper;

	@Autowired
	UserMapper userMapper;
	
	@GetMapping
	public Set<CourseDTO> findAll(@RequestParam(defaultValue = "0", required = false) Integer page,
			@RequestParam(defaultValue = "10", required = false) Integer size) {
		final Set<Course> course = courseService.findAll(PageRequest.of(page, size));
		return courseMapper.modelToDto(course);
	}
	
	@GetMapping("/{id}")
	public CourseDTO findById(@PathVariable Integer id) throws NotFoundException {
		final Optional<Course> course = courseService.findById(id);
		return courseMapper.modelToDto(course.get());
	}
	
	@GetMapping("/{id}/user")
	public Set<UserDTO> findCourseUser(@RequestParam(defaultValue = "0", required= false ) Integer page, 
			 @RequestParam(defaultValue = "10", required = false ) Integer size,
			 @PathVariable("id") Integer id) throws NotFoundException {
		final Set<User> users = courseService.findCourseUsers(PageRequest.of(page, size), id);
		return userMapper.modelToDto(users);
	}
	
	@PostMapping
	public CourseDTO create(@RequestBody CourseDTO dto) throws InvalidDataException {
		final Course course = courseMapper.dtoToModel(dto);
		final Course createCourse = courseService.create(course);
		return courseMapper.modelToDto(createCourse);
	}
	
	@PostMapping("/{id}/user/{idUser}")
	public void createCourseUser(@PathVariable("id") Integer id, @PathVariable("idUser") Integer idUser) throws NotFoundException {
		final Optional<Course> course = courseService.findById(id);
		courseService.setCourseUser(course.get(), idUser);
	}
	
	@PutMapping("/{id}")
	public void update(@PathVariable Integer id, @RequestBody CourseDTO dto) throws InvalidDataException {
		dto.setIdCourse(id);
		final Course course = courseMapper.dtoToModel(dto);
		courseService.update(course);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Integer id) throws NotFoundException {
		final Optional<Course> course = courseService.findById(id);
		courseService.delete(course.get());
	}
	
}
