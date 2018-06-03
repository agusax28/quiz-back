package com.apm.quizback.dto.question;

import java.io.Serializable;

import com.apm.quizback.dto.answer.AnswerDTO;

import lombok.Data;

@Data
public class QuestionExamDTO implements Serializable{
	
	private static final long serialVersionUID = 8216073234631948679L;
	
	private Integer idQuestion;
	private String name;
	private AnswerDTO answer;
	
}