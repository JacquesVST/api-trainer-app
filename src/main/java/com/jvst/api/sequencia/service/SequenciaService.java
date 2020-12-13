package com.jvst.api.sequencia.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.jvst.api.atividade.service.AtividadeService;
import com.jvst.api.aula.model.Aula;
import com.jvst.api.aula.service.AulaService;
import com.jvst.api.sequencia.form.SequenciaForm;
import com.jvst.api.sequencia.model.Sequencia;
import com.jvst.api.sequencia.repository.SequenciaRepository;

@Service
public class SequenciaService {

	@Autowired
	private SequenciaRepository sequenciaRepository;

	@Autowired
	private AulaService aulaService;

	@Autowired
	private AtividadeService atividadeService;

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

	public void cadastrarSequencia(SequenciaForm sequenciaForm) {
		Sequencia sequencia = new Sequencia();
		sequencia.setDescricao(sequenciaForm.getDescricao());
		sequencia.setTempo(sequenciaForm.getTempo());
		sequencia.setRepeticoes(sequenciaForm.getRepeticoes());
		sequencia.setSeries(sequenciaForm.getSeries());
		sequencia.setOrdem(sequenciaForm.getOrdem());
		sequencia.setAtividade(this.atividadeService.buscarAtividadePorId(sequenciaForm.getIdAtividade()));
		sequencia.setAula(this.aulaService.buscarAulaPorId(sequenciaForm.getIdAula()));
        this.sequenciaRepository.save(sequencia);
    }

	public void atualizarSequencia(Long idSequencia, SequenciaForm sequenciaForm) {
		Sequencia sequencia = this.buscarSequenciaPorId(idSequencia);
		sequencia.setDescricao(sequenciaForm.getDescricao());
		sequencia.setTempo(sequenciaForm.getTempo());
		sequencia.setRepeticoes(sequenciaForm.getRepeticoes());
		sequencia.setSeries(sequenciaForm.getSeries());
		sequencia.setOrdem(sequenciaForm.getOrdem());
		sequencia.setAtividade(this.atividadeService.buscarAtividadePorId(sequenciaForm.getIdAtividade()));
		sequencia.setAula(this.aulaService.buscarAulaPorId(sequenciaForm.getIdAula()));
        this.sequenciaRepository.save(sequencia);
    }

}
