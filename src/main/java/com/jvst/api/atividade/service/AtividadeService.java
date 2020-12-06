package com.jvst.api.atividade.service;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.jvst.api.atividade.form.AtividadeForm;
import com.jvst.api.atividade.model.Atividade;
import com.jvst.api.atividade.repository.AtividadeRepository;
import com.jvst.api.atividadeTag.service.AtividadeTagService;
import com.jvst.api.instrutor.model.Instrutor;
import com.jvst.api.instrutor.service.InstrutorService;
import com.jvst.api.video.service.VideoService;

@Service
public class AtividadeService {

	@Autowired
	private AtividadeRepository atividadeRepository;

	@Autowired
	private VideoService videoService;

	@Autowired
	private InstrutorService instrutorService;

	@Autowired
	private AtividadeTagService atividadeTagService;

	public Atividade buscarAtividadePorId(Long idAtividade) {
		Optional<Atividade> atividade = this.atividadeRepository.findById(idAtividade);
		if (!atividade.isPresent()) {
			throw new EmptyResultDataAccessException("Atividade não encontrada", 1);
		}
		return atividade.get();
	}

	public List<Atividade> listarAtividadePorIdInstrutor(Long idInstrutor) {
		Instrutor instrutor = this.instrutorService.buscarInstrutorPorId(idInstrutor);
		return this.atividadeRepository.findByInstrutor(instrutor);
	}

	public Atividade cadastrarAtividade(AtividadeForm atividadeForm) {
		Atividade atividade = new Atividade();
		atividade.setTitulo(atividadeForm.getTitulo());
		atividade.setDescricao(atividadeForm.getDescricao());
		atividade.setMaterial(atividadeForm.getMaterial());
		atividade.setDataCadastro(Timestamp.from(Instant.now()));
		atividade.setInstrutor(this.instrutorService.buscarInstrutorPorId(atividadeForm.getIdInstrutor()));
		atividade.setVideo(this.videoService.buscarVideoPorId(atividadeForm.getIdVideo()));
		Atividade atividadeCadastrada = this.atividadeRepository.save(atividade);
		this.atividadeTagService.salvarVariasAtividadeTag(atividadeCadastrada.getId(), atividadeForm.getTags());
		return atividadeCadastrada;
	}

	public Atividade atualizarAtividade(Long idAtividade, AtividadeForm atividadeForm) {
		Atividade atividade = this.buscarAtividadePorId(idAtividade);
		atividade.setTitulo(atividadeForm.getTitulo());
		atividade.setDescricao(atividadeForm.getDescricao());
		atividade.setMaterial(atividadeForm.getMaterial());
		atividade.setVideo(this.videoService.buscarVideoPorId(atividadeForm.getIdVideo()));
		return this.atividadeRepository.save(atividade);
	}
}
