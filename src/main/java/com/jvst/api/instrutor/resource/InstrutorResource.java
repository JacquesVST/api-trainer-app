package com.jvst.api.instrutor.resource;

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

import com.jvst.api.instrutor.form.InstrutorForm;
import com.jvst.api.instrutor.model.Instrutor;
import com.jvst.api.instrutor.service.InstrutorService;
import com.jvst.api.util.Doc;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(value = "Instrutor", tags = { "Instrutor" })
@RestController
@RequestMapping("/instrutor")
public class InstrutorResource {

	@Autowired
	private InstrutorService instrutorService;

	@ApiOperation(value = Doc.LISTAR_PREFIX + "todos os instrutores")
	@GetMapping
	public List<Instrutor> listarInstrutores() {
		return this.instrutorService.listarInstrutores();
	}

	@ApiOperation(value = Doc.BUSCAR_PREFIX + "o instrutor" + Doc.BUSCAR_SUFFIX)
	@GetMapping("/{idInstrutor}")
	public Instrutor buscarInstrutorPorId(@PathVariable @ApiParam(value = Doc.PARAM_ID_PREFIX + "do instrutor"
			+ Doc.PARAM_ID_SUFFIX1, example = "1") Long idInstrutor) {
		return this.instrutorService.buscarInstrutorPorId(idInstrutor);
	}

	@ApiOperation(value = Doc.BUSCAR_PREFIX + "o instrutor" + Doc.LISTAR_SUFFIX + "usuário")
	@GetMapping("/usuario/{idUsuario}")
	public Instrutor buscarInstrutorPorIdUsuario(@PathVariable @ApiParam(value = Doc.PARAM_ID_PREFIX
			+ "de usuário do instrutor" + Doc.PARAM_ID_SUFFIX1, example = "1") Long idUsuario) {
		return this.instrutorService.buscarInstrutorPorIdUsuario(idUsuario);
	}

	@ApiOperation(value = Doc.CADASTRAR_PREFIX + "um novo instrutor" + Doc.CADASTRAR_SUFFIX)
	@PostMapping("/{idUsuario}")
	public void cadastrarInstrutor(
			@PathVariable @ApiParam(value = "ID de usuário a vincular com o instrutor", example = "1") Long idUsuario,
			@RequestBody @Valid @ApiParam(value = Doc.PARAM_ENTIDADE_PREFIX + "instrutor"
					+ Doc.PARAM_ENTIDADE_SUFFIX1) InstrutorForm instrutorForm) {
		this.instrutorService.cadastrarInstrutor(idUsuario, instrutorForm);
	}

	@ApiOperation(value = Doc.ATUALIZAR_PREFIX + "um instrutor" + Doc.ATUALIZAR_SUFFIX)
	@PutMapping("/{idInstrutor}")
	public void atualizarInstrutor(
			@PathVariable @ApiParam(value = Doc.PARAM_ID_PREFIX + "do instrutor"
					+ Doc.PARAM_ID_SUFFIX2, example = "1") Long idInstrutor,
			@RequestBody @Valid @ApiParam(value = Doc.PARAM_ENTIDADE_PREFIX + "instrutor"
					+ Doc.PARAM_ENTIDADE_SUFFIX2) InstrutorForm instrutorForm) {
		this.instrutorService.atualizarInstrutor(idInstrutor, instrutorForm);
	}

}
