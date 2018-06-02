package com.apm.quizback.dto.question;

import java.io.Serializable;

import com.apm.quizback.dto.DifficultyDTO;
import com.apm.quizback.dto.TagDTO;

import lombok.Data;

@Data
public class QuestionDTO implements Serializable{
	
	private static final long serialVersionUID = -4463223954672104279L;
	
	private Integer idQuestion;
	private String name;
	private DifficultyDTO difficulty;
	private TagDTO tag;
	
}