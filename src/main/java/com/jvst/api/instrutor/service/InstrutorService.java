package com.jvst.api.instrutor.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.jvst.api.imagem.service.ImagemService;
import com.jvst.api.instrutor.form.InstrutorForm;
import com.jvst.api.instrutor.model.Instrutor;
import com.jvst.api.instrutor.repository.InstrutorRepository;
import com.jvst.api.usuario.model.Usuario;
import com.jvst.api.usuario.service.UsuarioService;
import com.jvst.api.util.DataUtil;

@Service
public class InstrutorService {

	@Autowired
	private InstrutorRepository instrutorRepository;

	@Autowired
	private UsuarioService usuarioService;

	@Autowired
	private ImagemService imagemService;

	public List<Instrutor> listarInstrutores() {
		return this.instrutorRepository.findAll();
	}

	public Instrutor buscarInstrutorPorId(Long idInstrutor) {
		Optional<Instrutor> instrutor = this.instrutorRepository.findById(idInstrutor);
		if (!instrutor.isPresent()) {
			throw new EmptyResultDataAccessException("Instrutor não encontrado", 1);
		}
		return instrutor.get();
	}

	public Instrutor buscarInstrutorPorIdUsuario(Long idUsuario) {
		Usuario usuario = this.usuarioService.buscarUsuarioPorId(idUsuario);
		return this.instrutorRepository.findByUsuario(usuario);
	}

	public void cadastrarInstrutor(Long idUsuario, InstrutorForm instrutorForm) {
		Instrutor instrutor = new Instrutor();
		instrutor.setDataNascimento(DataUtil.dataStringParaTS(instrutorForm.getDataNascimento()));
		instrutor.setNumeroContato(instrutorForm.getNumeroContato());
		instrutor.setEmailContato(instrutorForm.getEmailContato());
		instrutor.setLinkUsuario(instrutorForm.getLinkUsuario());
		instrutor.setImagem(this.imagemService.buscarImagemPorId(instrutorForm.getIdImagem()));
		instrutor.setUsuario(this.usuarioService.buscarUsuarioPorId(idUsuario));
		this.instrutorRepository.save(instrutor);
	}

	public void atualizarInstrutor(Long idInstrutor, InstrutorForm instrutorForm) {
		Instrutor instrutor = this.buscarInstrutorPorId(idInstrutor);
		instrutor.setDataNascimento(DataUtil.dataStringParaTS(instrutorForm.getDataNascimento()));
		instrutor.setNumeroContato(instrutorForm.getNumeroContato());
		instrutor.setEmailContato(instrutorForm.getEmailContato());
		instrutor.setLinkUsuario(instrutorForm.getLinkUsuario());
		instrutor.setImagem(this.imagemService.buscarImagemPorId(instrutorForm.getIdImagem()));
		this.instrutorRepository.save(instrutor);
	}
}