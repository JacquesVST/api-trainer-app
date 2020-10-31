package com.jvst.api.sequencia.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.jvst.api.aula.model.Aula;
import com.jvst.api.aula.service.AulaService;
import com.jvst.api.sequencia.model.Sequencia;
import com.jvst.api.sequencia.repository.SequenciaRepository;

@Service
public class SequenciaService {

	@Autowired
	private SequenciaRepository sequenciaRepository;
	
	@Autowired
	private AulaService aulaService;
	
	public Sequencia buscarSequenciaPorId(Long idSequencia) {
		Optional<Sequencia> sequencia = this.sequenciaRepository.findById(idSequencia);
		if (!sequencia.isPresent()) {
			throw new EmptyResultDataAccessException("Sequência não encontrada", 1);
		}
		return sequencia.get();
	}

	public List<Sequencia> listarSequenciaPorIdAula(Long idAula) {
		Aula aula = this.aulaService.buscarAulaPorId(idAula);
		return this.sequenciaRepository.findByAula(aula);
	}

	public void salvarSequencia(Sequencia sequencia) {
		this.sequenciaRepository.save(sequencia);
	}
}
