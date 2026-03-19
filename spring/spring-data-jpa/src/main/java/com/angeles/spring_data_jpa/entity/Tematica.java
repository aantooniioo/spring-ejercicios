package com.angeles.spring_data_jpa.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "tematicas")
public class Tematica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idTematica;

    private String categoria;

    public Tematica() {
    }

    public Integer getIdTematica() {
        return idTematica;
    }

    public void setIdTematica(Integer idTematica) {
        this.idTematica = idTematica;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
}