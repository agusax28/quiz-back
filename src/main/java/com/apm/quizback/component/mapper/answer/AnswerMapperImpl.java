package com.apm.quizback.component.mapper.answer;

import org.springframework.stereotype.Component;

import com.apm.quizback.component.mapper.AbstractMapper;
import com.apm.quizback.dto.answer.AnswerDTO;
import com.apm.quizback.model.Answer;

@Component
public class AnswerMapperImpl extends AbstractMapper<Answer, AnswerDTO> implements AnswerMapper {

	@Override
	public Class<? extends AnswerDTO> dtoClazz() {
		return AnswerDTO.class;
	}

	@Override
	public Class<? extends Answer> modelClazz() {
		return Answer.class;
	}
	
}
