package com.jvst.api.atividadeTag.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jvst.api.atividade.model.Atividade;
import com.jvst.api.atividadeTag.model.AtividadeTag;
import com.jvst.api.tag.model.Tag;

public interface AtividadeTagRepository extends JpaRepository<AtividadeTag, Long>{

	public List<AtividadeTag> findByAtividade(Atividade atividade);
	
	public List<AtividadeTag> findByTag(Tag tag);
}
