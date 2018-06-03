package com.apm.quizback.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.apm.quizback.component.mapper.result.ResultMapper;
import com.apm.quizback.dto.ResultDTO;
import com.apm.quizback.exception.NotFoundException;
import com.apm.quizback.model.Result;
import com.apm.quizback.service.result.ResultService;

@RestController
@RequestMapping
public class ResultController {

	@Autowired
	ResultService resultService;
	
	@Autowired
	ResultMapper resultMapper;
	
	@GetMapping("/result")
	public List<ResultDTO> findAll(@RequestParam(defaultValue = "0", required = false) Integer page,
			@RequestParam(defaultValue = "10", required = false) Integer size) {
		final List<Result> result = resultService.findAll(PageRequest.of(page, size));
		return resultMapper.modelToDto(result);
	}
	
	@GetMapping("/user/{idUser}/course/{idCourse}/result")
	public List<ResultDTO> findAll(@RequestParam(defaultValue = "0", required = false) Integer page,
			@RequestParam(defaultValue = "10", required = false) Integer size,
			@PathVariable("idUser") Integer idUser,
			@PathVariable("idCourse") Integer idCourse) throws NotFoundException {
		final List<Result> result = resultService.findAll(PageRequest.of(page, size), idUser, idCourse);
		return resultMapper.modelToDto(result);
	}

}
