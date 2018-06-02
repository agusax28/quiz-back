package com.apm.quizback.dto.questionary;

import java.io.Serializable;

import com.apm.quizback.dto.CourseDTO;

import lombok.Data;

@Data
public class QuestionaryDTO implements Serializable{

	private static final long serialVersionUID = 7786479742811725659L;
	
	private Integer idQuestionary;
	private String name;
	private CourseDTO course;
	
}
