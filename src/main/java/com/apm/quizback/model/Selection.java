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
public class Selection {
	
	public static final String FIELD_USER = "user";
	public static final String FIELD_QUESTIONARY = "questionary";

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idSelection;
	
	@JoinColumn(name = FIELD_USER)
	@ManyToOne(fetch = FetchType.LAZY)
	private User user;
	
	@JoinColumn(name = FIELD_QUESTIONARY)
	@ManyToOne(fetch = FetchType.LAZY)
	private Questionary questionary;
	
	@Column(nullable = false)
	private String question;
	
	@Column(nullable = false)
	private String answer;
	
	@Column(nullable = false)
	private boolean isCorrect;
}
