package com.apm.quizback.controller;

import java.util.List;
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

import com.apm.quizback.component.mapper.questionary.QuestionaryMapper;
import com.apm.quizback.component.mapper.tag.TagMapper;
import com.apm.quizback.dto.QuestionaryDTO;
import com.apm.quizback.dto.TagDTO;
import com.apm.quizback.exception.InvalidDataException;
import com.apm.quizback.exception.NotFoundException;
import com.apm.quizback.model.Questionary;
import com.apm.quizback.model.Tag;
import com.apm.quizback.service.questionary.QuestionaryService;

@RestController
@RequestMapping(value = "/course/{idCourse}/questionary")
public class QuestionaryController {

	@Autowired
	QuestionaryService questionaryService;
	
	@Autowired
	QuestionaryMapper questionaryMapper;
	
	@Autowired
	TagMapper tagMapper;
	
	@GetMapping
	public Set<QuestionaryDTO> findAll(@RequestParam(defaultValue = "0", required = false) Integer page,
			@RequestParam(defaultValue = "10", required = false) Integer size,
			@PathVariable("idCourse") Integer idCourse) throws NotFoundException {
		final Set<Questionary> questionary = questionaryService.findAll(PageRequest.of(page, size), idCourse);
		return questionaryMapper.modelToDto(questionary);
	}

	@GetMapping("/{id}")
	public QuestionaryDTO findById(@PathVariable("id") Integer id,
			@PathVariable("idCourse") Integer idCourse) throws NotFoundException {
		final Optional<Questionary> questionary = questionaryService.findById(id, idCourse);
		return questionaryMapper.modelToDto(questionary.get());
	}
	
	@GetMapping("/{id}/tag")
	public List<TagDTO> findCourseUser(@RequestParam(defaultValue = "0", required= false ) Integer page, 
			 @RequestParam(defaultValue = "10", required = false ) Integer size,
			 @PathVariable("id") Integer id) throws NotFoundException {
		final List<Tag> tag = questionaryService.findAllTags(PageRequest.of(page, size), id	);
		return tagMapper.modelToDto(tag);
	}
	
	@PostMapping
	public QuestionaryDTO create(@RequestBody QuestionaryDTO dto, 
			@PathVariable("idCourse") Integer idCourse) throws InvalidDataException, NotFoundException {
		final Questionary questionary = questionaryMapper.dtoToModel(dto);
		final Questionary createQuestionary = questionaryService.create(questionary, idCourse);
		return questionaryMapper.modelToDto(createQuestionary);
	}
	
	@PostMapping("/{id}/tag/{idTag}")
	public void createQuestionaryTag(@PathVariable("id") Integer id, 
			@PathVariable("idCourse") Integer idCourse, 
			@PathVariable("idTag") Integer idTag) throws NotFoundException {
		final Optional<Questionary> questionary = questionaryService.findById(id, idCourse);
		questionaryService.setQuestionaryTag(questionary.get(), idTag);
	}
	
	@PutMapping("/{id}")
	public void update(@PathVariable("id") Integer id,
			@PathVariable("idCourse") Integer idCourse,
			@RequestBody QuestionaryDTO dto) throws InvalidDataException, NotFoundException {
		dto.setIdQuestionary(id);
		final Questionary questionary = questionaryMapper.dtoToModel(dto);
		questionaryService.update(questionary, idCourse);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") Integer id,
			@PathVariable("idCourse") Integer idCourse) throws NotFoundException {
		final Optional<Questionary> questionary = questionaryService.findById(id, idCourse);
		questionaryService.delete(questionary.get());
	}
	
}
