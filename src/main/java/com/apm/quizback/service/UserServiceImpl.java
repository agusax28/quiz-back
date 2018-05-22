package com.apm.quizback.service;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.apm.quizback.dao.UserDAO;
import com.apm.quizback.model.User;

@Service
public class UserServiceImpl implements UserService {
	
    //private final static Logger LOGGER = Logger.getLogger("UserService:");

	@Autowired
	UserDAO userDao;

	@Override
	public User create(User t) {
		return userDao.save(t);
	}

	@Override
	public void update(User t) {
		userDao.save(t);
	}

	@Override
	public Optional<User> findById(Integer id) {
		return userDao.findById(id);
	}

	@Override
	public Set<User> findAll(Pageable p) {
		int page = p.getPageNumber();
		int size = p.getPageSize();
		return userDao.findAll(PageRequest.of(page, size)).stream().collect(Collectors.toSet());
	}

	@Override
	public void delete(User t) {
		userDao.delete(t);
	}
	

}
