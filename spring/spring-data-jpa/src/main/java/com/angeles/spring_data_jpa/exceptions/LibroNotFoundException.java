package com.angeles.spring_data_jpa.exceptions;

public class LibroNotFoundException  extends RuntimeException {

    public LibroNotFoundException(String mensaje) {
        super(mensaje);
    }
}