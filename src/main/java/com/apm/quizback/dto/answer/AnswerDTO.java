package com.apm.quizback.dto.answer;

import java.io.Serializable;

import com.apm.quizback.dto.QuestionDTO;

import lombok.Data;

@Data
public class AnswerDTO implements Serializable {

	private static final long serialVersionUID = -7326994064196156599L;
	
	private Integer idAnswer;
	//private Boolean isCorrect;
	private String name;
	//private QuestionDTO question;
	
}
