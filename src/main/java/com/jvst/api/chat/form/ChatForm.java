package com.jvst.api.chat.form;

import javax.validation.constraints.NotNull;

import com.jvst.api.util.Doc;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "ChatForm", description = Doc.FORM_DESC + "do chat")
public class ChatForm {

	@ApiModelProperty(value = "ID do instrutor do chat")
	@NotNull(message = "instrutor não pode ser nulo")
	private Long idInstrutor;

	@ApiModelProperty(value = "ID do aluno do chat")
	@NotNull(message = "aluno não pode ser nulo")
	private Long idAluno;

	public Long getIdInstrutor() {
		return idInstrutor;
	}

	public void setIdInstrutor(Long idInstrutor) {
		this.idInstrutor = idInstrutor;
	}

	public Long getIdAluno() {
		return idAluno;
	}

	public void setIdAluno(Long idAluno) {
		this.idAluno = idAluno;
	}

}
