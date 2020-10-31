package com.jvst.api.alunoAula.model;

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
import com.jvst.api.aula.model.Aula;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel(value = "AlunoAula", description = "Modelo da relação de alunos e aulas")
@Data
@Entity
@Table(name = "aluno_aula")
public class AlunoAula {

	@ApiModelProperty(value = "ID da aluno-aula", example = "1")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ApiModelProperty(value = "Aluno")
	@NotNull(message = "aluno não pode ser nulo")
	@ManyToOne(targetEntity = Aluno.class)
	@JoinColumn(name = "id_aluno")
	private Aluno aluno;

	@ApiModelProperty(value = "Aula")
	@NotNull(message = "aula não pode ser nulo")
	@ManyToOne(targetEntity = Aula.class)
	@JoinColumn(name = "id_aula")
	private Aula aula;
	
	@ApiModelProperty(value = "Controla se o aluno tem acesso a aula", example = "false")
	private Boolean disponivel;
	
	@ApiModelProperty(value = "Data e hora de cadastro da relação", example = "2020-10-10T20:09:54.919+00:00")
	@NotNull(message = "data aquisicao não pode ser nulo")
	@Column(name = "data_aquisicao")
	private Timestamp dataAquisicao;

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

	public Aula getAlua() {
		return aula;
	}

	public void setAlua(Aula alua) {
		this.aula = alua;
	}

	public Boolean getDisponivel() {
		return disponivel;
	}

	public void setDisponivel(Boolean disponivel) {
		this.disponivel = disponivel;
	}

	public Timestamp getDataAquisicao() {
		return dataAquisicao;
	}

	public void setDataAquisicao(Timestamp dataAquisicao) {
		this.dataAquisicao = dataAquisicao;
	}

	
}
