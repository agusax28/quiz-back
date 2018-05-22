package com.apm.quizback.service;

import org.springframework.data.domain.Pageable;
import java.io.Serializable;
import java.util.Optional;
import java.util.Set;

public interface AbstractService<T, ID extends Serializable> {

	T create(T t);
	
	void update(T t);
	
	Optional<T> findById(ID id);
	
	Set<T> findAll(Pageable p);
	
	void delete(T t);
	
}
