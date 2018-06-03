package com.apm.quizback.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.apm.quizback.component.mapper.selection.SelectionMapper;
import com.apm.quizback.dto.SelectionDTO;
import com.apm.quizback.exception.InvalidDataException;
import com.apm.quizback.exception.NotFoundException;
import com.apm.quizback.model.Selection;
import com.apm.quizback.service.selection.SelectionService;

@RestController
@RequestMapping
public class SelectionController {

	@Autowired
	SelectionService selectionService;
	
	@Autowired
	SelectionMapper selectionMapper;
	
	@PostMapping("/user/{idUser}/questionary/{idQuestionary}/exam")
	public SelectionDTO create(@PathVariable("idUser") Integer idUser,
			@PathVariable("idQuestionary") Integer idQuestionary,
			@RequestParam(required = true ) Integer question,
			@RequestParam(required = true ) Integer answer) throws InvalidDataException, NotFoundException {
		final Selection selection = selectionService.create(idUser, idQuestionary, question, answer);
		return selectionMapper.modelToDto(selection);
	}
	
}
