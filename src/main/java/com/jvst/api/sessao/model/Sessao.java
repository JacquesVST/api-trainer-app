package com.jvst.api.sessao.model;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.jvst.api.aluno.model.Aluno;
import com.jvst.api.aula.model.Aula;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel(value = "Sessão", description = "Modelo da sessão que será usada para armazenar aulas praticadas pelo aluno")
@Data
@Entity
@Table(name = "sessao")
public class Sessao {

	@ApiModelProperty(value = "ID da sessão", example = "1")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ApiModelProperty(value = "Aluno que praticou a sessão")
	@NotNull(message = "aluno não pode ser nulo")
	@ManyToOne(targetEntity = Aluno.class)
	@JoinColumn(name = "id_aluno")
	private Aluno aluno;

	@ApiModelProperty(value = "Aula praticada pelo aluno")
	@NotNull(message = "aula não pode ser nulo")
	@ManyToOne(targetEntity = Aula.class)
	@JoinColumn(name = "id_aula")
	private Aula aula;

	@ApiModelProperty(value = "Data e hora de inicio da aula", example = "2020-10-10T10:09:54.919+00:00")
	private Timestamp inicio;

	@ApiModelProperty(value = "Data e hora de término da aula", example = "2020-10-10T11:09:54.919+00:00")
	private Timestamp fim;

	@ApiModelProperty(value = "Observações da sessão feita pelo aluno", example = "1")
	@NotNull(message = "observacoes não pode ser nulo")
	@Size(max = 300, message = "limite de caracteres para observacoes excedido")
	private String observacoes;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public Aula getAula() {
		return aula;
	}

	public void setAula(Aula aula) {
		this.aula = aula;
	}

	public Timestamp getInicio() {
		return inicio;
	}

	public void setInicio(Timestamp inicio) {
		this.inicio = inicio;
	}

	public Timestamp getFim() {
		return fim;
	}

	public void setFim(Timestamp fim) {
		this.fim = fim;
	}

	public String getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}

}
