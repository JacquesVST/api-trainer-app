package com.jvst.api.alunoAula.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jvst.api.aluno.model.Aluno;
import com.jvst.api.alunoAula.model.AlunoAula;
import com.jvst.api.aula.model.Aula;

public interface AlunoAulaRepository extends JpaRepository<AlunoAula, Long> {

	List<AlunoAula> findByAluno(Aluno aluno);
	
	List<AlunoAula> findByAula(Aula aula);
}
