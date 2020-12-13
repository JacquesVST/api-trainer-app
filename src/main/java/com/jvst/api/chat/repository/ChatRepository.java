package com.jvst.api.chat.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jvst.api.aluno.model.Aluno;
import com.jvst.api.chat.model.Chat;
import com.jvst.api.instrutor.model.Instrutor;

public interface ChatRepository extends JpaRepository<Chat, Long>{
	
	List<Chat> findByInstrutor(Instrutor instrutor);

	List<Chat> findByAluno(Aluno aluno);
	
}
