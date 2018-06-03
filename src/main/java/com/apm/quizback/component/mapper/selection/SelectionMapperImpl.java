package com.apm.quizback.component.mapper.selection;

import org.springframework.stereotype.Component;

import com.apm.quizback.component.mapper.AbstractMapper;
import com.apm.quizback.dto.SelectionDTO;
import com.apm.quizback.model.Selection;

@Component
public class SelectionMapperImpl extends AbstractMapper<Selection, SelectionDTO> implements SelectionMapper {

	@Override
	public Class<? extends SelectionDTO> dtoClazz() {
		return SelectionDTO.class;
	}

	@Override
	public Class<? extends Selection> modelClazz() {
		return Selection.class;
	}

}
