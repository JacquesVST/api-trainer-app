package com.jvst.api.sessao.resource;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jvst.api.sessao.model.Sessao;
import com.jvst.api.sessao.service.SessaoService;
import com.jvst.api.util.Doc;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(value = "Sessão", tags = { "Sessão" })
@RestController
@RequestMapping("/sessao")
public class SessaoResource {
	
	@Autowired
	private SessaoService sessaoService;
	
	@ApiOperation(value = Doc.BUSCAR_PREFIX + "a sessão" + Doc.BUSCAR_SUFFIX)
	@GetMapping("/{idSessao")
	public Sessao buscarSessaoPorId(@PathVariable @ApiParam(value = Doc.PARAM_ID_PREFIX + "da sessão"
			+ Doc.PARAM_ID_SUFFIX1, example = "1") Long idSessao) {
		return this.buscarSessaoPorId(idSessao);
	}
	
	@ApiOperation(value = Doc.LISTAR_PREFIX + "sessões" + Doc.LISTAR_SUFFIX + "aluno")
	@GetMapping("/aluno/{idAluno}")
	public List<Sessao> listarSessaoPorIdAluno(@PathVariable @ApiParam(value = Doc.PARAM_ID_PREFIX
			+ "de aluno da sessão" + Doc.PARAM_ID_SUFFIX1, example = "1") Long idAluno) {
		return this.sessaoService.listarSessaoPorIdAluno(idAluno);
	}
	
	@ApiOperation(value = Doc.LISTAR_PREFIX + "sessões" + Doc.LISTAR_SUFFIX + "aula")
	@GetMapping("/aula/{idAula}")
	public List<Sessao> listarSessaoPorIdAula(@PathVariable @ApiParam(value = Doc.PARAM_ID_PREFIX
			+ "de aula da sessão" + Doc.PARAM_ID_SUFFIX1, example = "1") Long idAula) {
		return this.sessaoService.listarSessaoPorIdAula(idAula);
	}
	
	@ApiOperation(value = Doc.CADASTRAR_PREFIX + "uma nova sessão" + Doc.CADASTRAR_SUFFIX)
	@PostMapping
	public void cadastrarSessao(@RequestBody @Valid @ApiParam(value = Doc.PARAM_ENTIDADE_PREFIX + "sessão"
			+ Doc.PARAM_ENTIDADE_SUFFIX1) Sessao sessao) {
		this.sessaoService.salvarSessao(sessao);
	}
}
