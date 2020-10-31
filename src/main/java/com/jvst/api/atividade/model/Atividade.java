package com.jvst.api.atividade.model;

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

import com.jvst.api.instrutor.model.Instrutor;
import com.jvst.api.video.model.Video;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel(value = "Atividade", description = "Modelo da atividade que será usada para montar aulas personalizáveis")
@Data
@Entity
@Table(name = "atividade")
public class Atividade {

	@ApiModelProperty(value = "ID da atividade", example = "1")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

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
	@ManyToOne(targetEntity = Video.class)
	@JoinColumn(name = "id_video")
	private Video video;

	@ApiModelProperty(value = "Instrutor que cadastrou a atividade")
	@NotNull(message = "instrutor não pode ser nulo")
	@ManyToOne(targetEntity = Instrutor.class)
	@JoinColumn(name = "id_instrutor")
	private Instrutor instrutor;

	@ApiModelProperty(value = "Data e hora de cadastro da atividade, para ordenação no sistema", example = "2020-10-10T20:09:54.919+00:00")
	@Column(name = "data_cadastro")
	private Timestamp dataCadastro;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	public Video getVideo() {
		return video;
	}

	public void setVideo(Video video) {
		this.video = video;
	}

	public Instrutor getInstrutor() {
		return instrutor;
	}

	public void setInstrutor(Instrutor instrutor) {
		this.instrutor = instrutor;
	}

	public Timestamp getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Timestamp dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
	
}
