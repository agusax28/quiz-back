package com.apm.quizback.service.questionary;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.apm.quizback.dao.QuestionaryDAO;
import com.apm.quizback.exception.InvalidDataException;
import com.apm.quizback.exception.NotFoundException;
import com.apm.quizback.model.Course;
import com.apm.quizback.model.Questionary;
import com.apm.quizback.model.Tag;
import com.apm.quizback.service.course.CourseService;
import com.apm.quizback.service.tag.TagService;

@Service
public class QuestionaryServiceImpl implements QuestionaryService {

	@Autowired
	QuestionaryDAO questionaryDao;
	
	@Autowired
	CourseService courseService;
	
	@Autowired
	TagService tagService;

	@Override
	public Questionary create(Questionary t, Integer idCourse) throws InvalidDataException, NotFoundException {
		Optional<Course> course = courseService.findById(idCourse);
		if (validate(t) && course.isPresent()) {
			t.setCourse(course.get());
			return questionaryDao.save(t);
		}
		throw new InvalidDataException("Questionary: Invalid Data");
	}

	@Override
	public void update(Questionary t, Integer idCourse) throws InvalidDataException, NotFoundException {
		Optional<Course> course = courseService.findById(idCourse);
		if (validate(t) && course.isPresent()) {
			t.setCourse(course.get());
			questionaryDao.save(t);
		} else {
			throw new InvalidDataException("Questionary: Invalid Data");
		}
	}
	
	@Override
	public Optional<Questionary> findById(Integer id, Integer idCourse) throws NotFoundException {
		final Optional<Questionary> questionary = questionaryDao.findById(id);
		Optional<Course> course = courseService.findById(idCourse);
		if (questionary.isPresent() && questionary.get().getCourse() == course.get() ) {
			return questionary;
		}
		throw new NotFoundException("Questionary " + id + " not found.");
	}

	@Override
	public List<Questionary> findAll(Pageable p, Integer idCourse) throws NotFoundException {
		int page = p.getPageNumber();
		int size = p.getPageSize();
		Optional<Course> course = courseService.findById(idCourse);
		if(course.isPresent()) {
			List<Questionary> questionary = course.get().getCuestionary();
			return new PageImpl<Questionary>(questionary, PageRequest.of(page, size), questionary.size()).stream().collect(Collectors.toList());
		}
		throw new NotFoundException("Course " + idCourse + " not found.");
	}

	@Override
	public void delete(Questionary t) {
		questionaryDao.delete(t);
	}

	@Override
	public boolean validate(Questionary t) {
		return t != null && t.getName() != null;
	}

	@Override
	public void setQuestionaryTag(Questionary questionary, Integer idTag) throws NotFoundException {
		if (validate(questionary)) {
			Optional<Tag> tag = tagService.findById(idTag);
			questionary.getTag().add(tag.get());
			questionaryDao.save(questionary);
		}
	}

	@Override
	public List<Tag> findAllTags(Pageable p, Integer id) throws NotFoundException {
		int page = p.getPageNumber();
		int size = p.getPageSize();
		Optional<Questionary> questionary = questionaryDao.findById(id);
		if(questionary.isPresent()) {
			List<Tag> tag = questionary.get().getTag();
			return new PageImpl<Tag>(tag, PageRequest.of(page, size), tag.size()).stream().collect(Collectors.toList());
		}
		throw new NotFoundException("Tag " + id + " not found.");
	}

	@Override
	public Questionary create(Questionary t) throws InvalidDataException {
		if (validate(t)) {
			return questionaryDao.save(t);
		}
		throw new InvalidDataException("Questionary: Invalid Data");
	}

	@Override
	public void update(Questionary t) throws InvalidDataException {
		if (validate(t)) {
			questionaryDao.save(t);
		} else {
			throw new InvalidDataException("Questionary: Invalid Data");
		}
	}

	@Override
	public Optional<Questionary> findById(Integer id) throws NotFoundException {
		final Optional<Questionary> questionary = questionaryDao.findById(id);
		if (questionary.isPresent()) {
			return questionary;
		}
		throw new NotFoundException("Questionary " + id + " not found.");
	}

	@Override
	public List<Questionary> findAll(Pageable p) {
		int page = p.getPageNumber();
		int size = p.getPageSize();
		return questionaryDao.findAll(PageRequest.of(page, size)).stream().collect(Collectors.toList());
	}

}
