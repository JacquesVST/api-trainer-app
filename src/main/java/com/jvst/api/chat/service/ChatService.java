package com.jvst.api.chat.service;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.jvst.api.aluno.model.Aluno;
import com.jvst.api.aluno.service.AlunoService;
import com.jvst.api.chat.form.ChatForm;
import com.jvst.api.chat.model.Chat;
import com.jvst.api.chat.repository.ChatRepository;
import com.jvst.api.instrutor.model.Instrutor;
import com.jvst.api.instrutor.service.InstrutorService;

@Service
public class ChatService {

	@Autowired
	private ChatRepository chatRepository;

	@Autowired
	private InstrutorService instrutorService;

	@Autowired
	private AlunoService alunoService;

	public Chat buscarChatPorId(Long idChat) {
		Optional<Chat> chat = this.chatRepository.findById(idChat);
		if (!chat.isPresent()) {
			throw new EmptyResultDataAccessException("Chat não encontrado", 1);
		}
		return chat.get();
	}

	public List<Chat> listarChatPorIdInstrutor(Long idInstrutor) {
		Instrutor instrutor = this.instrutorService.buscarInstrutorPorId(idInstrutor);
		return this.chatRepository.findByInstrutor(instrutor);
	}

	public List<Chat> listarChatPorIdAluno(Long idAluno) {
		Aluno aluno = this.alunoService.buscarAlunoPorId(idAluno);
		return this.chatRepository.findByAluno(aluno);
	}

	public Chat cadastrarChat(ChatForm chatForm) {
		Chat chat = new Chat();
		chat.setAluno(alunoService.buscarAlunoPorId(chatForm.getIdAluno()));
		chat.setInstrutor(instrutorService.buscarInstrutorPorId(chatForm.getIdInstrutor()));
		chat.setInicio(Timestamp.from(Instant.now()));
		chat.setExclusaoAluno(false);
		chat.setExclusaoInstrutor(false);
		return this.chatRepository.save(chat);
	}

	public Chat excluirParaAluno(Long idChat) {
		Chat chat = this.buscarChatPorId(idChat);
		chat.setExclusaoAluno(true);
		return this.chatRepository.save(chat);
	}

	public Chat excluirParaInstrutor(Long idChat) {
		Chat chat = this.buscarChatPorId(idChat);
		chat.setExclusaoInstrutor(true);
		return this.chatRepository.save(chat);
	}
}
