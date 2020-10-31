package com.jvst.api.aula.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.jvst.api.aula.model.Aula;
import com.jvst.api.aula.repository.AulaRepository;
import com.jvst.api.instrutor.model.Instrutor;
import com.jvst.api.instrutor.service.InstrutorService;

@Service
public class AulaService {

	@Autowired
	private AulaRepository aulaRepository;
	
	@Autowired
	private InstrutorService instrutorService;
	
	public Aula buscarAulaPorId(Long idAula) {
		Optional<Aula> aula = this.aulaRepository.findById(idAula);
		if (!aula.isPresent()) {
			throw new EmptyResultDataAccessException("Aula não encontrada", 1);
		}
		return aula.get();
	}
	
	public List<Aula> listarAulaPorIdInstrutor(Long idInstrutor){
		Instrutor instrutor = this.instrutorService.buscarInstrutorPorId(idInstrutor);
		return this.aulaRepository.findByInstrutor(instrutor);
	}
	
	public void salvarAula(Aula aula) {
		this.aulaRepository.save(aula);
	}
}
