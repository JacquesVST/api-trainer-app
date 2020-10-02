package com.jvst.api;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket productApi() {
		return new Docket(DocumentationType.SPRING_WEB).select()
				.apis(RequestHandlerSelectors.basePackage("com.jvst.api")).build().apiInfo(metaInfo());
	}

	private ApiInfo metaInfo() {
		ApiInfo apiInfo = new ApiInfo("API para aplicativo de personal trainer",
				"Aplicação para sistema de aulas para personal trainer", "0.1", "Java - Spring Framework",
				new Contact("Jacques", "http://t.me/jacquesvst", "jacquesvst@gmail.com"), "Licença Apache 2.0",
				"https://www.apache.org/licenses/LICENSE-2.0", new ArrayList<>());
		return apiInfo;
	}
}
