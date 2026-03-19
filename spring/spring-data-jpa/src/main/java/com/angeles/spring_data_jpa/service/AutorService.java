package com.angeles.spring_data_jpa.service;

import com.angeles.spring_data_jpa.entity.Autor;
import com.angeles.spring_data_jpa.entity.Libro;
import com.angeles.spring_data_jpa.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Servicio encargado de la lógica de negoco de Autor
 */
@Service
public class AutorService {

    @Autowired
    private AutorRepository autorRepository;

    /**
     * Obtener todos los autores
     */
    public List<Autor> getAll() {
        return autorRepository.findAll();
    }

    /**
     * Obtener autor por ID
     */
    public Autor getById(Integer id) {
        return autorRepository.findById(id).orElse(null);
    }

    /**
     * Guardar autor
     */
    public Autor save(Autor autor) {
        return autorRepository.save(autor);
    }

    /**
     * Eliminar autor
     */
    public void delete(Integer id) {
        autorRepository.deleteById(id);
    }
}
