package com.angeles.spring_data_jpa.controller;

import com.angeles.spring_data_jpa.entity.Editorial;
import com.angeles.spring_data_jpa.service.EditorialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador REST para gestionar las editoriales
 * Permite realizar operaciones CRUD mediante endpoints
 */
@RestController
@RequestMapping("/editoriales")
public class EditorialController {

    @Autowired
    private EditorialService editorialService;

    /**
     * Obtiene todas las editoriales
     */
    @GetMapping
    public List<Editorial> obtenerTodas(){
        return editorialService.obtenerTodas();
    }

    /**
     * Crea una nueva editorial
     */
    @PostMapping
    public Editorial guardar(@RequestBody Editorial editorial){
        return editorialService.guardar(editorial);
    }

    /**
     * Obtiene una editorial por su ID
     */
    @GetMapping("/{id}")
    public Editorial obtenerPorId(@PathVariable Integer id){
        return editorialService.obtenerPorId(id);
    }

    /**
     * Elimina una editorial por su ID
     */
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id){
        editorialService.eliminar(id);
    }
}
