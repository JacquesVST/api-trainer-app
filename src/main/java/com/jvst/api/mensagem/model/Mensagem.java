package com.jvst.api.mensagem.model;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.jvst.api.chat.model.Chat;
import com.jvst.api.usuario.model.Usuario;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel(value = "Mensagem", description = "Modelo de mensagem usada no chat para comunicação de instrutores e alunos")
@Data
@Entity
@Table(name = "mensagem")
public class Mensagem {

	@ApiModelProperty(value = "ID da mensagem", example = "1")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ApiModelProperty(value = "Data e hora de envio da mensagem", example = "2020-10-20T20:00:54.919+00:00")
	private Timestamp envio;
	
	@ApiModelProperty(value = "Conteúdo da mensagem", example = "Hello world!")
	private String conteudo;

	@ApiModelProperty(value = "Data e hora de visualização da mensagem", example = "2020-10-21T20:00:54.919+00:00")
	private Timestamp visualizado;

	@ApiModelProperty(value = "ID do chat a que a mensagem pertence")
	@NotNull(message = "chat não pode ser nulo")
	@ManyToOne(targetEntity = Chat.class)
	@JoinColumn(name = "id_chat")
	private Chat chat;

	@ApiModelProperty(value = "ID do usuário que enviou a mensagem")
	@NotNull(message = "usuario não pode ser nulo")
	@ManyToOne(targetEntity = Usuario.class)
	@JoinColumn(name = "id_usuario")
	private Usuario usuario;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Timestamp getEnvio() {
		return envio;
	}

	public void setEnvio(Timestamp envio) {
		this.envio = envio;
	}

	public String getConteudo() {
		return conteudo;
	}

	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}

	public Timestamp getVisualizado() {
		return visualizado;
	}

	public void setVisualizado(Timestamp visualizado) {
		this.visualizado = visualizado;
	}

	public Chat getChat() {
		return chat;
	}

	public void setChat(Chat chat) {
		this.chat = chat;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
