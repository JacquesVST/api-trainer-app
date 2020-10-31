package com.jvst.api.atividade.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.jvst.api.atividade.model.Atividade;
import com.jvst.api.atividade.repository.AtividadeRepository;
import com.jvst.api.instrutor.model.Instrutor;
import com.jvst.api.instrutor.service.InstrutorService;

@Service
public class AtividadeService {

	@Autowired
	private AtividadeRepository atividadeRepository;
	
	@Autowired
	private InstrutorService instrutorService;
	
	public Atividade buscarAtividadePorId(Long idAtividade) {
		Optional<Atividade> atividade = this.atividadeRepository.findById(idAtividade);
		if (!atividade.isPresent()) {
			throw new EmptyResultDataAccessException("Atividade não encontrada", 1);
		}
		return atividade.get();
	}
	
	public List<Atividade> listarAtividadePorIdInstrutor(Long idInstrutor){
		Instrutor instrutor = this.instrutorService.buscarInstrutorPorId(idInstrutor);
		return this.atividadeRepository.findByInstrutor(instrutor);
	}
	
	public void salvarAtividade(Atividade atividade) {
		this.atividadeRepository.save(atividade);
	}
}
