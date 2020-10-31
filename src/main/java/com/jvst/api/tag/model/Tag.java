package com.jvst.api.tag.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel(value = "Tag", description = "Modelo da tag que será usada para categorizar atividades")
@Data
@Entity
@Table(name = "tag")
public class Tag {
	
	@ApiModelProperty(value = "ID da tag", example = "1")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ApiModelProperty(value = "Descricao da tag", example = "Treino Funcional")
	@NotNull(message = "descricao não pode ser nulo")
	@Size(max = 50, message = "limite de caracteres para descricao excedido")
	private String descricao;
	
	@ApiModelProperty(value = "Cor para visualmente destacar a tag", example = "#fcba03")
	@Size(max = 7, message = "limite de caracteres para cor excedido")
	private String cor;
}
