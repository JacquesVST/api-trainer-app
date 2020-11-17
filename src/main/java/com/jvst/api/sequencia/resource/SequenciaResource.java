package com.jvst.api.sequencia.resource;

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

import com.jvst.api.sequencia.form.SequenciaForm;
import com.jvst.api.sequencia.model.Sequencia;
import com.jvst.api.sequencia.service.SequenciaService;
import com.jvst.api.util.Doc;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(value = "Sequência", tags = { "Sequência" })
@RestController
@RequestMapping("/sequencia")
public class SequenciaResource {

	@Autowired
	private SequenciaService sequenciaService;

	@ApiOperation(value = Doc.BUSCAR_PREFIX + "a sequência" + Doc.BUSCAR_SUFFIX)
	@GetMapping("/{idSequencia}")
	public Sequencia buscarSequenciaPorId(@PathVariable @ApiParam(value = Doc.PARAM_ID_PREFIX + "da sequência"
			+ Doc.PARAM_ID_SUFFIX1, example = "1") Long idSequencia) {
		return this.sequenciaService.buscarSequenciaPorId(idSequencia);
	}

	@ApiOperation(value = Doc.LISTAR_PREFIX + "sequências" + Doc.LISTAR_SUFFIX + "aula")
	@GetMapping("/aula/{idAula}")
	public List<Sequencia> listarSequenciaPorIdAula(@PathVariable @ApiParam(value = Doc.PARAM_ID_PREFIX
			+ "de aula da sequência" + Doc.PARAM_ID_SUFFIX1, example = "1") Long idAula) {
		return this.sequenciaService.listarSequenciaPorIdAula(idAula);
	}

	@ApiOperation(value = Doc.CADASTRAR_PREFIX + "uma nova sequencia" + Doc.CADASTRAR_SUFFIX)
	@PostMapping
	public void cadastrarSequencia(@RequestBody @Valid @ApiParam(value = Doc.PARAM_ENTIDADE_PREFIX + "sequencia"
			+ Doc.PARAM_ENTIDADE_SUFFIX1) SequenciaForm sequenciaForm) {
		this.sequenciaService.cadastrarSequencia(sequenciaForm);
	}

	@ApiOperation(value = Doc.CADASTRAR_PREFIX + "uma nova sequencia" + Doc.CADASTRAR_SUFFIX)
	@PutMapping("/{idSequencia}")
	public void atualizarSequencia(
			@PathVariable @ApiParam(value = Doc.PARAM_ID_PREFIX + "da sequencia"
					+ Doc.PARAM_ID_SUFFIX2, example = "1") Long idSequencia,
			@RequestBody @Valid @ApiParam(value = Doc.PARAM_ENTIDADE_PREFIX + "sequencia"
					+ Doc.PARAM_ENTIDADE_SUFFIX1) SequenciaForm sequenciaForm) {
		this.sequenciaService.atualizarSequencia(idSequencia, sequenciaForm);
	}
}
