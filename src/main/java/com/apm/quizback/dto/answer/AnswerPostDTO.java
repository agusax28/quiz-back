package com.apm.quizback.dto.answer;

import com.apm.quizback.dto.QuestionDTO;

import lombok.Data;

@Data
public class AnswerPostDTO extends AnswerDTO {
	
	private static final long serialVersionUID = -9012397141077994021L;
	
	private boolean isCorrect;
	private QuestionDTO question;
	
}
