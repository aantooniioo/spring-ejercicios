package com.angeles.spring_data_jpa.controller;

import com.angeles.spring_data_jpa.entity.Libro;
import com.angeles.spring_data_jpa.service.LibroService;
import jakarta.persistence.SqlResultSetMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador REST para gestionar operaciones sobre libros
 */
@RestController
@RequestMapping("/libros")
public class LibroController {

    @Autowired
    private LibroService libroService;

    // CRUD

    @GetMapping
    public List<Libro> getAll() {
        return libroService.getAllLibros();
    }

    @GetMapping("/{id}")
    public Libro getById(@PathVariable Integer id) {
        return libroService.getLibroById(id);
    }

    @PostMapping
    public Libro create(@RequestBody Libro libro) {
        return libroService.save(libro);
    }

    @PutMapping("/{id}")
    public Libro update(@PathVariable Integer id, @RequestBody Libro libro) {
        libro.setIdLibro(id);
        return libroService.save(libro);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        libroService.delete(id);
    }

    // EJERCICIOS

    @GetMapping("/despues-2001")
    public List<Libro> despues2001() {
        return libroService.getLibrosDespuesDe2001();
    }

    @GetMapping("/anio/{anio}")
    public List<Libro> porAnio(@PathVariable Integer anio) {
        return libroService.getLibrosPorAnio(anio);
    }

    @GetMapping("/isbn/{isbn}")
    public Libro porIsbn(@PathVariable String isbn) {

        Libro libro = libroService.getLibroPorIsbn(isbn);
        if (libro == null) {
            throw new RuntimeException("Libro no encontrado con ISBN: " + isbn);
        }

        return libro;
    }

    @GetMapping("/editorial/{ideditorial}")
    public List<Libro> porEditorial(@PathVariable Integer ideditorial) {
        return libroService.getLibrosPorEditorial(ideditorial);
    }

    @GetMapping("/editorial/{ideditorial}/anio/{anio}")
    public List<Libro> porEditorialYAnio(@PathVariable Integer ideditorial,
                                         @PathVariable Integer anio) {
        return libroService.getLibrosPorEditorialYAnio(ideditorial, anio);
    }
}
