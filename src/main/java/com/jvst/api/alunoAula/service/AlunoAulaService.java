package com.jvst.api.alunoAula.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jvst.api.aluno.model.Aluno;
import com.jvst.api.aluno.service.AlunoService;
import com.jvst.api.alunoAula.model.AlunoAula;
import com.jvst.api.alunoAula.repository.AlunoAulaRepository;
import com.jvst.api.aula.model.Aula;
import com.jvst.api.aula.service.AulaService;

@Service
public class AlunoAulaService {

	@Autowired
	private AlunoAulaRepository alunoAulaRepository;
	
	@Autowired
	private AlunoService alunoService;
	
	@Autowired
	private AulaService aulaService;
	
	public List<AlunoAula> listarAlunoAulaPorIdAluno(Long idAluno){
		Aluno aluno = this.alunoService.buscarAlunoPorId(idAluno);
		return this.alunoAulaRepository.findByAluno(aluno);
	}
	
	public List<AlunoAula> listarAlunoAulaPorIdAula(Long idAula){
		Aula aula = this.aulaService.buscarAulaPorId(idAula);
		return this.alunoAulaRepository.findByAula(aula);
	}
	
	public void salvarAlunoAula(AlunoAula alunoAula) {
		this.alunoAulaRepository.save(alunoAula);
	}
}
