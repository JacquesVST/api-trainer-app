package com.jvst.api.atividadeTag.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

	public List<AtividadeTag> listarAtividadeTagPorIdAtividade(Long idAtividade) {
		Atividade atividade = this.atividadeService.buscarAtividadePorId(idAtividade);
		return this.atividadeTagRepository.findByAtividade(atividade);
	}

	public List<AtividadeTag> listarAtividadeTagPorIdTag(Long idTag) {
		Tag tag = this.tagService.buscarTagPorId(idTag);
		return this.atividadeTagRepository.findByTag(tag);
	}

}
