package com.jvst.api.alunoAula.form;

import javax.validation.constraints.NotNull;

import com.jvst.api.util.Doc;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "AlunoAulaForm", description = Doc.FORM_DESC + "das aulas do aluno")
public class AlunoAulaForm {

	@ApiModelProperty(value = "Aluno")
	@NotNull(message = "aluno não pode ser nulo")
	private Long idAluno;

	@ApiModelProperty(value = "Aula")
	@NotNull(message = "aula não pode ser nulo")
	private Long idAula;

	@ApiModelProperty(value = "Controla se o aluno tem acesso a aula", example = "false")
	private Boolean disponivel;

	@ApiModelProperty(value = "Data e hora de cadastro da relação", example = "31/12/2019")
	@NotNull(message = "data aquisicao não pode ser nulo")
	private String dataAquisicao;

	public Long getIdAluno() {
		return idAluno;
	}

	public void setIdAluno(Long idAluno) {
		this.idAluno = idAluno;
	}

	public Long getIdAula() {
		return idAula;
	}

	public void setIdAula(Long idAula) {
		this.idAula = idAula;
	}

	public Boolean getDisponivel() {
		return disponivel;
	}

	public void setDisponivel(Boolean disponivel) {
		this.disponivel = disponivel;
	}

	public String getDataAquisicao() {
		return dataAquisicao;
	}

	public void setDataAquisicao(String dataAquisicao) {
		this.dataAquisicao = dataAquisicao;
	}

}
