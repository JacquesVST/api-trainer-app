package com.jvst.api.imagem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jvst.api.imagem.model.Imagem;

public interface ImagemRepository extends JpaRepository<Imagem, Long> { 

}
