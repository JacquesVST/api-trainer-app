package com.jvst.api.ficha.resource;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jvst.api.ficha.form.FichaForm;
import com.jvst.api.ficha.model.Ficha;
import com.jvst.api.ficha.service.FichaService;
import com.jvst.api.util.Doc;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(value = "Ficha", tags = { "Ficha" })
@RestController
@RequestMapping("/ficha")
public class FichaResource {

	@Autowired
	private FichaService fichaService;

	@ApiOperation(value = Doc.BUSCAR_PREFIX + "a ficha" + Doc.BUSCAR_SUFFIX)
	@GetMapping("/{idFicha}")
	public Ficha buscarFichaPorId(@PathVariable @ApiParam(value = Doc.PARAM_ID_PREFIX + "da ficha"
			+ Doc.PARAM_ID_SUFFIX1, example = "1") Long idFicha) {
		return this.fichaService.buscarFichaPorId(idFicha);
	}

	@ApiOperation(value = Doc.LISTAR_PREFIX + "fichas" + Doc.LISTAR_SUFFIX + "aluno")
	@GetMapping("/aluno/{idAluno}")
	public List<Ficha> listarFichaPorIdAluno(@PathVariable @ApiParam(value = Doc.PARAM_ID_PREFIX + "de aluno da ficha"
			+ Doc.PARAM_ID_SUFFIX1, example = "1") Long idAluno) {
		return this.fichaService.listarFichaPorIdAluno(idAluno);
	}

	@ApiOperation(value = Doc.CADASTRAR_PREFIX + "uma nova ficha" + Doc.CADASTRAR_SUFFIX)
	@PostMapping
	public void cadastrarFicha(@RequestBody @Valid @ApiParam(value = Doc.PARAM_ENTIDADE_PREFIX + "ficha"
			+ Doc.PARAM_ENTIDADE_SUFFIX1) FichaForm fichaForm) {
		this.fichaService.cadastrarFicha(fichaForm);
	}
}
