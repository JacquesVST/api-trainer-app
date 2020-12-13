package com.jvst.api.chat.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.jvst.api.aluno.model.Aluno;
import com.jvst.api.instrutor.model.Instrutor;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel(value = "Chat", description = "Modelo do chat para comunicação de instrutores e alunos")
@Data
@Entity
@Table(name = "chat")
public class Chat {

	@ApiModelProperty(value = "ID do chat", example = "1")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ApiModelProperty(value = "ID do instrutor do chat")
	@NotNull(message = "instrutor não pode ser nulo")
	@ManyToOne(targetEntity = Instrutor.class)
	@JoinColumn(name = "id_instrutor")
	private Instrutor instrutor;

	@ApiModelProperty(value = "ID do aluno do chat")
	@NotNull(message = "aluno não pode ser nulo")
	@ManyToOne(targetEntity = Aluno.class)
	@JoinColumn(name = "id_aluno")
	private Aluno aluno;

	@ApiModelProperty(value = "Data e hora de início do chat", example = "2020-10-20T20:00:54.919+00:00")
	private Timestamp inicio;

	@ApiModelProperty(value = "Controla se o chat está visível para o instrutor", example = "True")
	@Column(name = "exclusao_instrutor")
	private Boolean exclusaoInstrutor;

	@ApiModelProperty(value = "Controla se o chat está visível para o aluno", example = "True")
	@Column(name = "exclusao_aluno")
	private Boolean exclusaoAluno;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Instrutor getInstrutor() {
		return instrutor;
	}

	public void setInstrutor(Instrutor instrutor) {
		this.instrutor = instrutor;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public Timestamp getInicio() {
		return inicio;
	}

	public void setInicio(Timestamp inicio) {
		this.inicio = inicio;
	}

	public Boolean getExclusaoInstrutor() {
		return exclusaoInstrutor;
	}

	public void setExclusaoInstrutor(Boolean exclusaoInstrutor) {
		this.exclusaoInstrutor = exclusaoInstrutor;
	}

	public Boolean getExclusaoAluno() {
		return exclusaoAluno;
	}

	public void setExclusaoAluno(Boolean exclusaoAluno) {
		this.exclusaoAluno = exclusaoAluno;
	}

}