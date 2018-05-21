package com.apm.quizback.dao;

import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.apm.quizback.model.Cuestionary;

public interface CuestionaryDAO extends PagingAndSortingRepository<Cuestionary, Integer>{
	
	//1
	Optional<Cuestionary> findOneByIdCuestionary(int id);
	
	//Nombre
	Optional<Cuestionary> findOneByName(String name);

}
