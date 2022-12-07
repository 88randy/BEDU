package com.BEDU.postwork.model;

import com.fasterxml.jackson.annotation.JsonCreator;

public class CrearCurso {
    private String nombre;

    public CrearCurso(){

    }

    public CrearCurso(String nombre){
        this();
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}