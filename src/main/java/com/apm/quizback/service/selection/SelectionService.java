package com.apm.quizback.service.selection;

import com.apm.quizback.exception.InvalidDataException;
import com.apm.quizback.exception.NotFoundException;
import com.apm.quizback.model.Selection;
import com.apm.quizback.service.AbstractCRUDService;

public interface SelectionService extends AbstractCRUDService<Selection, Integer> {

	Selection create(Integer idUser, Integer idQuestionary, Integer idQuestion, Integer idAnswer) throws NotFoundException, InvalidDataException;

}
