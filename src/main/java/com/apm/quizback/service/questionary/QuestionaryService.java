package com.apm.quizback.service.questionary;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.data.domain.Pageable;

import com.apm.quizback.exception.InvalidDataException;
import com.apm.quizback.exception.NotFoundException;
import com.apm.quizback.model.Questionary;
import com.apm.quizback.model.Tag;

public interface QuestionaryService {

	Set<Questionary> findAll(Pageable p, Integer idCourse) throws NotFoundException;

	Optional<Questionary> findById(Integer id, Integer idCourse) throws NotFoundException;

	Questionary create(Questionary t, Integer idCourse) throws InvalidDataException, NotFoundException;

	void update(Questionary t, Integer idCourse) throws InvalidDataException, NotFoundException;

	void delete(Questionary t);

	boolean validate(Questionary t);

	void setQuestionaryTag(Questionary questionary, Integer idTag) throws NotFoundException;

	List<Tag> findAllTags(Pageable p, Integer id) throws NotFoundException;

}