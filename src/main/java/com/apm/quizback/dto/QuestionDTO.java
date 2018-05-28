package com.apm.quizback.dto;

import com.apm.quizback.model.Difficulty;
import com.apm.quizback.model.Tag;

import lombok.Data;

@Data
public class QuestionDTO {
	
	private Integer idQuestion;
	private String name;
	private Difficulty difficulty;
	private Tag tag;
	
}