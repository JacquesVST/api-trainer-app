package com.jvst.api.mensagem.form;

import javax.validation.constraints.NotNull;

import com.jvst.api.util.Doc;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "MensagemForm", description = Doc.FORM_DESC + "da mensagem")
public class MensagemForm {

	@ApiModelProperty(value = "Conteúdo da mensagem", example = "Hello world!")
	private String conteudo;

	@ApiModelProperty(value = "ID do chat a que a menasagem pertence")
	@NotNull(message = "chat não pode ser nulo")
	private Long idChat;

	@ApiModelProperty(value = "ID do usuário que enviou a mensagem")
	@NotNull(message = "usuario não pode ser nulo")
	private Long idUsuario;

	public String getConteudo() {
		return conteudo;
	}

	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}

	public Long getIdChat() {
		return idChat;
	}

	public void setIdChat(Long idChat) {
		this.idChat = idChat;
	}

	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

}
