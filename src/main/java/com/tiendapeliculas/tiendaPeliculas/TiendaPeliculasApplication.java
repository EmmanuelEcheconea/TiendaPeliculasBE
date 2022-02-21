package com.tiendapeliculas.tiendaPeliculas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan("com.tiendapeliculas.*")
@EntityScan("com.tiendapeliculas.tiendaPeliculas.model")
@EnableJpaRepositories("com.tiendapeliculas.tiendaPeliculas.data")
public class TiendaPeliculasApplication {

	public static void main(String[] args) {
		SpringApplication.run(TiendaPeliculasApplication.class, args);
	}

}
