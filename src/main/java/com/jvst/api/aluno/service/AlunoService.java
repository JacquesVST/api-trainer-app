package com.jvst.api.aluno.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.jvst.api.aluno.form.AlunoForm;
import com.jvst.api.aluno.model.Aluno;
import com.jvst.api.aluno.repository.AlunoRepository;
import com.jvst.api.imagem.service.ImagemService;
import com.jvst.api.usuario.model.Usuario;
import com.jvst.api.usuario.service.UsuarioService;
import com.jvst.api.util.DataUtil;

@Service
public class AlunoService {

	@Autowired
	private AlunoRepository alunoRepository;

	@Autowired
	private UsuarioService usuarioService;

	@Autowired
	private ImagemService imagemService;

	public Aluno buscarAlunoPorId(Long idAluno) {
		Optional<Aluno> aluno = this.alunoRepository.findById(idAluno);
		if (!aluno.isPresent()) {
			throw new EmptyResultDataAccessException("Aluno não encontrado", 1);
		}
		return aluno.get();
	}

	public Aluno buscarAlunoPorIdUsuario(Long idUsuario) {
		Usuario usuario = this.usuarioService.buscarUsuarioPorId(idUsuario);
		return this.alunoRepository.findByUsuario(usuario);
	}

	public void cadastrarAluno(Long idUsuario, AlunoForm alunoForm) {
		Aluno aluno = new Aluno();
		aluno.setDataNascimento(DataUtil.dataStringParaTS(alunoForm.getDataNascimento()));
		aluno.setNumeroContato(alunoForm.getNumeroContato());
		aluno.setLinkUsuario(alunoForm.getLinkUsuario());
		aluno.setImagem(this.imagemService.buscarImagemPorId(alunoForm.getIdImagem()));
		aluno.setUsuario(this.usuarioService.buscarUsuarioPorId(idUsuario));
        this.alunoRepository.save(aluno);
    }

	public void atualizarAluno(Long idAluno, AlunoForm alunoForm) {
		Aluno aluno = this.buscarAlunoPorId(idAluno);
		aluno.setDataNascimento(DataUtil.dataStringParaTS(alunoForm.getDataNascimento()));
		aluno.setNumeroContato(alunoForm.getNumeroContato());
		aluno.setLinkUsuario(alunoForm.getLinkUsuario());
		aluno.setImagem(this.imagemService.buscarImagemPorId(alunoForm.getIdImagem()));
        this.alunoRepository.save(aluno);
    }
}
