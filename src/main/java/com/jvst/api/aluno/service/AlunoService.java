package com.jvst.api.aluno.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.jvst.api.aluno.model.Aluno;
import com.jvst.api.aluno.repository.AlunoRepository;
import com.jvst.api.usuario.model.Usuario;
import com.jvst.api.usuario.service.UsuarioService;

@Service
public class AlunoService {

	@Autowired
	private AlunoRepository alunoRepository;

	@Autowired
	private UsuarioService usuarioService;

	public Aluno buscarAlunoPorId(Long idAluno) {
		Optional<Aluno> aluno = this.alunoRepository.findById(idAluno);
		if (!aluno.isPresent()) {
			throw new EmptyResultDataAccessException("Usuário não encontrado", 1);
		}
		return aluno.get();
	}

	public Aluno buscarAlunoPorIdUsuario(Long idUsuario) {
		Usuario usuario = this.usuarioService.buscarUsuarioPorId(idUsuario);
		return this.alunoRepository.findByUsuario(usuario);
	}

	public void salvarAluno(Aluno aluno) {
		this.alunoRepository.save(aluno);
	}
}
