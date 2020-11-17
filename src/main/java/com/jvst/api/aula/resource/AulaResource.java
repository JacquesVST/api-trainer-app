package com.jvst.api.aula.resource;

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

import com.jvst.api.aula.form.AulaForm;
import com.jvst.api.aula.model.Aula;
import com.jvst.api.aula.service.AulaService;
import com.jvst.api.util.Doc;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(value = "Aula", tags = { "Aula" })
@RestController
@RequestMapping("/aula")
public class AulaResource {

	@Autowired
	private AulaService aulaService;

	@ApiOperation(value = Doc.BUSCAR_PREFIX + "a aula" + Doc.BUSCAR_SUFFIX)
	@GetMapping("/{idAula}")
	public Aula buscarAulaPorId(@PathVariable @ApiParam(value = Doc.PARAM_ID_PREFIX + "da aula"
			+ Doc.PARAM_ID_SUFFIX1, example = "1") Long idAula) {
		return this.aulaService.buscarAulaPorId(idAula);
	}

	@ApiOperation(value = Doc.LISTAR_PREFIX + "aulas" + Doc.LISTAR_SUFFIX + "instrutor")
	@GetMapping("/instrutor/{idInstrutor}")
	public List<Aula> listarAulaPorIdInstrutor(@PathVariable @ApiParam(value = Doc.PARAM_ID_PREFIX
			+ "de instrutor da aula" + Doc.PARAM_ID_SUFFIX1, example = "1") Long idInstrutor) {
		return this.aulaService.listarAulaPorIdInstrutor(idInstrutor);
	}

	@ApiOperation(value = Doc.CADASTRAR_PREFIX + "uma nova aula" + Doc.CADASTRAR_SUFFIX)
	@PostMapping
	public void cadastrarAula(@RequestBody @Valid @ApiParam(value = Doc.PARAM_ENTIDADE_PREFIX + "aula"
			+ Doc.PARAM_ENTIDADE_SUFFIX1) AulaForm aulaForm) {
		this.aulaService.cadastrarAula(aulaForm);
	}

	@ApiOperation(value = Doc.ATUALIZAR_PREFIX + "uma nova aula" + Doc.ATUALIZAR_SUFFIX)
	@PutMapping("/{idAula}")
	public void atualizarAula(
			@PathVariable @ApiParam(value = Doc.PARAM_ID_PREFIX + "da aula"
					+ Doc.PARAM_ID_SUFFIX2, example = "1") Long idAula,
			@RequestBody @Valid @ApiParam(value = Doc.PARAM_ENTIDADE_PREFIX + "aula"
					+ Doc.PARAM_ENTIDADE_SUFFIX1) AulaForm aulaForm) {
		this.aulaService.atualizarAula(idAula, aulaForm);
	}

	@ApiOperation(value = "Altera o acesso da aula para público ou privado")
	@PutMapping("/acesso/{idAula}")
	public void alterarAcessoAula(@PathVariable @ApiParam(value = Doc.PARAM_ID_PREFIX + "da aula"
			+ Doc.PARAM_ID_SUFFIX2, example = "1") Long idAula) {
		this.aulaService.alterarAcessoAula(idAula);
	}

}
