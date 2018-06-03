package com.apm.quizback.service.result;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.apm.quizback.exception.NotFoundException;
import com.apm.quizback.model.Result;
import com.apm.quizback.service.AbstractCRUDService;

public interface ResultService extends AbstractCRUDService<Result, Integer> {

	List<Result> findAll(Pageable p, Integer idUser, Integer idCourse) throws NotFoundException;

}
