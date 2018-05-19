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
public class Cuestionary {

	public static final String FIELD_COURSE = "course";
	
	@Id
	@GeneratedValue
	private Integer idCuestionary;
	
	@Column(nullable = false)
	private String name;
	
	@JoinColumn(name = FIELD_COURSE)
	@ManyToOne(fetch = FetchType.LAZY)
	private Course course;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = Result.FIELD_CUESTIONARY)
	private List<Result> result;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable (name= "tag_cuestionary",
			joinColumns= {@JoinColumn(name= "idCuestionary")},
			inverseJoinColumns= {@JoinColumn(name= "idTag")})
	private List<Tag> tag;
	
	@ManyToMany
	@JoinTable (name= "question_cuestionary",
			joinColumns= {@JoinColumn(name= "idCuestionary")},
			inverseJoinColumns= {@JoinColumn(name= "idQuestion")})
	private List<Question> question;
	
}
