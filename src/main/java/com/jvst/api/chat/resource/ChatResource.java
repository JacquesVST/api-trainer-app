package com.jvst.api.chat.resource;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jvst.api.chat.model.Chat;
import com.jvst.api.chat.service.ChatService;
import com.jvst.api.util.Doc;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(value = "Chat", tags = { "Chat" })
@RestController
@RequestMapping("/chat")
public class ChatResource {

	@Autowired
	private ChatService chatService;

	@ApiOperation(value = Doc.BUSCAR_PREFIX + "o chat" + Doc.BUSCAR_SUFFIX)
	@GetMapping("/{idChat}")
	public Chat bsucarChatPorId(
			@PathVariable @ApiParam(value = Doc.PARAM_ID_PREFIX + "do chat"
					+ Doc.PARAM_ID_SUFFIX1, example = "1") Long idChat) {
		return this.chatService.buscarChatPorId(idChat);
	}

	@ApiOperation(value = Doc.LISTAR_PREFIX + "chats" + Doc.LISTAR_SUFFIX + "instrutor")
	@GetMapping("/instrutor/{idInstrutor}")
	public List<Chat> listarChatPorIdInstrutor(
			@PathVariable @ApiParam(value = Doc.PARAM_ID_PREFIX
					+ "de instrutor do chat" + Doc.PARAM_ID_SUFFIX1, example = "1") Long idInstrutor) {
		return this.chatService.listarChatPorIdInstrutor(idInstrutor);
	}

	@ApiOperation(value = Doc.LISTAR_PREFIX + "chats" + Doc.LISTAR_SUFFIX + "aluno")
	@GetMapping("/aluno/{idAluno}")
	public List<Chat> listarChatPorIdAluno(
			@PathVariable @ApiParam(value = Doc.PARAM_ID_PREFIX
					+ "de aluno do chat" + Doc.PARAM_ID_SUFFIX1, example = "1") Long idAluno) {
		return this.chatService.listarChatPorIdAluno(idAluno);
	}

	@ApiOperation(value = Doc.CADASTRAR_PREFIX + "um novo chat" + Doc.CADASTRAR_SUFFIX)
	@PostMapping
	public void cadastrarChat(@RequestBody @Valid @ApiParam(value = Doc.PARAM_ENTIDADE_PREFIX + "chat"
			+ Doc.PARAM_ENTIDADE_SUFFIX1) Chat chat) {
		this.chatService.salvarChat(chat);
	}
}
