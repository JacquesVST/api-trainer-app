package com.jvst.api.atividade.form;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.jvst.api.util.Doc;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "AtividadeForm", description = Doc.FORM_DESC + "da atividade")
public class AtividadeForm {

	@ApiModelProperty(value = "Título da atividade para fácil reconhecimento", example = "Abdominal")
	@NotNull(message = "titulo não pode ser nulo")
	@Size(max = 50, message = "limite de caracteres para titulo excedido")
	private String titulo;

	@ApiModelProperty(value = "Breve descrição da atividade", example = "Reforçar joelhos, costas e peitoral")
	@NotNull(message = "descricao não pode ser nulo")
	@Size(max = 300, message = "limite de caracteres para descricao excedido")
	private String descricao;

	@ApiModelProperty(value = "Material recomendado a usar para a atividade", example = "Corda")
	@NotNull(message = "material não pode ser nulo")
	@Size(max = 300, message = "limite de caracteres para material excedido")
	private String material;

	@ApiModelProperty(value = "Vídeo com exemplo da atividade executada pelo profissional")
	private Long idVideo;

	@ApiModelProperty(value = "ID do instrutor que cadastrou a atividade")
	@NotNull(message = "instrutor não pode ser nulo")
	private Long idInstrutor;

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

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	public Long getIdVideo() {
		return idVideo;
	}

	public void setIdVideo(Long idVideo) {
		this.idVideo = idVideo;
	}

	public Long getIdInstrutor() {
		return idInstrutor;
	}

	public void setIdInstrutor(Long idInstrutor) {
		this.idInstrutor = idInstrutor;
	}

}
