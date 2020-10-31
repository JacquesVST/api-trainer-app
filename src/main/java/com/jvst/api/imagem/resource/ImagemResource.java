package com.jvst.api.imagem.resource;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jvst.api.imagem.model.Imagem;
import com.jvst.api.imagem.service.ImagemService;
import com.jvst.api.util.Doc;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(value = "Imagem", tags = {"Imagem"})
@RestController
@RequestMapping("/imagem")
public class ImagemResource {
	
	@Autowired
	private ImagemService imagemService;
	
	@ApiOperation(value = Doc.BUSCAR_PREFIX + "a imagem" + Doc.BUSCAR_SUFFIX)
	@GetMapping("/{idImagem}")
	public Imagem buscarImagemPorId(@PathVariable @ApiParam(value = Doc.PARAM_ID_PREFIX + "da imagem"
			+ Doc.PARAM_ID_SUFFIX1, example = "1") Long idImagem) {
		return this.imagemService.buscarImagemPorId(idImagem);
	}
	
	@ApiOperation(value = Doc.CADASTRAR_PREFIX + "uma nova imagem" + Doc.CADASTRAR_SUFFIX)
	@PostMapping
	public void cadastrarImagem(@RequestBody @Valid @ApiParam(value = Doc.PARAM_ENTIDADE_PREFIX + "imagem"
			+ Doc.PARAM_ENTIDADE_SUFFIX1) Imagem imagem) {
		this.imagemService.salvarImagem(imagem);
	}
}
