package com.jvst.api.tag.service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.jvst.api.tag.model.Tag;
import com.jvst.api.tag.repository.TagRepository;

@Service
public class TagService {

	@Autowired
	private TagRepository tagRepository;

	public List<Tag> listarTags() {
		List<Tag> tags = this.tagRepository.findAll();
		tags.sort(Comparator.comparing(Tag::getDescricao));
		return tags;
	}

	public Tag buscarTagPorId(Long idTag) {
		Optional<Tag> tag = this.tagRepository.findById(idTag);
		if (!tag.isPresent()) {
			throw new EmptyResultDataAccessException("Tag não encontrada", 1);
		}
		return tag.get();
	}

	public void salvarTag(Tag tag) {
		this.tagRepository.save(tag);
	}
}
