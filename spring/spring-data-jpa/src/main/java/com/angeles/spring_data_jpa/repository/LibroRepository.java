package com.angeles.spring_data_jpa.repository;

import com.angeles.spring_data_jpa.entity.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Repository para gestionar operaciones sobre la entidad Libro.
 */
public interface LibroRepository extends JpaRepository<Libro, Integer> {

    // =========================
    // EJERCICIO 4
    // =========================

    /**
     * Devuelve los libros publicados después del año 2001.
     */
    @Query("SELECT l FROM Libro l WHERE l.anioPublicacion > 2001")
    List<Libro> librosPublicadosDespuesDe2001();

    // =========================
    // EJERCICIO 5 (DERIVADO)
    // =========================

    /**
     * Metodo derivado que busca libros publicados después de un año determinado.
     */
    List<Libro> findByAnioPublicacionGreaterThan(Integer anio);

    // =========================
    // EJERCICIO 6
    // =========================

    // 6.1 - AÑO

    // Derivado
    List<Libro> findByAnioPublicacion(Integer anio);

    // @Query
    @Query("SELECT l FROM Libro l WHERE l.anioPublicacion = :anio")
    List<Libro> librosPorAnio(@Param("anio") Integer anio);

    // 6.2 - ISBN

    // Derivado
    Libro findByIsbn(String isbn);

    // @Query
    @Query("SELECT l FROM Libro l WHERE l.isbn = :isbn")
    Libro libroPorIsbn(@Param("isbn") String isbn);

    // 6.3 - EDITORIAL

    // Derivado
    List<Libro> findByIdEditorial(Integer idEditorial);

    // @Query
    @Query("SELECT l FROM Libro l WHERE l.idEditorial = :idEditorial")
    List<Libro> librosPorEditorial(@Param("idEditorial") Integer idEditorial);

    // 6.4 - EDITORIAL + AÑO

    // Derivado
    List<Libro> findByIdEditorialAndAnioPublicacion(Integer editorial, Integer anio);

    // @Query
    @Query("SELECT l FROM Libro l WHERE l.idEditorial = :editorial AND l.anioPublicacion = :anio")
    List<Libro> librosPorEditorialYAnio(@Param("editorial") Integer editorial,
                                        @Param("anio") Integer anio);
}