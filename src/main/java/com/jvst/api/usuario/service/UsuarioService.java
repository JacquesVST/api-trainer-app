package com.jvst.api.usuario.service;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.jvst.api.usuario.dto.LoginDTO;
import com.jvst.api.usuario.form.UsuarioForm;
import com.jvst.api.usuario.model.Usuario;
import com.jvst.api.usuario.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	public List<Usuario> listarUsuarios() {
		return this.usuarioRepository.findAll();
	}

	public Usuario buscarUsuarioPorId(Long idUsuario) {
		Optional<Usuario> usuario = this.usuarioRepository.findById(idUsuario);
		if (!usuario.isPresent()) {
			throw new EmptyResultDataAccessException("Usuário não encontrado", 1);
		}
		return usuario.get();
	}
	
	public Usuario login(LoginDTO loginDTO) {
		Optional<Usuario> usuario = this.usuarioRepository.findByEmail(loginDTO.getEmail());
		if(usuario.isPresent()) {
			if(loginDTO.getSenha().equals(usuario.get().getSenha())) {
				return usuario.get();
			}
		}
		return null;
	}
	
	public void cadastrarUsuario(UsuarioForm usuarioForm) {
		if(this.usuarioRepository.findByEmail(usuarioForm.getEmail()).isPresent()) {
			throw new DuplicateKeyException("E-mail já está em uso por outro usuário");
		}
		
		Usuario usuario = new Usuario();
		usuario.setEmail(usuarioForm.getEmail());
		usuario.setSenha(usuarioForm.getSenha());
		usuario.setPrimeiroNome(usuarioForm.getPrimeiroNome());
		usuario.setUltimoNome(usuarioForm.getUltimoNome());
		usuario.setDataCadastro(Timestamp.from(Instant.now()));
		usuario.setAtivo(true);
        this.usuarioRepository.save(usuario);
    }
	
	public void atualizarUsuario(Long idUsuario, UsuarioForm usuarioForm) {
		Optional<Usuario> usuarioPorEmail = this.usuarioRepository.findByEmail(usuarioForm.getEmail());
		if(usuarioPorEmail.isPresent()) {
			if(!usuarioPorEmail.get().getId().equals(idUsuario)) {
				throw new DuplicateKeyException("E-mail já está em uso por outro usuário");				
			}
		}
		
		Usuario usuario = this.buscarUsuarioPorId(idUsuario);
		usuario.setEmail(usuarioForm.getEmail());
		usuario.setSenha(usuarioForm.getSenha());
		usuario.setPrimeiroNome(usuarioForm.getPrimeiroNome());
		usuario.setUltimoNome(usuarioForm.getUltimoNome());
        this.usuarioRepository.save(usuario);
    }
	
	public void alterarAtividade(Long idUsuario) {
		Usuario usuario = this.buscarUsuarioPorId(idUsuario);
		usuario.setAtivo(!usuario.getAtivo());
        this.usuarioRepository.save(usuario);
    }

}
