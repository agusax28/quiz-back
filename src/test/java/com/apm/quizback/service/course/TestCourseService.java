package com.apm.quizback.service.course;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.apm.quizback.dao.CourseDAO;
import com.apm.quizback.exception.InvalidDataException;
import com.apm.quizback.model.Course;
import com.apm.quizback.model.Questionary;
import com.apm.quizback.model.User;

@RunWith(MockitoJUnitRunner.class)
public class TestCourseService {
	
	private static final String NAME = "Curso java";
	private static final List<User> USER = new ArrayList<User>();
	private static final List<Questionary> QUESTIONARY = new ArrayList<Questionary>();
	
	@InjectMocks
	CourseService courseService = new CourseServiceImpl();
	
	@Mock
	CourseDAO courseDao;

	@Test
	public void testCreate() throws InvalidDataException {
		final Course course = new Course();
		course.setIdCourse(1);
		course.setName(NAME);
		course.setUser(USER);
		course.setCuestionary(QUESTIONARY);
		Mockito.when(courseDao.save(course)).thenReturn(course);
		
		final Course res = courseService.create(course);
		Assert.assertNotNull(res.getIdCourse());
		Assert.assertNotNull(res.getName());
		Assert.assertNotNull(res.getUser());
		Assert.assertNotNull(res.getCuestionary());
		
		Assert.assertEquals(course.getIdCourse(), res.getIdCourse());
		Assert.assertEquals(course.getName(), res.getName());
		Assert.assertEquals(course.getUser(), res.getUser());
		Assert.assertEquals(course.getCuestionary(), res.getCuestionary());
	}
	
}
