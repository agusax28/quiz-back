package com.apm.quizback.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.apm.quizback.dto.ErrorDTO;
import com.apm.quizback.exception.InvalidDataException;
import com.apm.quizback.exception.NotFoundException;

@ControllerAdvice(basePackages = { "com.apm.quiz-back.controller" })
public class ControllerAdviceV1 {

	@ResponseBody
	@ExceptionHandler(NotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ErrorDTO error(Exception e) {
		return new ErrorDTO(404, e.getMessage());
	}

	@ResponseBody
	@ExceptionHandler(InvalidDataException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorDTO error(InvalidDataException e) {
		return new ErrorDTO(400, e.getMessage());
	}

}
