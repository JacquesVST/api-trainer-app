package com.jvst.api.instrutor.form;

import javax.validation.constraints.Size;

import com.jvst.api.util.Doc;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "InstrutorForm", description = Doc.FORM_DESC + "do instrutor")
public class InstrutorForm {

	@ApiModelProperty(value = "Data de nascimento para validações de idade", example = "1999-12-22T20:09:54.919+00:00")
	private String dataNascimento;

	@ApiModelProperty(value = "Número de telefone visível no perfil do instrutor e no chat com o aluno", example = "018 98888-7777")
	@Size(max = 14, message = "limite de caracteres para numero contato excedido")
	private String numeroContato;

	@ApiModelProperty(value = "E-mail visível no perfil do instrutor", example = "exemplo@exemplo.com")
	@Size(max = 320, message = "limite de caracteres para email contato excedido")
	private String emailContato;

	@ApiModelProperty(value = "Nome de usuário para ser usado em URLs", example = "exemplo_usuario")
	@Size(max = 50, message = "limite de caracteres para link usuario excedido")
	private String linkUsuario;

	@ApiModelProperty(value = "ID do imagem de perfil que será carregada pelo usuário", example = "1")
	private Long idImagem;

	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getNumeroContato() {
		return numeroContato;
	}

	public void setNumeroContato(String numeroContato) {
		this.numeroContato = numeroContato;
	}

	public String getEmailContato() {
		return emailContato;
	}

	public void setEmailContato(String emailContato) {
		this.emailContato = emailContato;
	}

	public String getLinkUsuario() {
		return linkUsuario;
	}

	public void setLinkUsuario(String linkUsuario) {
		this.linkUsuario = linkUsuario;
	}

	public Long getIdImagem() {
		return idImagem;
	}

	public void setIdImagem(Long imagem) {
		this.idImagem = imagem;
	}
}
