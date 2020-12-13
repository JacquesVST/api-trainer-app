package com.jvst.api.avaliacao.form;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.jvst.api.util.Doc;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "AvaliacaoForm", description = Doc.FORM_DESC + "da avaliacao")
public class AvaliacaoForm {

	@ApiModelProperty(value = "Aula para qual foi deixada a avaliação")
	@NotNull(message = "aula não pode ser nulo")
	private Long idAula;

	@ApiModelProperty(value = "Aluno autor da avaliação")
	@NotNull(message = "aluno não pode ser nulo")
	private Long idAluno;

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

	public Long getIdAula() {
		return idAula;
	}

	public void setIdAula(Long idAula) {
		this.idAula = idAula;
	}

	public Long getIdAluno() {
		return idAluno;
	}

	public void setIdAluno(Long idAluno) {
		this.idAluno = idAluno;
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
