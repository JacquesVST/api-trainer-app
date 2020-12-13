package com.jvst.api.video.resource;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jvst.api.util.Doc;
import com.jvst.api.video.model.Video;
import com.jvst.api.video.service.VideoService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(value = "Vídeo", tags = { "Vídeo" })
@RestController
@RequestMapping("/video")
public class VideoResource {

	@Autowired
	private VideoService videoService;
	
	@ApiOperation(value = Doc.BUSCAR_PREFIX + "o vídeo" + Doc.BUSCAR_SUFFIX)
	@GetMapping("/{idVideo}")
	public Video buscarVideoPorId(@PathVariable @ApiParam(value = Doc.PARAM_ID_PREFIX + "do vídeo"
			+ Doc.PARAM_ID_SUFFIX1, example = "1") Long idVideo) {
		return this.videoService.buscarVideoPorId(idVideo);
	}
	
	@ApiOperation(value = Doc.CADASTRAR_PREFIX + "um novo vídeo" + Doc.CADASTRAR_SUFFIX)
	@PostMapping
	public void cadastrarVideo(@RequestBody @Valid @ApiParam(value = Doc.PARAM_ENTIDADE_PREFIX + "vídeo"
			+ Doc.PARAM_ENTIDADE_SUFFIX1) Video video) {
		this.videoService.salvarVideo(video);
	}
}
