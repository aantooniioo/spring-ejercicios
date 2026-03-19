package com.angeles.spring_data_jpa.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "libros")
public class Libro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idLibro;

    @NotBlank
    @Size(max = 255)
    @Column(name = "titulo")
    private String titulo;

    @Size(max = 255)
    @Column(name = "isbn")
    private String isbn;

    @NotNull
    @Column(name = "anioPublicacion")
    private Integer anioPublicacion;

    @Column(name = "idAutor")
    private Integer idAutor;

    @Column(name = "idEditorial")
    private Integer idEditorial;

    @Column(name = "idTematica")
    private Integer idTematica;

    public Libro() {
    }

    public Libro(Integer idLibro, String titulo, String isbn, Integer anioPublicacion,
                 Integer idAutor, Integer idEditorial, Integer idTematica) {
        this.idLibro = idLibro;
        this.titulo = titulo;
        this.isbn = isbn;
        this.anioPublicacion = anioPublicacion;
        this.idAutor = idAutor;
        this.idEditorial = idEditorial;
        this.idTematica = idTematica;
    }

    public Integer getIdLibro() {
        return idLibro;
    }

    public void setIdLibro(Integer idLibro) {
        this.idLibro = idLibro;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Integer getAnioPublicacion() {
        return anioPublicacion;
    }

    public void setAnioPublicacion(Integer anioPublicacion) {
        this.anioPublicacion = anioPublicacion;
    }

    public Integer getIdAutor() {
        return idAutor;
    }

    public void setIdAutor(Integer idAutor) {
        this.idAutor = idAutor;
    }

    public Integer getIdEditorial() {
        return idEditorial;
    }

    public void setIdEditorial(Integer idEditorial) {
        this.idEditorial = idEditorial;
    }

    public Integer getIdTematica() {
        return idTematica;
    }

    public void setIdTematica(Integer idTematica) {
        this.idTematica = idTematica;
    }
}