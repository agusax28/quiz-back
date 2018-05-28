package com.apm.quizback.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
public class Questionary {

	public static final String FIELD_COURSE = "course";
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idQuestionary;
	
	@Column(nullable = false)
	private String name;
	
	@JoinColumn(name = FIELD_COURSE)
	@ManyToOne(fetch = FetchType.LAZY)
	private Course course;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = Result.FIELD_QUESTIONARY)
	private List<Result> result;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable (name= "tag_questionary",
			joinColumns= {@JoinColumn(name= "idQuestionary")},
			inverseJoinColumns= {@JoinColumn(name= "idTag")})
	private List<Tag> tag;
	
	@ManyToMany
	@JoinTable (name= "question_questionary",
			joinColumns= {@JoinColumn(name= "idQuestionary")},
			inverseJoinColumns= {@JoinColumn(name= "idQuestion")})
	private List<Question> question;
	
}
