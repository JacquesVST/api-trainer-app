package com.jvst.api.atividadeTag.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.jvst.api.atividade.model.Atividade;
import com.jvst.api.atividade.service.AtividadeService;
import com.jvst.api.atividadeTag.model.AtividadeTag;
import com.jvst.api.atividadeTag.repository.AtividadeTagRepository;
import com.jvst.api.tag.model.Tag;
import com.jvst.api.tag.service.TagService;

@Service
public class AtividadeTagService {

	@Autowired
	private AtividadeTagRepository atividadeTagRepository;

	@Autowired
	private AtividadeService atividadeService;

	private TagService tagService;

	public AtividadeTag buscarAtividadeTagPorId(Long idAtividadeTag) {
		Optional<AtividadeTag> atividadeTag = this.atividadeTagRepository.findById(idAtividadeTag);
		if (!atividadeTag.isPresent()) {
			throw new EmptyResultDataAccessException("Atividade não encontrada", 1);
		}
		return atividadeTag.get();
	}

	public List<Tag> listarTagsPorIdAtividade(Long idAtividade) {
		Atividade atividade = this.atividadeService.buscarAtividadePorId(idAtividade);
		List<AtividadeTag> atividadeTags = this.atividadeTagRepository.findByAtividade(atividade);
		return atividadeTags.stream().map(AtividadeTag::getTag).distinct().collect(Collectors.toList());
	}

	public List<Atividade> listarAtividadesPorIdTag(Long idTag) {
		Tag tag = this.tagService.buscarTagPorId(idTag);
		List<AtividadeTag> atividadeTags = this.atividadeTagRepository.findByTag(tag);
		return atividadeTags.stream().map(AtividadeTag::getAtividade).distinct().collect(Collectors.toList());
	}

	public AtividadeTag salvarAtividadeTag(AtividadeTag atividadeTag) {
		return this.atividadeTagRepository.save(atividadeTag);
	}

	public void salvarVariasAtividadeTag(Long idAtividade, List<Tag> tags) {
		Atividade atividade = this.atividadeService.buscarAtividadePorId(idAtividade);
		List<AtividadeTag> atividadeTags = new ArrayList<>();
		for (Tag tag : tags) {
			atividadeTags.add(new AtividadeTag(atividade, tag));
		}
		this.atividadeTagRepository.saveAll(atividadeTags);
	}

}
