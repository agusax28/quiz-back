package com.apm.quizback.dto.questionary;

import java.io.Serializable;

import com.apm.quizback.dto.CourseDTO;
import com.apm.quizback.dto.question.QuestionExamDTO;

import lombok.Data;

@Data
public class QuestionaryExamDTO implements Serializable{

	private static final long serialVersionUID = -3352436813655123687L;
	
	private CourseDTO course;
	private String name;
	private QuestionExamDTO question;

}
