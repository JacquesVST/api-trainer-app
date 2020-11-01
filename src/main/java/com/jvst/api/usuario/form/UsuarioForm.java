package com.jvst.api.usuario.form;

import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "UsuarioForm", description = "Modelo para cadastro e atualização dos dados do usuário")
public class UsuarioForm {

	@ApiModelProperty(value = " E-Mail do usuário usado para criação de conta e login, e no envio de validações, recuperação, avisos sobre a conta", example = "exemplo@exemplo.com")
	@Size(max = 320, message = "limite de caracteres para email excedido")
	private String email;

	@ApiModelProperty(value = "Senha do usuário usada para autenticação", example = "SeNhA123")
	@Size(max = 50, message = "limite de caracteres para senha excedido")
	private String senha;

	@ApiModelProperty(value = "Primeiro nome do usuário para ser exibido em seu perfil", example = "Exemplo")
	@Size(max = 100, message = "limite de caracteres para primeiro nome excedido")
	private String primeiroNome;

	@ApiModelProperty(value = "Último nome do usuário para ser exibido em seu perfil", example = "Silva")
	@Size(max = 100, message = "limite de caracteres para ultimo nome excedido")
	private String ultimoNome;

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

	public String getPrimeiroNome() {
		return primeiroNome;
	}

	public void setPrimeiroNome(String primeiroNome) {
		this.primeiroNome = primeiroNome;
	}

	public String getUltimoNome() {
		return ultimoNome;
	}

	public void setUltimoNome(String ultimoNome) {
		this.ultimoNome = ultimoNome;
	}

}
