package com.jvst.api.atividade.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jvst.api.atividade.model.Atividade;
import com.jvst.api.instrutor.model.Instrutor;

public interface AtividadeRepository extends JpaRepository<Atividade, Long>{

	List<Atividade> findByInstrutor(Instrutor instrutor);
}
