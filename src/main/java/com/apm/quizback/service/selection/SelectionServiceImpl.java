package com.apm.quizback.service.selection;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.apm.quizback.dao.SelectionDAO;
import com.apm.quizback.exception.InvalidDataException;
import com.apm.quizback.exception.NotFoundException;
import com.apm.quizback.model.Answer;
import com.apm.quizback.model.Questionary;
import com.apm.quizback.model.Selection;
import com.apm.quizback.model.User;
import com.apm.quizback.service.answer.AnswerService;
import com.apm.quizback.service.question.QuestionService;
import com.apm.quizback.service.questionary.QuestionaryService;
import com.apm.quizback.service.user.UserService;

@Service
public class SelectionServiceImpl implements SelectionService{
	
	@Autowired
	SelectionDAO selectionDao;
	
	@Autowired
	UserService userService;
	
	@Autowired
	QuestionaryService questionaryService;
	
	@Autowired
	QuestionService questionService;
	
	@Autowired
	AnswerService answerService;

	@Override
	public Selection create(Selection t) throws InvalidDataException {
		if (validate(t)) {
			return selectionDao.save(t);
		}
		throw new InvalidDataException("Selection: Invalid Data");
	}

	@Override
	public void update(Selection t) throws InvalidDataException {
		if (validate(t)) {
			selectionDao.save(t);
		} else {
			throw new InvalidDataException("Selection: Invalid Data");
		}
	}

	@Override
	public Optional<Selection> findById(Integer id) throws NotFoundException {
		final Optional<Selection> selection = selectionDao.findById(id);
		if (selection.isPresent()) {
			return selection;
		}
		throw new NotFoundException("Selection " + id + " not found.");
	}

	@Override
	public List<Selection> findAll(Pageable p) {
		int page = p.getPageNumber();
		int size = p.getPageSize();
		return selectionDao.findAll(PageRequest.of(page, size)).stream().collect(Collectors.toList());
	}

	@Override
	public void delete(Selection t) {
		selectionDao.delete(t);
	}

	@Override
	public boolean validate(Selection t) {
		return t != null;
	}

	@Override
	public Selection create(Integer idUser, Integer idQuestionary, Integer idQuestion, Integer idAnswer) throws NotFoundException, InvalidDataException {
		final Optional<User> user = userService.findById(idUser);
		final Optional<Questionary> questionary = questionaryService.findById(idQuestionary);
		final Optional<Answer> answer = answerService.findById(idAnswer);
		
		Selection res = new Selection();
		res.setUser(user.get());
		res.setQuestionary(questionary.get());
		res.setQuestion(answer.get().getQuestion().getName());
		res.setAnswer(answer.get().getName());
		res.setCorrect(answer.get().getIsCorrect());
		
		return create(res);
	}

}
