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
public class Course {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	@Column(nullable = false)
	private String name;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = Cuestionary.FIELD_COURSE)
	private List<Cuestionary> cuestionary;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = Result.FIELD_COURSE)
	private List<Result> result;
	
	@ManyToMany
	@JoinTable (name= "user_course",
			joinColumns= {@JoinColumn(name= "idCourse")},
			inverseJoinColumns= {@JoinColumn(name= "idUser")})
	private List<User> user;
	
}
