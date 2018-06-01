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

import com.apm.quizback.component.mapper.answer.AnswerMapper;
import com.apm.quizback.dto.answer.AnswerDTO;
import com.apm.quizback.exception.InvalidDataException;
import com.apm.quizback.exception.NotFoundException;
import com.apm.quizback.model.Answer;
import com.apm.quizback.service.answer.AnswerService;

@RestController
@RequestMapping(value = "/answer")
public class AnswerController {

	@Autowired
	AnswerService answerService;
	
	@Autowired
	AnswerMapper answerMapper;
	
	@GetMapping
	public List<AnswerDTO> findAll(@RequestParam(defaultValue = "0", required = false) Integer page,
			@RequestParam(defaultValue = "10", required = false) Integer size) {
		final List<Answer> answer = answerService.findAll(PageRequest.of(page, size));
		return answerMapper.modelToDto(answer);
	}
	
	@GetMapping("/{id}")
	public AnswerDTO findById(@PathVariable Integer id) throws NotFoundException {
		final Optional<Answer> answer = answerService.findById(id);
		return answerMapper.modelToDto(answer.get());
	}
	
	@PostMapping
	public AnswerDTO create(@RequestBody AnswerDTO dto) throws InvalidDataException {
		final Answer answer = answerMapper.dtoToModel(dto);
		final Answer createAnswer = answerService.create(answer);
		return answerMapper.modelToDto(createAnswer);
	}
	
	@PutMapping("/{id}")
	public void update(@PathVariable Integer id, @RequestBody AnswerDTO dto) throws InvalidDataException {
		dto.setIdAnswer(id);
		final Answer answer = answerMapper.dtoToModel(dto);
		answerService.update(answer);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Integer id) throws NotFoundException {
		final Optional<Answer> answer = answerService.findById(id);
		answerService.delete(answer.get());
	}
	
}
