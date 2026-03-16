package com.angeles.spring_data_jpa.repository;

import com.angeles.spring_data_jpa.entity.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Repository para gestionar operaciones sobre la entidad Libro.
 */
public interface LibroRepository extends JpaRepository<Libro, Integer> {

    // Ejercicio 4
    /**
     * Devuelve los libros publicados después del año 2001.
     */
    @Query("SELECT l FROM Libro l WHERE l.anioPublicacion > 2001")
    List<Libro> librosPublicadosDespuesDe2001();

    // Ejercicio 5
    /**
     * Metodo derivado que busca libros publicados después de un año determinado.
     */
    List<Libro> findByAnioPublicacionGreaterThan(Integer anio);

    // Ejercicio 6
    List<Libro> findByAnioPublicacion(Integer anio);

    Libro findByIsbn(String isbn);

    List<Libro> findByIdEditorial(Integer idEditorial);

    List<Libro> findByIdEditorialAndAnioPublicacion(Integer editorial, Integer anio);

}