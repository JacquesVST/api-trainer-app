package com.jvst.api.atividade.resource;

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

import com.jvst.api.atividade.form.AtividadeForm;
import com.jvst.api.atividade.model.Atividade;
import com.jvst.api.atividade.service.AtividadeService;
import com.jvst.api.util.Doc;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(value = "Atividade", tags = { "Atividade" })
@RestController
@RequestMapping("/atividade")
public class AtividadeResource {

	@Autowired
	private AtividadeService atividadeService;

	@ApiOperation(value = Doc.BUSCAR_PREFIX + "a atividade" + Doc.BUSCAR_SUFFIX)
	@GetMapping("/{idAtividade}")
	public Atividade buscarAtividadePorId(@PathVariable @ApiParam(value = Doc.PARAM_ID_PREFIX + "da atividade"
			+ Doc.PARAM_ID_SUFFIX1, example = "1") Long idAtividade) {
		return this.atividadeService.buscarAtividadePorId(idAtividade);
	}

	@ApiOperation(value = Doc.LISTAR_PREFIX + "atividades" + Doc.LISTAR_SUFFIX + "instrutor")
	@GetMapping("/instrutor/{idInstrutor}")
	public List<Atividade> listarAtividadePorInstrutor(@PathVariable @ApiParam(value = Doc.PARAM_ID_PREFIX
			+ "de instrutor da atividade" + Doc.PARAM_ID_SUFFIX1, example = "1") Long idInstrutor) {
		return this.atividadeService.listarAtividadePorIdInstrutor(idInstrutor);
	}

	@ApiOperation(value = Doc.CADASTRAR_PREFIX + "uma nova atividade" + Doc.CADASTRAR_SUFFIX)
	@PostMapping
	public void cadastrarAtividade(@RequestBody @Valid @ApiParam(value = Doc.PARAM_ENTIDADE_PREFIX + "atividade"
			+ Doc.PARAM_ENTIDADE_SUFFIX1) AtividadeForm atividadeForm) {
		this.atividadeService.cadastrarAtividade(atividadeForm);
	}

	@ApiOperation(value = Doc.ATUALIZAR_PREFIX + "uma atividade" + Doc.ATUALIZAR_SUFFIX)
	@PutMapping("/{idAtividade}")
	public void atualizarAtividade(
			@PathVariable @ApiParam(value = Doc.PARAM_ID_PREFIX + "da atividade"
					+ Doc.PARAM_ID_SUFFIX2, example = "1") Long idAtividade,
			@RequestBody @Valid @ApiParam(value = Doc.PARAM_ENTIDADE_PREFIX + "atividade"
					+ Doc.PARAM_ENTIDADE_SUFFIX2) AtividadeForm atividadeForm) {
		this.atividadeService.atualizarAtividade(idAtividade, atividadeForm);
	}

}
