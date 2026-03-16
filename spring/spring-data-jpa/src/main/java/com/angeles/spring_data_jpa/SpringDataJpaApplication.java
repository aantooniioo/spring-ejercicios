package com.angeles.spring_data_jpa;

import com.angeles.spring_data_jpa.entity.Libro;
import com.angeles.spring_data_jpa.repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringDataJpaApplication implements CommandLineRunner {

	@Autowired
	private LibroRepository libroRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringDataJpaApplication.class, args);

	}

	@Override
	public void run(String... args) {

		System.out.println("Ejercicio 4:");
		libroRepository.librosPublicadosDespuesDe2001()
				.forEach(libro -> System.out.println(libro.getTitulo()));

		System.out.println("\nEjercicio 5:");
		libroRepository.findByAnioPublicacionGreaterThan(2001)
				.forEach(libro -> System.out.println(libro.getTitulo()));

		System.out.println("\nEjercicio 6 - Libros publicados en 2001:");
		libroRepository.findByAnioPublicacion(2001)
				.forEach(libro -> System.out.println(libro.getTitulo()));

		System.out.println("\nEjercicio 6 - Libro con ISBN 87919878:");
		Libro libro = libroRepository.findByIsbn("87919878");
		if (libro != null) {
			System.out.println(libro.getTitulo());
		}

		System.out.println("\nEjercicio 6 - Libros de la editorial RBA:");
		libroRepository.findByIdEditorial(1)
				.forEach(l -> System.out.println(l.getTitulo()));

		System.out.println("\nEjercicio 6 - Libros PLANETA publicados en 1986:");
		libroRepository.findByIdEditorialAndAnioPublicacion(1, 1986)
				.forEach(l -> System.out.println(l.getTitulo()));
	}
}
