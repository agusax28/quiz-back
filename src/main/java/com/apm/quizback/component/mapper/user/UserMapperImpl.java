package com.apm.quizback.component.mapper.user;

import org.springframework.stereotype.Component;

import com.apm.quizback.component.mapper.AbstractMapper;
import com.apm.quizback.dto.UserDTO;
import com.apm.quizback.model.User;

@Component
public class UserMapperImpl extends AbstractMapper<User, UserDTO> implements UserMapper {

	@Override
	public Class<? extends UserDTO> dtoClazz() {
		return UserDTO.class;
	}

	@Override
	public Class<? extends User> modelClazz() {
		return User.class;
	}

}