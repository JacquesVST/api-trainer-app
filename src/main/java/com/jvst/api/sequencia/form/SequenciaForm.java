package com.jvst.api.sequencia.form;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "SequenciaForm", description = "Modelo para cadastro e atualização dos dados da sequencia")
public class SequenciaForm {

	@ApiModelProperty(value = "Tempo de repetição da atividade em segundos", example = "600")
	private Integer tempo;

	@ApiModelProperty(value = "Vezes que a atividade será repetida em uma série", example = "10")
	private Integer repoeticoes;

	@ApiModelProperty(value = "Vezes que serão contadas as repetições", example = "3")
	private Integer series;

	@ApiModelProperty(value = "Breve descrição da sequência, caso haja alguma consideração específica", example = "Sem descrição")
	@NotNull(message = "descricao não pode ser nulo")
	@Size(max = 300, message = "limite de caracteres para descricao excedido")
	private String descricao;

	@ApiModelProperty(value = "Atividade a ser atribuída as especificações da sequência")
	@NotNull(message = "atividade não pode ser nulo")
	private Long idAtividade;

	@ApiModelProperty(value = "Aula da qual a sequência faz parte")
	@NotNull(message = "aula não pode ser nulo")
	private Long idAula;

	@ApiModelProperty(value = "Ordem da seqência na lista de sequências de uma aula", example = "1")
	private Integer ordem;

	public Integer getTempo() {
		return tempo;
	}

	public void setTempo(Integer tempo) {
		this.tempo = tempo;
	}

	public Integer getRepoeticoes() {
		return repoeticoes;
	}

	public void setRepoeticoes(Integer repoeticoes) {
		this.repoeticoes = repoeticoes;
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

	public Long getIdAtividade() {
		return idAtividade;
	}

	public void setIdAtividade(Long idAtividade) {
		this.idAtividade = idAtividade;
	}

	public Long getIdAula() {
		return idAula;
	}

	public void setIdAula(Long idAula) {
		this.idAula = idAula;
	}

	public Integer getOrdem() {
		return ordem;
	}

	public void setOrdem(Integer ordem) {
		this.ordem = ordem;
	}

}
