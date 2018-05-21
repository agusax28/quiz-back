package com.apm.quizback.dao;

import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.apm.quizback.model.Course;

public interface CourseDAO extends PagingAndSortingRepository<Course, Integer>{
	
	//1
	Optional<Course> findOneByIdCourse(int id);
	
	//Nombre
	Optional<Course> findOneByName(String name);

}
