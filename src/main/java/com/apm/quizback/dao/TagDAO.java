package com.apm.quizback.dao;

import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.apm.quizback.model.Tag;

@Repository
public interface TagDAO extends PagingAndSortingRepository<Tag, Integer> {

	//Por nombre
	Optional<Tag> findByNameOrderByIdTagDesc(String name);
	
}
