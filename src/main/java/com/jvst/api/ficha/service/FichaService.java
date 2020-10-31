package com.jvst.api.ficha.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.jvst.api.aluno.model.Aluno;
import com.jvst.api.aluno.service.AlunoService;
import com.jvst.api.ficha.model.Ficha;
import com.jvst.api.ficha.repository.FichaRepository;

@Service
public class FichaService {
	
	@Autowired
	private FichaRepository fichaRepository;
	
	@Autowired
	private AlunoService alunoService;
	
	public Ficha buscarFichaPorId(Long idFicha) {
		Optional<Ficha> ficha = this.fichaRepository.findById(idFicha);
		if (!ficha.isPresent()) {
			throw new EmptyResultDataAccessException("Ficha não encontrada", 1);
		}
		return ficha.get();
	}

	public List<Ficha> listarFichaPorIdAluno(Long idAluno) {
		Aluno aluno = this.alunoService.buscarAlunoPorId(idAluno);
		return this.fichaRepository.findByAluno(aluno);
	}

	public void salvarFicha(Ficha ficha) {
		this.fichaRepository.save(ficha);
	}
}
