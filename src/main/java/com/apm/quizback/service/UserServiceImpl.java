package com.apm.quizback.service;

import java.util.Optional;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apm.quizback.dao.UserDAO;
import com.apm.quizback.model.User;

@Service
public class UserServiceImpl implements UserService, InitializingBean {

	@Autowired
	UserDAO dao;
	
	@Override
	public void afterPropertiesSet() throws Exception {
		test();
	}

	@Override
	public void test() {
		final Optional<User> test = dao.findOneByNameOrderByIdUserDesc("NameTest");
		if(!test.isPresent()) {
			final User u = new User();
			u.setEmail("test@g.com");
			u.setName("NameTest");
			u.setPassword("passTest");
			dao.save(u);
		}
		
		final Optional<User> user = dao.findOneByNameOrderByIdUserDesc("NameTest");
		System.out.println(user.isPresent() ? user.get() : "no encontrado");
	}

}
