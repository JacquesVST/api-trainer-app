package com.jvst.api.sessao.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.jvst.api.aluno.model.Aluno;
import com.jvst.api.aluno.service.AlunoService;
import com.jvst.api.aula.model.Aula;
import com.jvst.api.aula.service.AulaService;
import com.jvst.api.sessao.model.Sessao;
import com.jvst.api.sessao.repository.SessaoRepository;

@Service
public class SessaoService {

	@Autowired
	private SessaoRepository sessaoRepository;

	@Autowired
	private AulaService aulaService;

	@Autowired
	private AlunoService alunoService;

	public Sessao buscarSessaoPorId(Long idSessao) {
		Optional<Sessao> sessao = this.sessaoRepository.findById(idSessao);
		if (!sessao.isPresent()) {
			throw new EmptyResultDataAccessException("Sessão não encontrada", 1);
		}
		return sessao.get();
	}

	public List<Sessao> listarSessaoPorIdAula(Long idAula) {
		Aula aula = this.aulaService.buscarAulaPorId(idAula);
		return this.sessaoRepository.findByAula(aula);
	}

	public List<Sessao> listarSessaoPorIdAluno(Long idAluno) {
		Aluno aluno = this.alunoService.buscarAlunoPorId(idAluno);
		return this.sessaoRepository.findByAluno(aluno);
	}

	public void salvarSessao(Sessao sessao) {
		this.sessaoRepository.save(sessao);
	}
}