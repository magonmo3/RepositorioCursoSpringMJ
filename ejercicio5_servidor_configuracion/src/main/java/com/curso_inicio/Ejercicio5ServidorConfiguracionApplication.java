package com.curso_inicio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@SpringBootApplication
public class Ejercicio5ServidorConfiguracionApplication {

	public static void main(String[] args) {
		SpringApplication.run(Ejercicio5ServidorConfiguracionApplication.class, args);
	}

}
