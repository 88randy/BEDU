package com.example.demo02.model;

import com.fasterxml.jackson.annotation.JsonCreator;

public class CrearCurso {
    private String nombre;

    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public CrearCurso(String nombre){
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
