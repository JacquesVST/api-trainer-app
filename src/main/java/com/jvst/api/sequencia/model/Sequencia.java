package com.jvst.api.sequencia.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.jvst.api.atividade.model.Atividade;
import com.jvst.api.aula.model.Aula;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel(value = "Sequência", description = "Modelo da sequência que será usada para montar aulas personalizáveis")
@Data
@Entity
@Table(name = "sequencia")
public class Sequencia {

	@ApiModelProperty(value = "ID da sequência", example = "1")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ApiModelProperty(value = "Tempo de repetição da atividade em segundos", example = "600")
	private Integer tempo;

	@ApiModelProperty(value = "Vezes que a atividade será repetida em uma série", example = "10")
	private Integer repeticoes;

	@ApiModelProperty(value = "Vezes que serão contadas as repetições", example = "3")
	private Integer series;

	@ApiModelProperty(value = "Breve descrição da sequência, caso haja alguma consideração específica", example = "Sem descrição")
	@NotNull(message = "descricao não pode ser nulo")
	@Size(max = 300, message = "limite de caracteres para descricao excedido")
	private String descricao;

	@ApiModelProperty(value = "Atividade a ser atribuída as especificações da sequência")
	@NotNull(message = "atividade não pode ser nulo")
	@ManyToOne(targetEntity = Atividade.class)
	@JoinColumn(name = "id_atividade")
	private Atividade atividade;

	@ApiModelProperty(value = "Aula da qual a sequência faz parte")
	@NotNull(message = "aula não pode ser nulo")
	@ManyToOne(targetEntity = Aula.class)
	@JoinColumn(name = "id_aula")
	private Aula aula;

	@ApiModelProperty(value = "Ordem da seqência na lista de sequências de uma aula", example = "1")
	private Integer ordem;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getTempo() {
		return tempo;
	}

	public void setTempo(Integer tempo) {
		this.tempo = tempo;
	}

	public Integer getRepeticoes() {
		return repeticoes;
	}

	public void setRepeticoes(Integer repeticoes) {
		this.repeticoes = repeticoes;
	}

	public Integer getSeries() {
		return series;
	}

	public void setSeries(Integer series) {
		this.series = series;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Atividade getAtividade() {
		return atividade;
	}

	public void setAtividade(Atividade atividade) {
		this.atividade = atividade;
	}

	public Aula getAula() {
		return aula;
	}

	public void setAula(Aula aula) {
		this.aula = aula;
	}

	public Integer getOrdem() {
		return ordem;
	}

	public void setOrdem(Integer ordem) {
		this.ordem = ordem;
	}

}
