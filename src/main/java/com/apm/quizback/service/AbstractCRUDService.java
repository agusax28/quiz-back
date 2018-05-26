package com.apm.quizback.service;

import java.io.Serializable;
import java.util.Optional;
import java.util.Set;

import org.springframework.data.domain.Pageable;

import com.apm.quizback.exception.InvalidDataException;
import com.apm.quizback.exception.NotFoundException;

public interface AbstractCRUDService<T, ID extends Serializable> {

	T create(T t) throws InvalidDataException;

	void update(T t) throws InvalidDataException;

	Optional<T> findById(ID id) throws NotFoundException;

	Set<T> findAll(Pageable p);

	void delete(T t);
	
	boolean validate(T t);

}