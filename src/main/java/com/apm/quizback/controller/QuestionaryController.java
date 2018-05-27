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

import com.apm.quizback.component.mapper.questionary.QuestionaryMapper;
import com.apm.quizback.dto.QuestionaryDTO;
import com.apm.quizback.exception.InvalidDataException;
import com.apm.quizback.exception.NotFoundException;
import com.apm.quizback.model.Questionary;
import com.apm.quizback.service.QuestionaryService;

@RestController
@RequestMapping(value = "/questionary")
public class QuestionaryController {

	@Autowired
	QuestionaryService questionaryService;

	@Autowired
	QuestionaryMapper questionaryMapper;

	@GetMapping
	public Set<QuestionaryDTO> findAll(@RequestParam(defaultValue = "0", required = false) Integer page,
			@RequestParam(defaultValue = "10", required = false) Integer size) {
		final Set<Questionary> questionary = questionaryService.findAll(PageRequest.of(page, size));
		return questionaryMapper.modelToDto(questionary);
	}

	@GetMapping("/{id}")
	public QuestionaryDTO findById(@PathVariable Integer id) throws NotFoundException {
		final Optional<Questionary> questionary = questionaryService.findById(id);
		return questionaryMapper.modelToDto(questionary.get());
	}
	
	@PostMapping
	public QuestionaryDTO create(@RequestBody QuestionaryDTO dto) throws InvalidDataException {
		final Questionary questionary = questionaryMapper.dtoToModel(dto);
		final Questionary createQuestionary = questionaryService.create(questionary);
		return questionaryMapper.modelToDto(createQuestionary);
	}
	
	@PutMapping("/{id}")
	public void update(@PathVariable Integer id, @RequestBody QuestionaryDTO dto) throws InvalidDataException {
		dto.setIdQuestionary(id);
		final Questionary questionary = questionaryMapper.dtoToModel(dto);
		questionaryService.update(questionary);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Integer id) throws NotFoundException {
		final Optional<Questionary> questionary = questionaryService.findById(id);
		questionaryService.delete(questionary.get());
	}
	
}
