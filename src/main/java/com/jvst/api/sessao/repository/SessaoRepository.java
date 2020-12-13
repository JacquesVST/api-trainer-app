package com.jvst.api.sessao.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jvst.api.aluno.model.Aluno;
import com.jvst.api.aula.model.Aula;
import com.jvst.api.sessao.model.Sessao;

public interface SessaoRepository extends JpaRepository<Sessao, Long>{

	List<Sessao> findByAluno(Aluno aluno);
	
	List<Sessao> findByAula(Aula aula);
}
