package com.jvst.api.usuario.model;

import java.sql.Timestamp;

import javax.persistence.Column;
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

@ApiModel(value = "Usuário", description = "Modelo do usuário que será usado de base para os modelos de instrutor e aluno")
@Data
@Entity
@Table(name = "usuario")
public class Usuario {

	@ApiModelProperty(value = "ID do usuário", example = "1")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ApiModelProperty(value = " E-Mail do usuário usado para criação de conta e login, e no envio de validações, recuperação, avisos sobre a conta", example = "exemplo@exemplo.com")
	@NotNull(message = "email não pode ser nulo")
	@Size(max = 320, message = "limite de caracteres para email excedido")
	private String email;

	@ApiModelProperty(value = "Senha do usuário usada para autenticação", example = "SeNhA123")
	@NotNull(message = "senha não pode ser nulo")
	@Size(max = 50, message = "limite de caracteres para senha excedido")
	private String senha;

	@ApiModelProperty(value = "Primeiro nome do usuário para ser exibido em seu perfil", example = "Exemplo")
	@NotNull(message = "primeiro nome não pode ser nulo")
	@Size(max = 100, message = "limite de caracteres para primeiro nome excedido")
	@Column(name = "primeiro_nome")
	private String primeiroNome;

	@ApiModelProperty(value = "Último nome do usuário para ser exibido em seu perfil", example = "Silva")
	@Size(max = 100, message = "limite de caracteres para ultimo nome excedido")
	@Column(name = "ultimo_nome")
	private String ultimoNome;

	@ApiModelProperty(value = "Data e Hora em que a conta foi criada, em formato de timestamp com fuso horário", example = "2020-10-28T20:09:54.919+00:00")
	@Column(name = "data_cadastro")
	private Timestamp dataCadastro;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	public Timestamp getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Timestamp dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

}
