package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class OpenApiConfig {
	
	@Bean
	public OpenAPI customOpenApi() {
		return new OpenAPI()
			.info(new Info()
			.title("Autenticação e Autorização")
			.version("v1")
			.description("API desenvolvida para estudos de Autenticação e Autorização utilizando JWT")
			.termsOfService("ParkMe API - Todos os direitos reservados")
			.license(new License().name("Apache 2.0").url("https://github")));
	}
	
}
