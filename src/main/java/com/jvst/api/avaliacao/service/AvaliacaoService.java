package com.jvst.api.avaliacao.service;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.jvst.api.aluno.model.Aluno;
import com.jvst.api.aluno.service.AlunoService;
import com.jvst.api.aula.model.Aula;
import com.jvst.api.aula.service.AulaService;
import com.jvst.api.avaliacao.form.AvaliacaoForm;
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

	public Avaliacao cadastrarAvaliacao(AvaliacaoForm avaliacaoForm) {
		Avaliacao avaliacao = new Avaliacao();
		avaliacao.setTitulo(avaliacaoForm.getTitulo());
		avaliacao.setConteudo(avaliacaoForm.getConteudo());
		avaliacao.setNota(avaliacaoForm.getNota());
		avaliacao.setDataHora(Timestamp.from(Instant.now()));
		avaliacao.setAluno(this.alunoService.buscarAlunoPorId(avaliacaoForm.getIdAluno()));
		avaliacao.setAula(this.aulaService.buscarAulaPorId(avaliacaoForm.getIdAula()));
		return this.avaliacaoRepository.save(avaliacao);
	}

	public Avaliacao atualizarAvaliacao(Long idAvaliacao, AvaliacaoForm avaliacaoForm) {
		Avaliacao avaliacao = this.buscarAvaliacaPorId(idAvaliacao);
		avaliacao.setTitulo(avaliacaoForm.getTitulo());
		avaliacao.setConteudo(avaliacaoForm.getConteudo());
		avaliacao.setNota(avaliacaoForm.getNota());
		return this.avaliacaoRepository.save(avaliacao);
	}

	public void excluirAvaliacao(Long idAvaliacao) {
		this.avaliacaoRepository.deleteById(idAvaliacao);
	}

}
