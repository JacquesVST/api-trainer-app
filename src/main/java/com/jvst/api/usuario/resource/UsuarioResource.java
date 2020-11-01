package com.jvst.api.usuario.resource;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jvst.api.usuario.dto.LoginDTO;
import com.jvst.api.usuario.form.UsuarioForm;
import com.jvst.api.usuario.model.Usuario;
import com.jvst.api.usuario.service.UsuarioService;
import com.jvst.api.util.Doc;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(value = "Usuário", tags = { "Usuário" })
@RestController
@RequestMapping(value = "/usuario", produces = { "application/json" })
public class UsuarioResource {

	@Autowired
	private UsuarioService usuarioService;

	@ApiOperation(value = Doc.LISTAR_PREFIX + "todos os usuários")
	@GetMapping
	public List<Usuario> listarUsuarios() {
		return this.usuarioService.listarUsuarios();
	}

	@ApiOperation(value = Doc.BUSCAR_PREFIX + "o usuário" + Doc.BUSCAR_SUFFIX)
	@GetMapping("/{idUsuario}")
	public Usuario buscarUsuarioPorId(@PathVariable @ApiParam(value = Doc.PARAM_ID_PREFIX + "do usuário"
			+ Doc.PARAM_ID_SUFFIX1, example = "1") Long idUsuario) {
		return this.usuarioService.buscarUsuarioPorId(idUsuario);
	}

	@ApiOperation(value = Doc.CADASTRAR_PREFIX + "um novo usuário" + Doc.CADASTRAR_SUFFIX)
	@PostMapping
	public void cadastrarUsuario(@RequestBody @Valid @ApiParam(value = Doc.PARAM_ENTIDADE_PREFIX + "usuário"
			+ Doc.PARAM_ENTIDADE_SUFFIX1) UsuarioForm usuarioForm) {
		this.usuarioService.cadastrarUsuario(usuarioForm);
	}

	@ApiOperation(value = Doc.ATUALIZAR_PREFIX + "um usuário" + Doc.ATUALIZAR_SUFFIX)
	@PutMapping("/{idUsuario}")
	public void atualizarUsuario(
			@PathVariable @ApiParam(value = Doc.PARAM_ID_PREFIX + "do usuário"
					+ Doc.PARAM_ID_SUFFIX2, example = "1") Long idUsuario,
			@RequestBody @Valid @ApiParam(value = Doc.PARAM_ENTIDADE_PREFIX + "usuário"
					+ Doc.PARAM_ENTIDADE_SUFFIX2) UsuarioForm usuarioForm) {
		this.usuarioService.atualizarUsuario(idUsuario, usuarioForm);
	}

	@ApiOperation(value = "Retorna o usuário se as credenciais forem válidas")
	@PostMapping("/login")
	public Usuario login(
			@RequestBody @Valid @ApiParam(value = "Objeto de login com e-email e senha para autenticação") LoginDTO loginDTO) {
		return this.usuarioService.login(loginDTO);
	}

	@ApiOperation(value = "Retorna o usuário se as credenciais forem válidas")
	@PostMapping("/alterar-atividade/{idUsuario}")
	public void alterarAtividade(
			@PathVariable @ApiParam(value = "ID do usuário a ser ativado ou desativado", example = "1") Long idUsuario) {
		this.usuarioService.alterarAtividade(idUsuario);
	}
}
