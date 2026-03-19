package com.angeles.spring_data_jpa.service;

import com.angeles.spring_data_jpa.entity.Tematica;
import com.angeles.spring_data_jpa.repository.TematicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Servicio encargado de la lógica de negocio de Tematica
 */
@Service
public class TematicaService {

    @Autowired
    private TematicaRepository tematicaRepository;

    /**
     * Obtiene todas las temáticas
     */
    public List<Tematica> obtenerTodas() {
        return tematicaRepository.findAll();
    }

    /**
     * Guarda una nueva temática
     */
    public Tematica guardar(Tematica tematica) {
        return tematicaRepository.save(tematica);
    }

    /**
     * Obtiene una temática por su ID
     */
    public Tematica obtenerPorId(Integer id) {
        return tematicaRepository.findById(id).orElse(null);
    }

    /**
     * Elimina una temática por su ID
     */
    public void eliminar(Integer id) {
        tematicaRepository.deleteById(id);
    }
}
