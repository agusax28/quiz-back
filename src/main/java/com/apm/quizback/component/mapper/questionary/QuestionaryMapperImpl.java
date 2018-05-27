package com.apm.quizback.component.mapper.questionary;

import org.springframework.stereotype.Component;

import com.apm.quizback.component.mapper.AbstractMapper;
import com.apm.quizback.dto.QuestionaryDTO;
import com.apm.quizback.model.Questionary;

@Component
public class QuestionaryMapperImpl extends AbstractMapper<Questionary, QuestionaryDTO> implements QuestionaryMapper{

	@Override
	public Class<? extends QuestionaryDTO> dtoClazz() {
		return QuestionaryDTO.class;
	}

	@Override
	public Class<? extends Questionary> modelClazz() {
		return Questionary.class;
	}

}
