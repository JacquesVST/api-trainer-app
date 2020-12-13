package com.jvst.api.ficha.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jvst.api.aluno.model.Aluno;
import com.jvst.api.ficha.model.Ficha;

public interface FichaRepository extends JpaRepository<Ficha, Long> {
	List<Ficha> findByAluno(Aluno aluno);
}
