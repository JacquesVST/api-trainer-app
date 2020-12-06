package com.jvst.api.mensagem.resource;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jvst.api.mensagem.form.MensagemForm;
import com.jvst.api.mensagem.model.Mensagem;
import com.jvst.api.mensagem.service.MensagemService;
import com.jvst.api.util.Doc;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(value = "Mensagem", tags = { "Mensagem" })
@RestController
@RequestMapping("/mensagem")
public class MensagemResource {

	@Autowired
	private MensagemService mensagemService;

	@ApiOperation(value = Doc.BUSCAR_PREFIX + "a mensagem" + Doc.BUSCAR_SUFFIX)
	@GetMapping("/{idMensagem}")
	public Mensagem buscarMensagemPorId(@PathVariable @ApiParam(value = Doc.PARAM_ID_PREFIX + "da mensagem"
			+ Doc.PARAM_ID_SUFFIX1, example = "1") Long idMensagem) {
		return this.mensagemService.buscarMensagemPorId(idMensagem);
	}

	@ApiOperation(value = Doc.LISTAR_PREFIX + "mensagens" + Doc.LISTAR_SUFFIX + "chat")
	@GetMapping("/chat/{idChat}")
	public List<Mensagem> listarMensagemPorIdChat(@PathVariable @ApiParam(value = Doc.PARAM_ID_PREFIX
			+ "de chat da mensagem" + Doc.PARAM_ID_SUFFIX1, example = "1") Long idChat) {
		return this.mensagemService.listarMensagemPorIdChat(idChat);
	}

	@ApiOperation(value = Doc.LISTAR_PREFIX + "mensagens" + Doc.LISTAR_SUFFIX + "usuário")
	@GetMapping("/usuario/{idUsuario}")
	public List<Mensagem> listarMensagemPorIdUsuario(@PathVariable @ApiParam(value = Doc.PARAM_ID_PREFIX
			+ "de usuário da mensagem" + Doc.PARAM_ID_SUFFIX1, example = "1") Long idUsuario) {
		return this.mensagemService.listarMensagemPorIdUsuario(idUsuario);
	}

	@ApiOperation(value = Doc.CADASTRAR_PREFIX + "uma nova mensagem" + Doc.CADASTRAR_SUFFIX)
	@PostMapping
	public void cadastrarMensagem(@RequestBody @Valid @ApiParam(value = Doc.PARAM_ENTIDADE_PREFIX + "mensagem"
			+ Doc.PARAM_ENTIDADE_SUFFIX1) MensagemForm mensagemForm) {
		this.mensagemService.cadastrarMensagem(mensagemForm);
	}

	@ApiOperation(value = "Altera o status de visualização")
	@PutMapping("/{idMensagem}")
	public void alterarVisualizacao(@PathVariable @ApiParam(value = Doc.PARAM_ID_PREFIX + "da mensagem"
			+ Doc.PARAM_ID_SUFFIX2, example = "1") Long idMensagem) {
		this.mensagemService.alterarVisualizacao(idMensagem);
	}

}
