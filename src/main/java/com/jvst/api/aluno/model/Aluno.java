package com.jvst.api.aluno.model;

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

import com.jvst.api.imagem.model.Imagem;
import com.jvst.api.usuario.model.Usuario;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel(value = "Aluno", description = "Modelo do aluno que poderá acessar o aplicativo para fazer as aulas e falar com instrutores")
@Data
@Entity
@Table(name = "aluno")
public class Aluno {

	@ApiModelProperty(value = "ID do aluno", example = "1")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ApiModelProperty(value = "Data de nascimento para validações de idade", example = "1999-12-22T20:09:54.919+00:00")
	@NotNull(message = "data nascimento não pode ser nulo")
	@Column(name = "data_nascimento")
	private Timestamp dataNascimento;

	@ApiModelProperty(value = "Número de telefone vísivel no perfil do aluno e no chat com o instrutor", example = "018 98888-7777")
	@Column(name = "numero_contato")
	@Size(max = 14, message = "limite de caracteres para numero contato excedido")
	private String numeroContato;

	@ApiModelProperty(value = "Nome de usuário para ser usado em URLs", example = "exemplo_usuario")
	@Column(name = "link_usuario")
	@Size(max = 50, message = "limite de caracteres para link usuario excedido")
	private String linkUsuario;

	@ApiModelProperty(value = "Usuário genérico")
	@NotNull(message = "usuario não pode ser nulo")
	@ManyToOne(targetEntity = Usuario.class)
	@JoinColumn(name = "id_usuario")
	private Usuario usuario;

	@ApiModelProperty(value = "Imagem de perfil que será carregada pelo usuário")
	@ManyToOne(targetEntity = Imagem.class)
	@JoinColumn(name = "id_imagem")
	private Imagem imagem;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Timestamp getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Timestamp dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getNumeroContato() {
		return numeroContato;
	}

	public void setNumeroContato(String numeroContato) {
		this.numeroContato = numeroContato;
	}

	public String getLinkUsuario() {
		return linkUsuario;
	}

	public void setLinkUsuario(String linkUsuario) {
		this.linkUsuario = linkUsuario;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Imagem getImagem() {
		return imagem;
	}

	public void setImagem(Imagem imagem) {
		this.imagem = imagem;
	}

}
