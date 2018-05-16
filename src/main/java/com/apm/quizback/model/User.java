package com.apm.quizback.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class User {

	@Id
	@GeneratedValue
	private Integer idUser;

	@Column(nullable = false)
	private String name;

	@Column(unique = true, nullable = false)
	private String email;

	private String password;
	
	@ManyToMany
	@JoinTable (name= "user_course",
			joinColumns= {@JoinColumn(name= "idUser")},
			inverseJoinColumns= {@JoinColumn(name= "idCourse")})
	private List<Course> course;
	
}