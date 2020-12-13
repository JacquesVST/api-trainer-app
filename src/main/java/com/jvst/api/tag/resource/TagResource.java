package com.jvst.api.tag.resource;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jvst.api.tag.model.Tag;
import com.jvst.api.tag.service.TagService;
import com.jvst.api.util.Doc;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(value = "Tag", tags = { "Tag" })
@RestController
@RequestMapping("/tag")
public class TagResource {

	@Autowired
	private TagService tagService;

	@ApiOperation(value = Doc.LISTAR_PREFIX + "todas as tags")
	@GetMapping
	public List<Tag> listarTags() {
		return this.tagService.listarTags();
	}

	@ApiOperation(value = Doc.BUSCAR_PREFIX + "a tag" + Doc.BUSCAR_SUFFIX)
	@GetMapping("/{idTag}")
	public Tag buscarTagPorId(@PathVariable @ApiParam(value = Doc.PARAM_ID_PREFIX + "da tag"
			+ Doc.PARAM_ID_SUFFIX1, example = "1") Long idTag) {
		return this.tagService.buscarTagPorId(idTag);
	}

	@ApiOperation(value = Doc.CADASTRAR_PREFIX + "uma nova tag" + Doc.CADASTRAR_SUFFIX)
	@PostMapping
	public void cadastrarTag(@RequestBody @Valid @ApiParam(value = Doc.PARAM_ENTIDADE_PREFIX + "tag"
			+ Doc.PARAM_ENTIDADE_SUFFIX1) Tag tag) {
		this.tagService.salvarTag(tag);
	}

}
