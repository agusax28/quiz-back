package com.apm.quizback.controller;

import java.util.List;
import java.util.Optional;

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
import com.apm.quizback.dto.question.QuestionDTO;
import com.apm.quizback.exception.InvalidDataException;
import com.apm.quizback.exception.NotFoundException;
import com.apm.quizback.model.Question;
import com.apm.quizback.service.question.QuestionService;

@RestController
@RequestMapping
public class QuestionController {
	
	@Autowired
	QuestionService questionService;
	
	@Autowired
	QuestionMapper questionMapper;
	
	@GetMapping("/question")
	public List<QuestionDTO> findAll(@RequestParam(defaultValue = "0", required = false) Integer page,
			@RequestParam(defaultValue = "10", required = false) Integer size) throws NotFoundException {
		final List<Question> question = questionService.findAll(PageRequest.of(page, size));
		return questionMapper.modelToDto(question);
	}
	
	@GetMapping("/questionary/{idQuestionary}/question")
	public List<QuestionDTO> findAll(@RequestParam(defaultValue = "0", required = false) Integer page,
			@RequestParam(defaultValue = "10", required = false) Integer size,
			@PathVariable ("idQuestionary") Integer idQuestionary) throws NotFoundException {
		final List<Question> question = questionService.findAll(PageRequest.of(page, size), idQuestionary);
		return questionMapper.modelToDto(question);
	}
	
	@GetMapping("/question/{id}")
	public QuestionDTO findById(@PathVariable Integer id,
			@PathVariable ("idQuestionary") Integer idQuestionary) throws NotFoundException {
		final Optional<Question> question = questionService.findById(id);
		return questionMapper.modelToDto(question.get());
	}
	
	@PostMapping("/questionary/{idQuestionary}/question")
	public QuestionDTO create(@RequestBody QuestionDTO dto, 
			@PathVariable("idQuestionary") Integer idQuestionary, 
			@RequestParam(defaultValue = "1", required = true) Integer tag,
			@RequestParam(defaultValue = "1", required = true) Integer difficulty) throws InvalidDataException, NotFoundException {
		final Question question = questionMapper.dtoToModel(dto);
		final Question createQuestion = questionService.create(question, idQuestionary, tag, difficulty);
		return questionMapper.modelToDto(createQuestion);
	}

	@PutMapping("/question/{id}")
	public void update(@PathVariable Integer id, @RequestBody QuestionDTO dto, 
			@RequestParam(defaultValue = "1", required = true) Integer tag,
			@RequestParam(defaultValue = "1", required = true) Integer difficulty) throws InvalidDataException, NotFoundException {
		dto.setIdQuestion(id);
		final Question question = questionMapper.dtoToModel(dto);
		questionService.update(question, tag, difficulty);
	}

	@DeleteMapping("/question/{id}")
	public void delete(@PathVariable Integer id) throws NotFoundException {
		final Optional<Question> question = questionService.findById(id);
		questionService.delete(question.get());
	}

}
