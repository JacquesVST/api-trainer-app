package com.jvst.api.avaliacao.resource;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jvst.api.avaliacao.model.Avaliacao;
import com.jvst.api.avaliacao.service.AvaliacaoService;
import com.jvst.api.util.Doc;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(value = "Avaliação", tags = { "Avaliação" })
@RestController
@RequestMapping("/avaliacao")
public class AvaliacaoResource {

	@Autowired
	private AvaliacaoService avaliacaoService;
	
	@ApiOperation(value = Doc.BUSCAR_PREFIX + "a avaliação" + Doc.BUSCAR_SUFFIX)
	@GetMapping("/{idAvaliacao}")
	public Avaliacao buscarAvaliacaoPorId(@PathVariable @ApiParam(value = Doc.PARAM_ID_PREFIX + "da avaliação"
			+ Doc.PARAM_ID_SUFFIX1, example = "1") Long idAvaliacao) {
		return this.avaliacaoService.buscarAvaliacaPorId(idAvaliacao);
	}
	
	@ApiOperation(value = Doc.LISTAR_PREFIX + "avaliações" + Doc.LISTAR_SUFFIX + "aluno")
	@GetMapping("/aluno/{idAluno}")
	public List<Avaliacao> listarAvaliacaoPorIdAluno(@PathVariable @ApiParam(value = Doc.PARAM_ID_PREFIX
			+ "de aluno da avaliação" + Doc.PARAM_ID_SUFFIX1, example = "1") Long idAluno){
		return this.avaliacaoService.listarAvaliacaoPorIdAluno(idAluno);
	}
	
	@ApiOperation(value = Doc.LISTAR_PREFIX + "avaliações" + Doc.LISTAR_SUFFIX + "aula")
	@GetMapping("/aula/{idAula}")
	public List<Avaliacao> listarAvaliacaoPorIdAula(@PathVariable @ApiParam(value = Doc.PARAM_ID_PREFIX
			+ "de aula da avaliação" + Doc.PARAM_ID_SUFFIX1, example = "1") Long idAula){
		return this.avaliacaoService.listarAvaliacaoPorIdAula(idAula);
	}
	
	@ApiOperation(value = Doc.CADASTRAR_PREFIX + "uma nova avaliação" + Doc.CADASTRAR_SUFFIX)
	@PostMapping
	public void cadastrarAvaliacao(@RequestBody @Valid @ApiParam(value = Doc.PARAM_ENTIDADE_PREFIX + "avaliação"
			+ Doc.PARAM_ENTIDADE_SUFFIX1) Avaliacao avaliacao) {
		this.avaliacaoService.salvarAvaliacao(avaliacao);
	}
}
