package com.apm.quizback.component.mapper.difficulty;

import org.springframework.stereotype.Component;

import com.apm.quizback.component.mapper.AbstractMapper;
import com.apm.quizback.dto.DifficultyDTO;
import com.apm.quizback.model.Difficulty;

@Component
public class DifficultyMapperImpl extends AbstractMapper<Difficulty, DifficultyDTO> implements DifficultyMapper{

	@Override
	public Class<? extends DifficultyDTO> dtoClazz() {
		return DifficultyDTO.class;
	}

	@Override
	public Class<? extends Difficulty> modelClazz() {
		return Difficulty.class;
	}

}
