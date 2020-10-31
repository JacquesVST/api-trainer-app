package com.jvst.api.mensagem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jvst.api.chat.model.Chat;
import com.jvst.api.mensagem.model.Mensagem;
import com.jvst.api.usuario.model.Usuario;

public interface MensagemRepository extends JpaRepository<Mensagem, Long>{

	public List<Mensagem> findByChat(Chat chat);
	
	public List<Mensagem> findByUsuario(Usuario usuario);
}
