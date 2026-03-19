package com.angeles.spring_data_jpa.service;

import com.angeles.spring_data_jpa.entity.Editorial;
import com.angeles.spring_data_jpa.repository.EditorialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Servicio encargado de la lógica de negocio de Editorial.
 * Permite obtener, guardar y eliminar editoriales.
 */
@Service
public class EditorialService {

    @Autowired
    private EditorialRepository editorialRepository;

    /**
     * Obtiene todas las editoriales.
     */
    public List<Editorial> obtenerTodas() {
        return editorialRepository.findAll();
    }

    /**
     * Guarda una nueva editorial.
     */
    public Editorial guardar(Editorial editorial) {
        return editorialRepository.save(editorial);
    }

    /**
     * Obtiene una editorial por su ID.
     */
    public Editorial obtenerPorId(Integer id) {
        return editorialRepository.findById(id).orElse(null);
    }

    /**
     * Elimina una editorial por su ID.
     */
    public void eliminar(Integer id) {
        editorialRepository.deleteById(id);
    }
}