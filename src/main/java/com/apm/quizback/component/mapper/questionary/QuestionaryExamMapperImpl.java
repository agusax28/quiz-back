package com.apm.quizback.component.mapper.questionary;

import org.springframework.stereotype.Component;

import com.apm.quizback.component.mapper.AbstractMapper;
import com.apm.quizback.dto.questionary.QuestionaryExamDTO;
import com.apm.quizback.model.Questionary;

@Component
public class QuestionaryExamMapperImpl extends AbstractMapper<Questionary, QuestionaryExamDTO> implements QuestionaryExamMapper{

	@Override
	public Class<? extends QuestionaryExamDTO> dtoClazz() {
		return QuestionaryExamDTO.class;
	}

	@Override
	public Class<? extends Questionary> modelClazz() {
		return Questionary.class;
	}
	
}
