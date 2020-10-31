package com.jvst.api.instrutor.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jvst.api.instrutor.model.Instrutor;
import com.jvst.api.usuario.model.Usuario;

public interface InstrutorRepository extends JpaRepository<Instrutor, Long> {

	public Instrutor findByUsuario(Usuario usuario);
}
