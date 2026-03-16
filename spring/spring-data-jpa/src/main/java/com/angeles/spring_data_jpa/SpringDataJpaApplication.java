package com.angeles.spring_data_jpa;

import com.angeles.spring_data_jpa.repository.LibroRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringDataJpaApplication implements CommandLineRunner {

	private static final Logger log = LoggerFactory.getLogger(SpringDataJpaApplication.class);

	@Autowired
	private LibroRepository libroRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringDataJpaApplication.class, args);
	}

	@Override
	public void run(String... args) {

		log.info("Mostrando todos los libros de la base de datos");

		libroRepository.findAll()
				.forEach(libro -> log.info(libro.getTitulo()));

		log.info("Mostrando libros publicados después de 2001");

		libroRepository.librosPublicadosDespuesDe2001()
				.forEach(libro -> log.info(libro.getTitulo()));

	}
}