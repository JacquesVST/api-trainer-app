package com.jvst.api.alunoAula.service;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.jvst.api.aluno.model.Aluno;
import com.jvst.api.aluno.service.AlunoService;
import com.jvst.api.alunoAula.form.AlunoAulaForm;
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

	public AlunoAula buscarAlunoAulaPorId(Long idAlunoAula) {
		Optional<AlunoAula> alunoAula = this.alunoAulaRepository.findById(idAlunoAula);
		if (!alunoAula.isPresent()) {
			throw new EmptyResultDataAccessException("Relação aluno-aula não encontrada", 1);
		}
		return alunoAula.get();
	}

	public List<AlunoAula> listarAlunoAulaPorIdAluno(Long idAluno) {
		Aluno aluno = this.alunoService.buscarAlunoPorId(idAluno);
		return this.alunoAulaRepository.findByAluno(aluno);
	}

	public List<AlunoAula> listarAlunoAulaPorIdAula(Long idAula) {
		Aula aula = this.aulaService.buscarAulaPorId(idAula);
		return this.alunoAulaRepository.findByAula(aula);
	}

	public void cadastraraAlunoAula(AlunoAulaForm alunoAulaForm) {
		AlunoAula alunoAula = new AlunoAula();
		alunoAula.setDisponivel(alunoAulaForm.getDisponivel());
		alunoAula.setDataAquisicao(Timestamp.from(Instant.now()));
		alunoAula.setAula(this.aulaService.buscarAulaPorId(alunoAulaForm.getIdAula()));
		alunoAula.setAluno(this.alunoService.buscarAlunoPorId(alunoAulaForm.getIdAluno()));
		this.alunoAulaRepository.save(alunoAula);
	}

	public AlunoAula atualizarAlunoAula(Long idAlunoAula, AlunoAulaForm alunoAulaForm) {
		AlunoAula alunoAula = this.buscarAlunoAulaPorId(idAlunoAula);
		alunoAula.setDisponivel(alunoAulaForm.getDisponivel());
		alunoAula.setAula(this.aulaService.buscarAulaPorId(alunoAulaForm.getIdAula()));
		alunoAula.setAluno(this.alunoService.buscarAlunoPorId(alunoAulaForm.getIdAluno()));
		return this.alunoAulaRepository.save(alunoAula);
	}

	public void alternarDisponibilidade(Long idAlunoAula) {
		AlunoAula alunoAula = this.buscarAlunoAulaPorId(idAlunoAula);
		alunoAula.setDisponivel(!alunoAula.getDisponivel());
		this.alunoAulaRepository.save(alunoAula);
	}

}
