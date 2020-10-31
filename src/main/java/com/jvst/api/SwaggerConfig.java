package com.jvst.api;

import java.sql.Timestamp;
import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket productApi() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.jvst.api")).build()
				.tags(
						new Tag("Aluno", "Operações relativas a usuários do tipo aluno"),
						new Tag("Aulas do Aluno", "Operações relativas a relações de alunos e aulas"),
						new Tag("Atividade", "Operações relativas as atividades inclusas nas aulas"),
						new Tag("Tags da Atividade", "Operações relativas a relações de atividades e tags"),
						new Tag("Aula", "Operações relativas as aulas criadas por instrutores"),
						new Tag("Avaliação", "Operações relativas avaliações públicas das aulas publicadas"),
						new Tag("Chat", "Operações relativas a chats entre instrutor e aluno"),
						new Tag("Ficha", "Operações relativas a fichas que serão periódicamente preenchida pelo aluno para analisar progressões"),
						new Tag("Imagem", "Operações relativas as imagens enviadas no sistema"),
						new Tag("Instrutor", "Operações relativas a usuários do tipo instrutor"),
						new Tag("Mensagem", "Operações relativas a mensagens em chats"),
						new Tag("Sequência", "Operações relativas a sequencia que serve de contador e ordenador para uma atividade"),
						new Tag("Sessão", "Operações relativas a sessões que representa uma vez que o aluno praticou uma aula"),
						new Tag("Tag", "Operações relativas as tags usadas para categorizar atividades"),
						new Tag("Usuário", "Operações relativas a qualquer usuário"),
				new Tag("Vídeo", "Operações relativas aos vídeos enviados no sistema"))
				.apiInfo(metaInfo())
				.directModelSubstitute(Timestamp.class, String.class)
				;
	}

	private ApiInfo metaInfo() {
		ApiInfo apiInfo = new ApiInfo("API para aplicativo de personal trainer",
				"Aplicação para sistema de aulas para personal trainer", "0.1", "Java - Spring Framework",
				new Contact("Jacques", "http://t.me/jacquesvst", "jacquesvst@gmail.com"), "Licença Apache 2.0",
				"https://www.apache.org/licenses/LICENSE-2.0", new ArrayList<>());
		return apiInfo;
	}
}
