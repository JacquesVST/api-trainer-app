package com.jvst.api.aula.model;

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

import com.jvst.api.imagem.model.Imagem;
import com.jvst.api.instrutor.model.Instrutor;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel(value = "Aula", description = "Modelo da aula que será criada pelo instrutor")
@Data
@Entity
@Table(name = "aula")
public class Aula {

	@ApiModelProperty(value = "ID da aula", example = "1")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ApiModelProperty(value = "Instrutor que cadastrou a aula")
	@NotNull(message = "instrutor não pode ser nulo")
	@ManyToOne(targetEntity = Instrutor.class)
	@JoinColumn(name = "id_instrutor")
	private Instrutor instrutor;

	@ApiModelProperty(value = "Título da aula para fácil reconhecimento", example = "Musculação Iniciante")
	@NotNull(message = "titulo não pode ser nulo")
	@Size(max = 50, message = "limite de caracteres para titulo excedido")
	private String titulo;

	@ApiModelProperty(value = "Breve descrição da aula", example = "Reforçar joelhos, costas e peitoral")
	@NotNull(message = "descricao não pode ser nulo")
	@Size(max = 300, message = "limite de caracteres para descricao excedido")
	private String descricao;

	@ApiModelProperty(value = "Imagem para ser usada de capa para a aula")
	@ManyToOne(targetEntity = Imagem.class)
	@JoinColumn(name = "id_imagem")
	private Imagem imagem;

	@ApiModelProperty(value = "Controla se a aula poderá ser encontrada na busca global", example = "false")
	private Boolean privado;

	@ApiModelProperty(value = "Data e hora de cadastro da aula, para ordenação no sistema", example = "2020-10-10T20:09:54.919+00:00")
	@Column(name = "data_cadastro")
	private Timestamp dataCadastro;

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

	public Imagem getImagem() {
		return imagem;
	}

	public void setImagem(Imagem imagem) {
		this.imagem = imagem;
	}

	public Boolean getPrivado() {
		return privado;
	}

	public void setPrivado(Boolean privado) {
		this.privado = privado;
	}

	public Timestamp getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Timestamp dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

}
