package com.apm.quizback.dto;

import lombok.Data;

@Data
public class QuestionDTO {
	
	private Integer idQuestion;
	private String name;
	private Integer difficulty;
	private Integer tag;
	
}