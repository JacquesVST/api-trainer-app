package com.jvst.api.avaliacao.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.jvst.api.aluno.model.Aluno;
import com.jvst.api.aluno.service.AlunoService;
import com.jvst.api.aula.model.Aula;
import com.jvst.api.aula.service.AulaService;
import com.jvst.api.avaliacao.model.Avaliacao;
import com.jvst.api.avaliacao.repository.AvaliacaoRepository;

@Service
public class AvaliacaoService {

	@Autowired
	private AvaliacaoRepository avaliacaoRepository;

	@Autowired
	private AlunoService alunoService;

	@Autowired
	private AulaService aulaService;

	public Avaliacao buscarAvaliacaPorId(Long idAvaliacao) {
		Optional<Avaliacao> avaliacao = this.avaliacaoRepository.findById(idAvaliacao);
		if (!avaliacao.isPresent()) {
			throw new EmptyResultDataAccessException("Avaliação não encontrada", 1);
		}
		return avaliacao.get();
	}

	public List<Avaliacao> listarAvaliacaoPorIdAluno(Long idAluno) {
		Aluno aluno = this.alunoService.buscarAlunoPorId(idAluno);
		return this.avaliacaoRepository.findByAluno(aluno);
	}

	public List<Avaliacao> listarAvaliacaoPorIdAula(Long idAula) {
		Aula aula = this.aulaService.buscarAulaPorId(idAula);
		return this.avaliacaoRepository.findByAula(aula);
	}

	public void salvarAvaliacao(Avaliacao avaliacao) {
		this.avaliacaoRepository.save(avaliacao);
	}
}
