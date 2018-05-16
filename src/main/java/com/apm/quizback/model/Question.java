package com.apm.quizback.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Question {
	
	public static final String FIELD_TAG = "tag";

	@Id
	@GeneratedValue
	private Integer id;
	
	@Column(nullable = false)
	private String name;
	
	@JoinColumn(name = FIELD_TAG)
	@ManyToOne(fetch = FetchType.LAZY)
	private Tag tag;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = Answer.FIELD_QUESTION)
	private List<Answer> answer;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = Difficulty.FIELD_QUESTION)
	private List<Difficulty> difficulty;
	
	@ManyToMany
	@JoinTable (name= "question_cuestionary",
			joinColumns= {@JoinColumn(name= "idQuestion")},
			inverseJoinColumns= {@JoinColumn(name= "idCuestionary")})
	private List<Cuestionary> cuestionary;
	
}
