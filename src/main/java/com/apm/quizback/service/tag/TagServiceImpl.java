package com.apm.quizback.service.tag;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.apm.quizback.dao.TagDAO;
import com.apm.quizback.exception.InvalidDataException;
import com.apm.quizback.exception.NotFoundException;
import com.apm.quizback.model.Tag;

@Service
public class TagServiceImpl implements TagService {

	@Autowired
	TagDAO tagDao;

	@Override
	public Tag create(Tag t) throws InvalidDataException {
		if (validate(t)) {
			return tagDao.save(t);
		}
		throw new InvalidDataException("Tag: Invalid Data");
	}

	@Override
	public void update(Tag t) throws InvalidDataException {
		if (validate(t)) {
			tagDao.save(t);
		} else {
			throw new InvalidDataException("Tag: Invalid Data");
		}
	}

	@Override
	public Optional<Tag> findById(Integer id) throws NotFoundException {
		// return tagDao.findById(id);
		final Optional<Tag> tag = tagDao.findById(id);
		if (tag.isPresent()) {
			return tag;
		}
		throw new NotFoundException("Tag " + id + " not found.");
	}

	@Override
	public Set<Tag> findAll(Pageable p) {
		int page = p.getPageNumber();
		int size = p.getPageSize();
		return tagDao.findAll(PageRequest.of(page, size)).stream().collect(Collectors.toSet());
	}

	@Override
	public void delete(Tag t) {
		tagDao.delete(t);
	}

	@Override
	public boolean validate(Tag t) {
		return t != null && t.getName() != null;
	}
}
