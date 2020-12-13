package com.jvst.api.avaliacao.model;

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
import javax.validation.constraints.Size;

import com.jvst.api.aluno.model.Aluno;
import com.jvst.api.aula.model.Aula;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel(value = "Avaliação", description = "Modelo da avaliação pública que o aluno poderá deixar em uma aula adquirida")
@Data
@Entity
@Table(name = "avaliacao")
public class Avaliacao {
	
	@ApiModelProperty(value = "ID da avaliação", example = "1")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ApiModelProperty(value = "Aula para qual foi deixada a avaliação")
	@NotNull(message = "aula não pode ser nulo")
	@ManyToOne(targetEntity = Aula.class)
	@JoinColumn(name = "id_aula")
	private Aula aula;
	
	@ApiModelProperty(value = "Aluno autor da avaliação")
	@NotNull(message = "aluno não pode ser nulo")
	@ManyToOne(targetEntity = Aluno.class)
	@JoinColumn(name = "id_aluno")
	private Aluno aluno;

	@ApiModelProperty(value = "Data e hora de submissão da avaliação", example = "2020-10-10T20:09:54.919+00:00")
	@Column(name = "data_hora")
	private Timestamp dataHora;
	
	@ApiModelProperty(value = "Título para a avaliação", example = "Deu resultados!")
	@NotNull(message = "titulo não pode ser nulo")
	@Size(max = 50, message = "limite de caracteres para titulo excedido")
	private String titulo;

	@ApiModelProperty(value = "Breve descrição da experiência do aluno", example = "Atendeu minhas expectativas a tempo")
	@NotNull(message = "conteudo não pode ser nulo")
	@Size(max = 300, message = "limite de caracteres para conteudo excedido")
	private String conteudo;

	@ApiModelProperty(value = "Valor numérico de 1 a 5 para métrica rápida de qualidade", example = "5")
	@NotNull(message = "nota não pode ser nulo")
	private Integer nota;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Aula getAula() {
		return aula;
	}

	public void setAula(Aula aula) {
		this.aula = aula;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public Timestamp getDataHora() {
		return dataHora;
	}

	public void setDataHora(Timestamp dataHora) {
		this.dataHora = dataHora;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getConteudo() {
		return conteudo;
	}

	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}

	public Integer getNota() {
		return nota;
	}

	public void setNota(Integer nota) {
		this.nota = nota;
	}


}
