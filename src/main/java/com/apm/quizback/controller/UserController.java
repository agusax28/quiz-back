package com.apm.quizback.controller;

import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.apm.quizback.component.mapper.user.UserMapper;
import com.apm.quizback.dto.user.UserDTO;
import com.apm.quizback.dto.user.UserPostDTO;
import com.apm.quizback.exception.InvalidDataException;
import com.apm.quizback.exception.NotFoundException;
import com.apm.quizback.model.User;
import com.apm.quizback.service.user.UserService;

@RestController
@RequestMapping(value = "/user")
public class UserController {

	@Autowired
	UserService userService;

	@Autowired
	UserMapper userMapper;

	// @RequestMapping(method = RequestMethod.GET)
	@GetMapping
	public Set<UserDTO> findAll(@RequestParam(defaultValue = "0", required = false) Integer page,
			@RequestParam(defaultValue = "10", required = false) Integer size) {
		final Set<User> users = userService.findAll(PageRequest.of(page, size));
		return userMapper.modelToDto(users);
	}

	// @RequestMapping(method = RequestMethod.GET)
	@GetMapping("/{id}")
	public UserDTO findById(@PathVariable Integer id) throws NotFoundException {
		final Optional<User> user = userService.findById(id);
		return userMapper.modelToDto(user.get());
	}

	// @RequestMapping(method = RequestMethod.POST)
	@PostMapping
	public UserDTO create(@RequestBody UserPostDTO dto) throws InvalidDataException {
		final User user = userMapper.dtoToModel(dto);
		final User createUser = userService.create(user);
		return userMapper.modelToDto(createUser);
	}

	// @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	@PutMapping("/{id}")
	public void update(@PathVariable Integer id, @RequestBody UserPostDTO dto) throws InvalidDataException {
		dto.setIdUser(id);
		final User user = userMapper.dtoToModel(dto);
		userService.update(user);
	}

	// @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Integer id) throws NotFoundException {
		final Optional<User> user = userService.findById(id);
		userService.delete(user.get());
	}

}
