package com.jvst.api.video.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel(value = "Vídeo", description = "Modelo para armazenar vídeos enviados no sistemas, podendo ser externamente")
@Data
@Entity
@Table(name = "video")
public class Video {

	@ApiModelProperty(value = "ID do vídeo", example = "1")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ApiModelProperty(value = "Dados do vídeo em base64")
	private String base64;

	@ApiModelProperty(value = "URL do vídeo no caso do uso de um repositório externo", example = "https://image.shutterstock.com/image-vector/default-ui-image-placeholder-wireframes-260nw-1037719192.jpg")
	private String url;

	@ApiModelProperty(hidden = true)
	private byte[] thumbnail;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBase64() {
		return base64;
	}

	public void setBase64(String base64) {
		this.base64 = base64;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public byte[] getThumbnail() {
		return thumbnail;
	}

	public void setThumbnail(byte[] thumbnail) {
		this.thumbnail = thumbnail;
	}

}
