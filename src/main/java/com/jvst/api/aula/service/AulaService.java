package com.jvst.api.aula.service;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.jvst.api.aula.form.AulaForm;
import com.jvst.api.aula.model.Aula;
import com.jvst.api.aula.repository.AulaRepository;
import com.jvst.api.imagem.service.ImagemService;
import com.jvst.api.instrutor.model.Instrutor;
import com.jvst.api.instrutor.service.InstrutorService;

@Service
public class AulaService {

	@Autowired
	private AulaRepository aulaRepository;

	@Autowired
	private InstrutorService instrutorService;

	@Autowired
	private ImagemService imagemService;

	public Aula buscarAulaPorId(Long idAula) {
		Optional<Aula> aula = this.aulaRepository.findById(idAula);
		if (!aula.isPresent()) {
			throw new EmptyResultDataAccessException("Aula não encontrada", 1);
		}
		return aula.get();
	}

	public List<Aula> listarAulaPorIdInstrutor(Long idInstrutor) {
		Instrutor instrutor = this.instrutorService.buscarInstrutorPorId(idInstrutor);
		return this.aulaRepository.findByInstrutor(instrutor);
	}

	public Aula cadastrarAula(AulaForm aulaForm) {
		Aula aula = new Aula();
		aula.setDataCadastro(Timestamp.from(Instant.now()));
		aula.setDescricao(aulaForm.getDescricao());
		aula.setTitulo(aulaForm.getTitulo());
		aula.setPrivado(aulaForm.getPrivado());
		aula.setInstrutor(instrutorService.buscarInstrutorPorId(aulaForm.getIdInstrutor()));
		aula.setImagem(imagemService.buscarImagemPorId(aulaForm.getIdImagem()));
		return this.aulaRepository.save(aula);
	}

	public Aula atualizarAula(Long idAula, AulaForm aulaForm) {
		Aula aula = this.buscarAulaPorId(idAula);
		aula.setDescricao(aulaForm.getDescricao());
		aula.setTitulo(aulaForm.getTitulo());
		aula.setPrivado(aulaForm.getPrivado());
		aula.setInstrutor(instrutorService.buscarInstrutorPorId(aulaForm.getIdInstrutor()));
		aula.setImagem(imagemService.buscarImagemPorId(aulaForm.getIdImagem()));
		return this.aulaRepository.save(aula);
	}

	public Aula alterarAcessoAula(Long idAula) {
		Aula aula = this.buscarAulaPorId(idAula);
		aula.setPrivado(!aula.getPrivado());
		return this.aulaRepository.save(aula);
	}
}
