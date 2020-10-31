package com.jvst.api.usuario.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.jvst.api.usuario.dto.LoginDTO;
import com.jvst.api.usuario.model.Usuario;
import com.jvst.api.usuario.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	public List<Usuario> listarUsuarios() {
		return this.usuarioRepository.findAll();
	}

	public void salvarUsuario(Usuario usuario) {
		this.usuarioRepository.save(usuario);
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
}
