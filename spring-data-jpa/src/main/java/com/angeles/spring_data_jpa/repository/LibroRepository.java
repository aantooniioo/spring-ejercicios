package com.angeles.spring_data_jpa.repository;

import com.angeles.spring_data_jpa.entity.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LibroRepository extends JpaRepository<Libro, Integer> {

    // Ejercicio 4
    @Query("SELECT l FROM Libro l WHERE l.anioPublicacion > 2001")
    List<Libro> librosPublicadosDespuesDe2001();


}

