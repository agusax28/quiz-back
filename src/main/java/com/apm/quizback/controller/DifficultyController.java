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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.apm.quizback.component.mapper.difficulty.DifficultyMapper;
import com.apm.quizback.dto.DifficultyDTO;
import com.apm.quizback.exception.InvalidDataException;
import com.apm.quizback.exception.NotFoundException;
import com.apm.quizback.model.Difficulty;
import com.apm.quizback.service.difficulty.DifficultyService;

@RestController
@RequestMapping(value = "/difficulty")
public class DifficultyController {

	@Autowired
	DifficultyService difficultyService;

	@Autowired
	DifficultyMapper difficultyMapper;

	@GetMapping
	@ResponseBody
	public List<DifficultyDTO> findAll(@RequestParam(defaultValue = "0", required = false) Integer page,
			@RequestParam(defaultValue = "10", required = false) Integer size) {
		final List<Difficulty> difficulty = difficultyService.findAll(PageRequest.of(page, size));
		return difficultyMapper.modelToDto(difficulty);
	}

	@GetMapping("/{id}")
	public DifficultyDTO findById(@PathVariable Integer id) throws NotFoundException {
		final Optional<Difficulty> difficulty = difficultyService.findById(id);
		return difficultyMapper.modelToDto(difficulty.get());
	}
	
	@PostMapping
	public DifficultyDTO create(@RequestBody DifficultyDTO dto) throws InvalidDataException {
		final Difficulty difficulty = difficultyMapper.dtoToModel(dto);
		final Difficulty createDifficulty = difficultyService.create(difficulty);
		return difficultyMapper.modelToDto(createDifficulty);
	}
	
	@PutMapping("/{id}")
	public void update(@PathVariable Integer id, @RequestBody DifficultyDTO dto) throws InvalidDataException {
		dto.setIdDifficulty(id);
		final Difficulty difficulty = difficultyMapper.dtoToModel(dto);
		difficultyService.update(difficulty);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Integer id) throws NotFoundException {
		final Optional<Difficulty> difficulty = difficultyService.findById(id);
		difficultyService.delete(difficulty.get());
	}
	
}
