package com.apm.quizback.component.mapper.question;

import org.springframework.stereotype.Component;

import com.apm.quizback.component.mapper.AbstractMapper;
import com.apm.quizback.dto.QuestionDTO;
import com.apm.quizback.model.Question;

@Component
public class QuestionMapperImpl extends AbstractMapper<Question, QuestionDTO> implements QuestionMapper {

	@Override
	public Class<? extends QuestionDTO> dtoClazz() {
		return QuestionDTO.class;
	}

	@Override
	public Class<? extends Question> modelClazz() {
		return Question.class;
	}

}
