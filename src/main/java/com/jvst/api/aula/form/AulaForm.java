package com.jvst.api.aula.form;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.jvst.api.util.Doc;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "AulaForm", description = Doc.FORM_DESC + "da aula")
public class AulaForm {

	@ApiModelProperty(value = "Instrutor que cadastrou a aula")
	@NotNull(message = "instrutor não pode ser nulo")
	private Long idInstrutor;

	@ApiModelProperty(value = "Título da aula para fácil reconhecimento", example = "Musculação Iniciante")
	@NotNull(message = "titulo não pode ser nulo")
	@Size(max = 50, message = "limite de caracteres para titulo excedido")
	private String titulo;

	@ApiModelProperty(value = "Breve descrição da aula", example = "Reforçar joelhos, costas e peitoral")
	@NotNull(message = "descricao não pode ser nulo")
	@Size(max = 300, message = "limite de caracteres para descricao excedido")
	private String descricao;

	@ApiModelProperty(value = "Imagem para ser usada de capa para a aula")
	private Long idImagem;

	@ApiModelProperty(value = "Controla se a aula poderá ser encontrada na busca global", example = "false")
	private Boolean privado;

	public Long getIdInstrutor() {
		return idInstrutor;
	}

	public void setIdInstrutor(Long idInstrutor) {
		this.idInstrutor = idInstrutor;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Long getIdImagem() {
		return idImagem;
	}

	public void setIdImagem(Long idImagem) {
		this.idImagem = idImagem;
	}

	public Boolean getPrivado() {
		return privado;
	}

	public void setPrivado(Boolean privado) {
		this.privado = privado;
	}

}
