package com.jvst.api.avaliacao.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jvst.api.aluno.model.Aluno;
import com.jvst.api.aula.model.Aula;
import com.jvst.api.avaliacao.model.Avaliacao;

public interface AvaliacaoRepository extends JpaRepository<Avaliacao, Long>{

	public List<Avaliacao> findByAula(Aula aula);
	
	public List<Avaliacao> findByAluno(Aluno aluno);
}
