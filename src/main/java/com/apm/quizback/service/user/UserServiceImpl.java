package com.apm.quizback.service.user;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.apm.quizback.dao.UserDAO;
import com.apm.quizback.exception.InvalidDataException;
import com.apm.quizback.exception.NotFoundException;
import com.apm.quizback.model.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserDAO userDao;

	@Override
	public User create(User t) throws InvalidDataException {
		if (validate(t)) {
			return userDao.save(t);
		}
		throw new InvalidDataException("User: Invalid Data");
	}

	@Override
	public void update(User t) throws InvalidDataException {
		if (validate(t)) {
			userDao.save(t);
		} else {
			throw new InvalidDataException("User: Invalid Data");
		}
	}

	@Override
	public Optional<User> findById(Integer id) throws NotFoundException {
		// return userDao.findById(id);
		final Optional<User> user = userDao.findById(id);
		if (user.isPresent()) {
			return user;
		}
		throw new NotFoundException("User " + id + " not found.");
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

	@Override
	public boolean validate(User t) {
		return t != null && t.getName() != null && t.getEmail() != null && t.getPassword() != null;
	}

}
