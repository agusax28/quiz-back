package com.apm.quizback.dto;

import java.io.Serializable;

import com.apm.quizback.dto.questionary.QuestionaryDTO;
import com.apm.quizback.dto.user.UserDTO;

import lombok.Data;

@Data
public class SelectionDTO implements Serializable{

	private static final long serialVersionUID = -3756030551818617683L;
	
	private Integer idSelection;
	private UserDTO user;
	private QuestionaryDTO questionary;
	private String question;
	private String answer;
	private Boolean isCorrect;
	
}
