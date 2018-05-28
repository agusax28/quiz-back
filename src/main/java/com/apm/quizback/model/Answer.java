package com.apm.quizback.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Answer {
	
	public static final String FIELD_QUESTION = "question";
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idAnswer;
	
	@Column(nullable = false)
	private String name;
	
	@Column(nullable = false)
	private boolean isCorrect;
	
	@JoinColumn(name = FIELD_QUESTION)
	@ManyToOne(fetch = FetchType.LAZY)
	private Question question;

}
