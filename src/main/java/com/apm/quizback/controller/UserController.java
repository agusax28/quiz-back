package com.apm.quizback.controller;

import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.apm.quizback.component.mapper.user.UserMapper;
import com.apm.quizback.dto.UserDTO;
import com.apm.quizback.dto.UserPostDTO;
import com.apm.quizback.model.User;
import com.apm.quizback.service.UserService;

@RestController
@RequestMapping(value = "/user")
public class UserController {

	@Autowired
	UserService userService;

	@Autowired
	UserMapper userMapper;

	@RequestMapping(method = RequestMethod.GET)
	public Set<UserDTO> findAll(@RequestParam(defaultValue = "0", required = false) Integer page,
			@RequestParam(defaultValue = "10", required = false) Integer size) {
		final Set<User> users = userService.findAll(PageRequest.of(page, size));
		return userMapper.modelToDto(users);
	}

	@RequestMapping(method = RequestMethod.POST)
	public UserDTO create(@RequestBody UserPostDTO dto) {
		final User user = userMapper.dtoToModel(dto);
		final User createUser = userService.create(user);
		return userMapper.modelToDto(createUser);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public void update(@RequestBody UserPostDTO dto) {
		final User user = userMapper.dtoToModel(dto);
        userService.update(user);
    }
	
	@RequestMapping(value = "/{idUser}", method = RequestMethod.DELETE)
	public void delete(@PathVariable Integer idUser) {
		final Optional<User> user = userService.findById(idUser);
		userService.delete(user.get());
	}
	
}
