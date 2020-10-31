package com.jvst.api.mensagem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.jvst.api.chat.model.Chat;
import com.jvst.api.chat.service.ChatService;
import com.jvst.api.mensagem.model.Mensagem;
import com.jvst.api.mensagem.repository.MensagemRepository;
import com.jvst.api.usuario.model.Usuario;
import com.jvst.api.usuario.service.UsuarioService;

@Service
public class MensagemService {

	@Autowired
	private MensagemRepository mensagemRepository;

	@Autowired
	private ChatService chatService;

	@Autowired
	private UsuarioService usuarioService;

	public Mensagem buscarMensagemPorId(Long idMensagem) {
		Optional<Mensagem> mensagem = this.mensagemRepository.findById(idMensagem);
		if (!mensagem.isPresent()) {
			throw new EmptyResultDataAccessException("Mensagem não encontrada", 1);
		}
		return mensagem.get();
	}

	public List<Mensagem> listarMensagemPorIdChat(Long idChat) {
		Chat chat = this.chatService.buscarChatPorId(idChat);
		return this.mensagemRepository.findByChat(chat);
	}

	public List<Mensagem> listarMensagemPorIdUsuario(Long idUsuario) {
		Usuario usuario = this.usuarioService.buscarUsuarioPorId(idUsuario);
		return this.mensagemRepository.findByUsuario(usuario);
	}

	public void salvarMensagem(Mensagem mensagem) {
		this.mensagemRepository.save(mensagem);
	}
}

