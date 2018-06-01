package com.apm.quizback.controller;

import java.util.List;
import java.util.Optional;

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

import com.apm.quizback.component.mapper.tag.TagMapper;
import com.apm.quizback.dto.TagDTO;
import com.apm.quizback.exception.InvalidDataException;
import com.apm.quizback.exception.NotFoundException;
import com.apm.quizback.model.Tag;
import com.apm.quizback.service.tag.TagService;

@RestController
@RequestMapping(value = "/tag")
public class TagController {

	@Autowired
	TagService tagService;

	@Autowired
	TagMapper tagMapper;

	@GetMapping
	public List<TagDTO> findAll(@RequestParam(defaultValue = "0", required = false) Integer page,
			@RequestParam(defaultValue = "10", required = false) Integer size) {
		final List<Tag> tag = tagService.findAll(PageRequest.of(page, size));
		return tagMapper.modelToDto(tag);
	}

	@GetMapping("/{id}")
	public TagDTO findById(@PathVariable Integer id) throws NotFoundException {
		final Optional<Tag> tag = tagService.findById(id);
		return tagMapper.modelToDto(tag.get());
	}

	@PostMapping
	public TagDTO create(@RequestBody TagDTO dto) throws InvalidDataException {
		final Tag tag = tagMapper.dtoToModel(dto);
		final Tag createTag = tagService.create(tag);
		return tagMapper.modelToDto(createTag);
	}

	@PutMapping("/{id}")
	public void update(@PathVariable Integer id, @RequestBody TagDTO dto) throws InvalidDataException {
		dto.setIdTag(id);
		final Tag tag = tagMapper.dtoToModel(dto);
		tagService.update(tag);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Integer id) throws NotFoundException {
		final Optional<Tag> tag = tagService.findById(id);
		tagService.delete(tag.get());
	}

}
