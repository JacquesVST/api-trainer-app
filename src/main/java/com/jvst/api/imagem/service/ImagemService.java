package com.jvst.api.imagem.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.jvst.api.imagem.model.Imagem;
import com.jvst.api.imagem.repository.ImagemRepository;

@Service
public class ImagemService {

	@Autowired
	private ImagemRepository imagemRepository;
	
	public Imagem buscarImagemPorId(Long idImagem) {
		Optional<Imagem> imagem = this.imagemRepository.findById(idImagem);
		if (!imagem.isPresent()) {
			throw new EmptyResultDataAccessException("Imagem não encontrada", 1);
		}
		return imagem.get();
	}
	
	public void salvarImagem(Imagem imagem) {
		this.imagemRepository.save(imagem);
	}
}
