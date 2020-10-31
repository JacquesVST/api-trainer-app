package com.jvst.api.usuario.dto;

import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "LoginDTO", description = "Modelo com e-mail e senha exclusivamente para efetuar login")
public class LoginDTO {

	@ApiModelProperty(value = " E-Mail do usuário usado para criação de conta e login", example = "exemplo@exemplo.com")
	@NotNull(message = "email não pode ser nulo")
	private String email;
	
	@ApiModelProperty(value = "Senha do usuário usada para autenticação", example = "SeNhA123")
	@NotNull(message = "senha não pode ser nulo")
	private String senha;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
}
