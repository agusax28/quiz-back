package com.apm.quizback.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.apm.quizback.model.Selection;

@Repository
public interface SelectionDAO extends PagingAndSortingRepository<Selection, Integer>{
	
	Optional<List<Selection>> findByUser(Integer user);
	
	Optional<List<Selection>> findByQuestionary(Integer questionary);
	
}
