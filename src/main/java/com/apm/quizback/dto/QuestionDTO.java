package com.apm.quizback.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class QuestionDTO implements Serializable{
	
	private static final long serialVersionUID = -4463223954672104279L;
	
	private Integer idQuestion;
	private String name;
	private DifficultyDTO difficulty;
	private TagDTO tag;
	
}