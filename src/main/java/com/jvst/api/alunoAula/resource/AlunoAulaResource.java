package com.jvst.api.alunoAula.resource;

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

import com.jvst.api.alunoAula.form.AlunoAulaForm;
import com.jvst.api.alunoAula.model.AlunoAula;
import com.jvst.api.alunoAula.service.AlunoAulaService;
import com.jvst.api.util.Doc;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(value = "Aulas do Aluno", tags = { "Aulas do Aluno" })
@RestController
@RequestMapping("/aluno-aula")
public class AlunoAulaResource {

	@Autowired
	private AlunoAulaService alunoAulaService;

	@ApiOperation(value = Doc.LISTAR_PREFIX + "aluno-aula" + Doc.LISTAR_SUFFIX + "aluno")
	@GetMapping("/aluno/{idAluno}")
	public List<AlunoAula> listarAlunoAulaPorIdAluno(@PathVariable @ApiParam(value = Doc.PARAM_ID_PREFIX
			+ "de aluno da relação aluno-aula" + Doc.PARAM_ID_SUFFIX1, example = "1") Long idAluno) {
		return this.alunoAulaService.listarAlunoAulaPorIdAluno(idAluno);
	}

	@ApiOperation(value = Doc.LISTAR_PREFIX + "aluno-aula" + Doc.LISTAR_SUFFIX + "aula")
	@GetMapping("/aula/{idAula}")
	public List<AlunoAula> listarAlunoAulaPorIdAula(@PathVariable @ApiParam(value = Doc.PARAM_ID_PREFIX
			+ "de aula da relação aluno-aula" + Doc.PARAM_ID_SUFFIX1, example = "1") Long idAula) {
		return this.alunoAulaService.listarAlunoAulaPorIdAula(idAula);
	}

	@ApiOperation(value = Doc.CADASTRAR_PREFIX + "uma nova relação aluno-aula" + Doc.CADASTRAR_SUFFIX)
	@PostMapping
	public void cadastrarAlunoAula(@RequestBody @Valid @ApiParam(value = Doc.PARAM_ENTIDADE_PREFIX + "aluno-aula"
			+ Doc.PARAM_ENTIDADE_SUFFIX1) AlunoAulaForm alunoAulaForm) {
		this.alunoAulaService.cadastraraAlunoAula(alunoAulaForm);
	}

	@ApiOperation(value = Doc.ATUALIZAR_PREFIX + "uma relação aluno-aula" + Doc.ATUALIZAR_SUFFIX)
	@PutMapping("/{idAlunoAula}")
	public void atualizarAlunoAula(
			@PathVariable @ApiParam(value = Doc.PARAM_ID_PREFIX + "da relação aluno-aula"
					+ Doc.PARAM_ID_SUFFIX2, example = "1") Long idAlunoAula,
			@RequestBody @Valid @ApiParam(value = Doc.PARAM_ENTIDADE_PREFIX + "aluno-aula"
					+ Doc.PARAM_ENTIDADE_SUFFIX1) AlunoAulaForm alunoAulaForm) {
		this.alunoAulaService.cadastraraAlunoAula(alunoAulaForm);
	}

	@ApiOperation(value = "Alterna para disponível/indisponível o status da aula para o aluno")
	@PutMapping("/{idAlunoAula")
	public void alternarDisponibilidade(@PathVariable @ApiParam(value = Doc.PARAM_ID_PREFIX + "da relação aluno-aula"
			+ Doc.PARAM_ID_SUFFIX2, example = "1") Long idAlunoAula) {
		this.alunoAulaService.alternarDisponibiliade(idAlunoAula);
	}

}
