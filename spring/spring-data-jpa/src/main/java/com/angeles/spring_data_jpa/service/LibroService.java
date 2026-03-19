package com.angeles.spring_data_jpa.service;

import com.angeles.spring_data_jpa.entity.Libro;
import com.angeles.spring_data_jpa.repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Servicio encargado de la lógica de negocio relacionada con los libros
 */
 @Service
public class LibroService {

     @Autowired
     private LibroRepository libroRepository;

    /**
     * Obtiene todos los libros
     */
    public List<Libro> getAllLibros() {
        return libroRepository.findAll();
    }

    /**
     * Obtiene un libro por su ID
     */
    public Libro getLibroById(Integer id) {
        return libroRepository.findById(id).orElse(null);
    }

    /**
     * Guarda un libro en la base de datos
     */
    public Libro save(Libro libro) {
        return libroRepository.save(libro);
    }

    /**
     * Elimina un libro por ID
     */
    public void delete(Integer id) {
        libroRepository.deleteById(id);
    }

    // Metodos del ejercicio

    // Ejercicio 4 (@Query)
    public List<Libro> getLibrosDespuesDe2001() {
        return libroRepository.librosPublicadosDespuesDe2001();
    }

    // Ejercicio 5 (Metodo derivado)
    public List<Libro> getLibrosPorAnioMayor(Integer anio) {
        return libroRepository.findByAnioPublicacionGreaterThan(anio);
    }

    //  =====================
    // EJERCICIO 6 (DOBLE: Derivado + @Query)
    //  =====================

    /**
     * Ejercicio 6 - 1:
     * Libros del año exacto (Derivado)
     */
    public List<Libro> getLibrosPorAnio(Integer anio) {
        return libroRepository.findByAnioPublicacion(anio);
    }

    /**
     * Ejercicio 6 - 1:
     * Libros del año exacto (@Query)
     */
    public List<Libro> getLibrosPorAnioQuery(Integer anio) {
        return libroRepository.librosPorAnio(anio);
    }

    /**
     * Ejercicio 6 - 2:
     * Libro por ISBN (Derivado)
     */
    public Libro getLibroPorIsbn(String isbn) {
        return libroRepository.findByIsbn(isbn);
    }

    /**
     * Ejercicio 6 - 2:
     * Libro por ISBN (@Query)
     */
    public Libro getLibroPorIsbnQuery(String isbn) {
        return libroRepository.libroPorIsbn(isbn);
    }

    /**
     * Ejercicio 6 - 3
     * Libros por editorial (Derivado)
     */
    public List<Libro> getLibrosPorEditorial(Integer idEditorial) {
        return libroRepository.findByIdEditorial(idEditorial);
    }

    /**
     * Ejercicio 6 - 3
     * Libros por editorial (@Query)
     */
    public List<Libro> getLibrosPorEditorialQuery(Integer idEditorial) {
        return libroRepository.librosPorEditorial(idEditorial);
    }

    /**
     * Ejercicio 6 - 4
     * Libros por editorial y año (Derivado)
     */
    public List<Libro> getLibrosPorEditorialYAnio(Integer editorial, Integer anio) {
        return libroRepository.findByIdEditorialAndAnioPublicacion(editorial, anio);
    }

    /**
     * Ejercicio 6 - 4
     * Libros por editorial y año (@Query)
     */
    public List<Libro> getLibrosPorEditorialYAnioQuery(Integer editorial, Integer anio) {
        return libroRepository.librosPorEditorialYAnio(editorial, anio);
    }
}
