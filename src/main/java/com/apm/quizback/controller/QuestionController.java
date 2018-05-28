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

import com.apm.quizback.component.mapper.question.QuestionMapper;
import com.apm.quizback.dto.QuestionDTO;
import com.apm.quizback.exception.InvalidDataException;
import com.apm.quizback.exception.NotFoundException;
import com.apm.quizback.model.Question;
import com.apm.quizback.service.question.QuestionService;

@RestController
@RequestMapping(value = "/question")
public class QuestionController {
	
	@Autowired
	QuestionService questionService;
	
	@Autowired
	QuestionMapper questionMapper;
	
	@GetMapping
	public Set<QuestionDTO> findAll(@RequestParam(defaultValue = "0", required = false) Integer page,
			@RequestParam(defaultValue = "10", required = false) Integer size) {
		final Set<Question> question = questionService.findAll(PageRequest.of(page, size));
		return questionMapper.modelToDto(question);
	}
	
	@GetMapping("/{id}")
	public QuestionDTO findById(@PathVariable Integer id) throws NotFoundException {
		final Optional<Question> question = questionService.findById(id);
		return questionMapper.modelToDto(question.get());
	}
	
	@PostMapping
	public QuestionDTO create(@RequestBody QuestionDTO dto) throws InvalidDataException {
		final Question question = questionMapper.dtoToModel(dto);
		final Question createQuestion = questionService.create(question);
		return questionMapper.modelToDto(createQuestion);
	}

	// @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	@PutMapping("/{id}")
	public void update(@PathVariable Integer id, @RequestBody QuestionDTO dto) throws InvalidDataException {
		dto.setIdQuestion(id);
		final Question question = questionMapper.dtoToModel(dto);
		questionService.update(question);
	}

	// @RequestMapping(value = "/{idUser}", method = RequestMethod.DELETE)
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Integer id) throws NotFoundException {
		final Optional<Question> question = questionService.findById(id);
		questionService.delete(question.get());
	}

}
