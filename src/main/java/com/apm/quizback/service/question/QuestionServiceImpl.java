package com.apm.quizback.service.question;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.apm.quizback.dao.QuestionDAO;
import com.apm.quizback.exception.InvalidDataException;
import com.apm.quizback.exception.NotFoundException;
import com.apm.quizback.model.Difficulty;
import com.apm.quizback.model.Question;
import com.apm.quizback.model.Questionary;
import com.apm.quizback.model.Tag;
import com.apm.quizback.service.difficulty.DifficultyService;
import com.apm.quizback.service.questionary.QuestionaryService;
import com.apm.quizback.service.tag.TagService;

@Service
public class QuestionServiceImpl implements QuestionService {

	@Autowired
	QuestionDAO questionDao;

	@Autowired
	QuestionaryService questionaryService;

	@Autowired
	TagService tagService;

	@Autowired
	DifficultyService difficultyService;

	@Override
	public Question create(Question t) throws InvalidDataException {
		if (validate(t)) {
			return questionDao.save(t);
		}
		throw new InvalidDataException("Question: Invalid Data");
	}

	@Override
	public void update(Question t) throws InvalidDataException {
		if (validate(t)) {
			questionDao.save(t);
		} else {
			throw new InvalidDataException("Question: Invalid Data");
		}
	}

	@Override
	public Optional<Question> findById(Integer id) throws NotFoundException {
		final Optional<Question> question = questionDao.findById(id);
		if (question.isPresent()) {
			return question;
		}
		throw new NotFoundException("Question " + id + " not found.");
	}

	@Override
	public List<Question> findAll(Pageable p) {
		int page = p.getPageNumber();
		int size = p.getPageSize();
		return questionDao.findAll(PageRequest.of(page, size)).stream().collect(Collectors.toList());
	}

	@Override
	public void delete(Question t) {
		questionDao.delete(t);
	}

	@Override
	public boolean validate(Question t) {
		return t != null && t.getName() != null;
	}

	@Override
	public List<Question> findAll(Pageable p, Integer idQuestionary) throws NotFoundException {
		int page = p.getPageNumber();
		int size = p.getPageSize();
		final Optional<Questionary> questionary = questionaryService.findById(idQuestionary);
		if (questionary.isPresent()) {
			List<Question> question = questionary.get().getQuestion();
			return new PageImpl<Question>(question, PageRequest.of(page, size), question.size()).stream()
					.collect(Collectors.toList());
		}
		throw new NotFoundException("Questionary " + idQuestionary + " not found.");
	}

	@Override
	public Question create(Question question, Integer idQuestionary, Integer idTag, Integer idDifficulty)
			throws NotFoundException, InvalidDataException {
		final Optional<Questionary> questionary = questionaryService.findById(idQuestionary);
		final Optional<Tag> tag = tagService.findById(idTag);
		final Optional<Difficulty> difficulty = difficultyService.findById(idDifficulty);
		if (validate(question) && questionary.isPresent()) {
			question.setTag(tag.get());
			question.setDifficulty(difficulty.get());
			questionary.get().getQuestion().add(question);
			return questionDao.save(question);
		}
		throw new InvalidDataException("Question: Invalid Data");
	}

	@Override
	public void update(Question question, Integer idTag, Integer idDifficulty) throws InvalidDataException, NotFoundException {
		final Optional<Tag> tag = tagService.findById(idTag);
		final Optional<Difficulty> difficulty = difficultyService.findById(idDifficulty);
		if (validate(question)) {
			question.setTag(tag.get());
			question.setDifficulty(difficulty.get());
			questionDao.save(question);
		} else {
			throw new InvalidDataException("Question: Invalid Data");
		}
	}

}