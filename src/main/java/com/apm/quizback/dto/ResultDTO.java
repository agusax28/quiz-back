package com.apm.quizback.dto;

import java.util.Date;

import com.apm.quizback.dto.questionary.QuestionaryDTO;
import com.apm.quizback.dto.user.UserDTO;

import lombok.Data;

@Data
public class ResultDTO {

	private Integer idResult;
	private Date date;
	private float score;
	private QuestionaryDTO questionary;
	private UserDTO user;
}
