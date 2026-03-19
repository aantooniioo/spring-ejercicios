package com.angeles.spring_data_jpa.entity;

import jakarta.persistence.*;

@Entity
@Table(name="autores")
public class Autor {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer idAutor;

    private String nombre;

    private String apellidos;

    public Autor() {
    }

    public Integer getIdAutor() {
        return idAutor;
    }

    public void setIdAutor(Integer idAutor) {
        this.idAutor = idAutor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
}