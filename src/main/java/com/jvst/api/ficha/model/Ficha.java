package com.jvst.api.ficha.model;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.jvst.api.aluno.model.Aluno;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel(value = "Ficha", description = "Modelo da ficha que o aluno preencherá para análise do instrutor")
@Data
@Entity
@Table(name = "ficha")
public class Ficha {

	@ApiModelProperty(value = "ID da ficha", example = "1")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ApiModelProperty(value = "Aluno que preencheu a ficha")
	@NotNull(message = "aluno não pode ser nulo")
	@ManyToOne(targetEntity = Aluno.class)
	@JoinColumn(name = "id_aluno")
	private Aluno aluno;

	@ApiModelProperty(value = "Data e hora de submissão da ficha", example = "2020-10-10T20:09:54.919+00:00")
	private Timestamp data;

	@ApiModelProperty(value = "Campo que guardará todas as informações que o instrutor solicitar na ficha", example = "Peso, Cintura, Altura...")
	private String detalhes;

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

	public Timestamp getData() {
		return data;
	}

	public void setData(Timestamp data) {
		this.data = data;
	}

	public String getDetalhes() {
		return detalhes;
	}

	public void setDetalhes(String detalhes) {
		this.detalhes = detalhes;
	}

}
