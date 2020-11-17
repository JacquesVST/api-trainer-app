package com.jvst.api.aluno.resource;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jvst.api.aluno.form.AlunoForm;
import com.jvst.api.aluno.model.Aluno;
import com.jvst.api.aluno.service.AlunoService;
import com.jvst.api.util.Doc;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(value = "Aluno", tags = { "Aluno" })
@RestController
@RequestMapping("/aluno")
public class AlunoResource {

	@Autowired
	private AlunoService alunoService;

	@ApiOperation(value = Doc.BUSCAR_PREFIX + "o aluno" + Doc.BUSCAR_SUFFIX)
	@GetMapping("/{idAluno}")
	public Aluno buscarAlunoPorId(@PathVariable @ApiParam(value = Doc.PARAM_ID_PREFIX + "do aluno"
			+ Doc.PARAM_ID_SUFFIX1, example = "1") Long idAluno) {
		return this.alunoService.buscarAlunoPorId(idAluno);
	}

	@ApiOperation(value = Doc.BUSCAR_PREFIX + "o aluno" + Doc.LISTAR_SUFFIX + "usuário")
	@GetMapping("/usuario/{idUsuario}")
	public Aluno buscarAlunoPorIdUsuario(@PathVariable @ApiParam(value = Doc.PARAM_ID_PREFIX + "de usuário do aluno"
			+ Doc.PARAM_ID_SUFFIX1, example = "1") Long idUsuario) {
		return this.alunoService.buscarAlunoPorIdUsuario(idUsuario);
	}

	@ApiOperation(value = Doc.CADASTRAR_PREFIX + "um novo aluno" + Doc.CADASTRAR_SUFFIX)
	@PostMapping("/{idUsuario}")
	public void cadastrarAluno(
			@PathVariable @ApiParam(value = "ID de usuário a vincular com o aluno", example = "1") Long idUsuario,
			@RequestBody @Valid @ApiParam(value = Doc.PARAM_ENTIDADE_PREFIX + "aluno"
					+ Doc.PARAM_ENTIDADE_SUFFIX1) AlunoForm alunoForm) {
		this.alunoService.cadastrarAluno(idUsuario, alunoForm);
	}

	@ApiOperation(value = Doc.ATUALIZAR_PREFIX + "um aluno" + Doc.ATUALIZAR_SUFFIX)
	@PutMapping("/{idAluno}")
	public void atualizarAluno(
			@PathVariable @ApiParam(value = Doc.PARAM_ID_PREFIX + "do aluno"
					+ Doc.PARAM_ID_SUFFIX2, example = "1") Long idAluno,
			@RequestBody @Valid @ApiParam(value = Doc.PARAM_ENTIDADE_PREFIX + "aluno"
					+ Doc.PARAM_ENTIDADE_SUFFIX2) AlunoForm alunoForm) {
		this.alunoService.atualizarAluno(idAluno, alunoForm);
	}
	
}
