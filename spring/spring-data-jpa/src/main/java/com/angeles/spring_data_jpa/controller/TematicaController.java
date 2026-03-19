package com.angeles.spring_data_jpa.controller;

import com.angeles.spring_data_jpa.entity.Tematica;
import com.angeles.spring_data_jpa.service.TematicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador REST para gestionar las temáticas
 */
@RestController
@RequestMapping("/tematicas")
public class TematicaController {

    @Autowired
    private TematicaService tematicaService;

    /**
     * Obtiene todas las temáticas
     */
    @GetMapping
    public List<Tematica> obtenerTodas() {
        return tematicaService.obtenerTodas();
    }

    /**
     * Crea una nueva temática
     */
    @PostMapping
    public Tematica guardar(@RequestBody Tematica tematica) {
        return tematicaService.guardar(tematica);
    }

    /**
     * Obtiene una temática por su ID
     */
    @GetMapping("/{id}")
    public Tematica obtenerPorId(@PathVariable Integer id) {
        return tematicaService.obtenerPorId(id);
    }

    /**
     * Elimina una temática
     */
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id) {
        tematicaService.eliminar(id);
    }
}
