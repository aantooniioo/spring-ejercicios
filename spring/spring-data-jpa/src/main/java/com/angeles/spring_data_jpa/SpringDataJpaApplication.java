package com.angeles.spring_data_jpa;

import com.angeles.spring_data_jpa.entity.Libro;
import com.angeles.spring_data_jpa.repository.LibroRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

/**
 * Clase principal de la aplicación Spring Boot.
 * Implementa CommandLineRunner para ejecutar pruebas de consultas JPA al iniciar.
 */
@SpringBootApplication
public class SpringDataJpaApplication implements CommandLineRunner {

	private static final Logger log = LoggerFactory.getLogger(SpringDataJpaApplication.class);

	@Autowired
	private LibroRepository libroRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringDataJpaApplication.class, args);
	}

	/**
	 * Metodo que se ejecuta al iniciar la aplicación.
	 * Permite probar las consultas del repositorio LibroRepository.
	 */
	@Override
	public void run(String... args) {

		log.info("===== INICIO DE PRUEBAS JPA =====");

		// INSERTAR DATOS DE PRUEBA
		log.info("Insertando libros de prueba...");

		libroRepository.save(new Libro(null, "Libro A", "123", 2000, 1, 1, 1));
		libroRepository.save(new Libro(null, "Libro B", "456", 2005, 1, 1, 1));
		libroRepository.save(new Libro(null, "Libro C", "789", 2010, 1, 1, 1));

		// Mostrar todos los libros
		log.info("Mostrando todos los libros:");
		List<Libro> todos = libroRepository.findAll();
		todos.forEach(libro -> log.info("Libro: {}", libro.getTitulo()));

		// Ejercicio 4 (@Query)
		log.info("Mostrando libros publicados después de 2001 (@Query):");
		List<Libro> despues2001 = libroRepository.librosPublicadosDespuesDe2001();
		despues2001.forEach(libro -> log.info("Libro: {}", libro.getTitulo()));

		// Ejercicio 5 (metodo derivado)
		log.info("Mostrando libros con año > 2001 (método derivado):");
		List<Libro> derivados = libroRepository.findByAnioPublicacionGreaterThan(2001);
		derivados.forEach(libro -> log.info("Libro: {}", libro.getTitulo()));

		// Ejercicio 6
		log.info("Mostrando libros del año 2001:");
		List<Libro> libros2001 = libroRepository.findByAnioPublicacion(2001);
		libros2001.forEach(libro -> log.info("Libro: {}", libro.getTitulo()));

		log.info("===== FIN DE PRUEBAS JPA =====");
	}
}