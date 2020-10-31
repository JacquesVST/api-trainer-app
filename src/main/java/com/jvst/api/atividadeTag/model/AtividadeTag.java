package com.jvst.api.atividadeTag.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.jvst.api.atividade.model.Atividade;
import com.jvst.api.tag.model.Tag;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel(value = "AtividadeTag", description = "Modelo da relação de atividades e tags")
@Data
@Entity
@Table(name = "atividade_tag")
public class AtividadeTag {

	@ApiModelProperty(value = "ID da atividade-tag", example = "1")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ApiModelProperty(value = "Atividade")
	@NotNull(message = "atividade não pode ser nulo")
	@ManyToOne(targetEntity = Atividade.class)
	@JoinColumn(name = "id_atividade")
	private Atividade atividade;
	
	@ApiModelProperty(value = "Tag")
	@NotNull(message = "tag não pode ser nulo")
	@ManyToOne(targetEntity = Tag.class)
	@JoinColumn(name = "id-tag")
	private Tag tag;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Atividade getAtividade() {
		return atividade;
	}

	public void setAtividade(Atividade atividade) {
		this.atividade = atividade;
	}

	public Tag getTag() {
		return tag;
	}

	public void setTag(Tag tag) {
		this.tag = tag;
	}
	
	
}
