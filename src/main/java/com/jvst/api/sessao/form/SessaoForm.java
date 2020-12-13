package com.jvst.api.sessao.form;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.jvst.api.util.Doc;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "SessaoForm", description = Doc.FORM_DESC + "da sessao")
public class SessaoForm {

	@ApiModelProperty(value = "Aluno que praticou a sessão")
	@NotNull(message = "aluno não pode ser nulo")
	private Long idAluno;

	@ApiModelProperty(value = "Aula praticada pelo aluno")
	@NotNull(message = "aula não pode ser nulo")
	private Long idAula;

	@ApiModelProperty(value = "Data e hora de inicio da aula", example = "2020-10-10T10:09:54.919+00:00")
	private String inicio;

	@ApiModelProperty(value = "Data e hora de término da aula", example = "2020-10-10T11:09:54.919+00:00")
	private String fim;

	@ApiModelProperty(value = "Observações da sessão feita pelo aluno", example = "1")
	@NotNull(message = "observacoes não pode ser nulo")
	@Size(max = 300, message = "limite de caracteres para observacoes excedido")
	private String observacoes;

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

	public String getInicio() {
		return inicio;
	}

	public void setInicio(String inicio) {
		this.inicio = inicio;
	}

	public String getFim() {
		return fim;
	}

	public void setFim(String fim) {
		this.fim = fim;
	}

	public String getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}

}
