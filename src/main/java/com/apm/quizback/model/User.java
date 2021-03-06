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
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class User {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idUser;

	@Column(nullable = false)
	private String name;

	@Column(unique = true, nullable = false)
	private String email;

	private String password;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = Result.FIELD_USER)
	private List<Result> result;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = Selection.FIELD_USER)
	private List<Selection> selection;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable (name= "user_course",
			joinColumns= {@JoinColumn(name= "idUser")},
			inverseJoinColumns= {@JoinColumn(name= "idCourse")})
	private List<Course> course;
	
}