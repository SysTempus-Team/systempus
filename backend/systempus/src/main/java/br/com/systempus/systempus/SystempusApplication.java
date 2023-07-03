
package br.com.systempus.systempus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
import io.swagger.v3.oas.annotations.tags.Tag;


@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Systempus API", version = "1.0.0"),
servers = {@Server(url = "http://localhost:8080"), @Server(url = "https://systempus.up.railway.app/")},
tags = {@Tag(name = "Coordenador", description = "Descrição"), @Tag(name = "Professor", description = "TesteProfessor")}

)
public class SystempusApplication {

	public static void main(String[] args) {
		SpringApplication.run(SystempusApplication.class, args);
	}
}