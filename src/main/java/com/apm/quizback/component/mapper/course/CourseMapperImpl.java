package com.apm.quizback.component.mapper.course;

import org.springframework.stereotype.Component;

import com.apm.quizback.component.mapper.AbstractMapper;
import com.apm.quizback.dto.CourseDTO;
import com.apm.quizback.model.Course;

@Component
public class CourseMapperImpl extends AbstractMapper<Course, CourseDTO> implements CourseMapper {

	@Override
	public Class<? extends CourseDTO> dtoClazz() {
		return CourseDTO.class;
	}

	@Override
	public Class<? extends Course> modelClazz() {
		return Course.class;
	}

}