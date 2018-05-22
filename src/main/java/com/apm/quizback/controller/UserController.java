package com.apm.quizback.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.apm.quizback.service.UserService;

@Controller
public class UserController {

	@Autowired
	UserService userService;
}
