package com.jvst.api.ficha.form;

import javax.validation.constraints.NotNull;

import com.jvst.api.util.Doc;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "FIchaForm", description = Doc.FORM_DESC + "da ficha")
public class FichaForm {

	@ApiModelProperty(value = "Aluno que preencheu a ficha")
	@NotNull(message = "aluno não pode ser nulo")
	private Long idAluno;

	@ApiModelProperty(value = "Campo que guardará todas as informações que o instrutor solicitar na ficha", example = "Peso, Cintura, Altura...")
	private String detalhes;

	public Long getIdAluno() {
		return idAluno;
	}

	public void setIdAluno(Long idAluno) {
		this.idAluno = idAluno;
	}

	public String getDetalhes() {
		return detalhes;
	}

	public void setDetalhes(String detalhes) {
		this.detalhes = detalhes;
	}

}
