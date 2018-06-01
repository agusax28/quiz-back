package com.apm.quizback.dto;

import lombok.Data;

@Data
public class AnswerDTO {

	private Integer idAnswer;
	private boolean isCorrect;
	private String name;
	//private Question question;
	
}
