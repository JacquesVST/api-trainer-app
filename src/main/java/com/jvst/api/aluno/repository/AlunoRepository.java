package com.jvst.api.aluno.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jvst.api.aluno.model.Aluno;
import com.jvst.api.usuario.model.Usuario;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {
	
	public Aluno findByUsuario(Usuario usuario);
}
