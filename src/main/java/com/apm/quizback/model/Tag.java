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
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Tag {
	
	@Id
	@GeneratedValue
	private Integer idTag;
	
	@Column(nullable = false)
	private String name;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = Question.FIELD_TAG)
	private List<Question> question;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable (name= "tag_questionary",
			joinColumns= {@JoinColumn(name= "idTag")},
			inverseJoinColumns= {@JoinColumn(name= "idQuestionary")})
	private List<Questionary> questionary;

}
