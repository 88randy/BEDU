package com.BEDU.postwork.model;

public class ActualizarCurso {
    private long id;
    private String nombre;

    public ActualizarCurso(){

    }
    public ActualizarCurso(long id, String nombre){
        this();
        this.id = id;
        this.nombre = nombre;
    }

    public long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

}
