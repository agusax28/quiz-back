package com.apm.quizback.dao;

import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.apm.quizback.model.User;

@Repository
public interface UserDAO extends PagingAndSortingRepository<User, Integer>{
	
	//Por nombre
	Optional<User> findOneByNameOrderByIdUserDesc(String name);
	
	//Por email
	Optional<User> findOneByEmail(String email);
	
	//Login email+pass
	Optional<User> findOneByEmailAndPassword(String email, String password);
	
}