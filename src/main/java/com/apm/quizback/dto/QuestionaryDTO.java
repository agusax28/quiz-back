package com.apm.quizback.dto;

import com.apm.quizback.model.Course;

import lombok.Data;

@Data
public class QuestionaryDTO {

	private Integer idQuestionary;
	private String name;
	private Course course;
	
}
