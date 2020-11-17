package com.jvst.api.mensagem.service;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.jvst.api.chat.model.Chat;
import com.jvst.api.chat.service.ChatService;
import com.jvst.api.mensagem.form.MensagemForm;
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

	public Mensagem cadastrarMensagem(MensagemForm mensagemForm) {
		Mensagem mensagem = new Mensagem();
		mensagem.setChat(this.chatService.buscarChatPorId(mensagemForm.getIdChat()));
		mensagem.setUsuario(this.usuarioService.buscarUsuarioPorId(mensagemForm.getIdUsuario()));
		mensagem.setConteudo(mensagemForm.getConteudo());
		mensagem.setEnvio(Timestamp.from(Instant.now()));
		mensagem.setVisualizado(null);
		return this.mensagemRepository.save(mensagem);
	}

	public Mensagem alterarVisualizacao(Long idMensagem) {
		Mensagem mensagem = this.buscarMensagemPorId(idMensagem);
		mensagem.setVisualizado(
				mensagem.getVisualizado().equals(null) ? Timestamp.from(Instant.now()) : mensagem.getVisualizado());
		return this.mensagemRepository.save(mensagem);
	}
}
