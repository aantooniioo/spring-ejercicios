package com.angeles.spring_data_jpa.controller;

import com.angeles.spring_data_jpa.entity.Autor;
import com.angeles.spring_data_jpa.service.AutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador REST para gestionar autores
 */
@RestController
@RequestMapping("/autores")
public class AutorController {

    @Autowired
    private AutorService autorService;

    /**
     * Obtener todos los autores
     */
    @GetMapping
    public List<Autor> getAll(){
        return autorService.getAll();
    }

    /**
     * Obtener autor por ID
     */
    @GetMapping("/{id}")
    public Autor getById(@PathVariable Integer id){
        return autorService.getById(id);
    }

    /**
     * Crear autor
     */
    @PostMapping
    public Autor create(@RequestBody Autor autor){
        return autorService.save(autor);
    }

    /**
     * Actualizar autor
     */
    @PutMapping("/{id}")
    public Autor update(@PathVariable Integer id, @RequestBody Autor autor){
        autor.setIdAutor(id);
        return autorService.save(autor);
    }

    /**
     * Eliminar autor
     */
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){
        autorService.delete(id);
    }
}
