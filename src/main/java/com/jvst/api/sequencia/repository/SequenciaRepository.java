package com.jvst.api.sequencia.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jvst.api.aula.model.Aula;
import com.jvst.api.sequencia.model.Sequencia;

public interface SequenciaRepository extends JpaRepository<Sequencia, Long>{
	
	public List<Sequencia> findByAula(Aula aula);
}
