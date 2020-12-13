package com.jvst.api.aula.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jvst.api.aula.model.Aula;
import com.jvst.api.instrutor.model.Instrutor;

public interface AulaRepository extends JpaRepository<Aula, Long>{

	List<Aula> findByInstrutor(Instrutor instrutor);
}
