package com.jvst.api.atividadeTag.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jvst.api.atividade.model.Atividade;
import com.jvst.api.atividadeTag.service.AtividadeTagService;
import com.jvst.api.tag.model.Tag;
import com.jvst.api.util.Doc;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(value = "Tags da Atividade", tags = { "Tags da Atividade" })
@RestController
@RequestMapping("/atividade-tag")
public class AtividadeTagResource {

	@Autowired
	private AtividadeTagService atividadeTagService;

	@ApiOperation(value = Doc.LISTAR_PREFIX + "tags" + Doc.LISTAR_SUFFIX + "atividade")
	@GetMapping("/atividade/{idAtividade}")
	public List<Tag> listarTagsPorIdAtividade(@PathVariable @ApiParam(value = Doc.PARAM_ID_PREFIX
			+ "de atividade da relação atividade-tag" + Doc.PARAM_ID_SUFFIX1, example = "1") Long idAtividade) {
		return this.atividadeTagService.listarTagsPorIdAtividade(idAtividade);
	}

	@ApiOperation(value = Doc.LISTAR_PREFIX + "atividades" + Doc.LISTAR_SUFFIX + "tag")
	@GetMapping("/tag/{idTag}")
	public List<Atividade> listarAtividadesPorIdTag(@PathVariable @ApiParam(value = Doc.PARAM_ID_PREFIX
			+ "de tag da relação atividade-tag" + Doc.PARAM_ID_SUFFIX1, example = "1") Long idTag) {
		return this.atividadeTagService.listarAtividadesPorIdTag(idTag);
	}

}
