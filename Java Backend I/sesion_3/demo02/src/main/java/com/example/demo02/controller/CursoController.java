package com.example.demo02.controller;

import com.example.demo02.model.Curso;
import com.example.demo02.model.CrearCurso;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.List;

@RestController
public class CursoController {
    private List<Curso> cursos;
    private long ultimoID = 102;

    public CursoController(){
        cursos = new LinkedList<>();
        cursos.add(new Curso(100l, "Full Stack Java"));
        cursos.add(new Curso(101l, "Full Stack JavaScript"));
        cursos.add(new Curso(102l, "Full Stack Python"));
    }

    @GetMapping("/obtenerCursos")
    public List<Curso> obtenerCursos(){
        return cursos;
    }

    @GetMapping("/obtenerCurso/{id}")
    public Curso obtenerCurso(@PathVariable long id){
        for(Curso c : cursos){
            if(c.getId() == id){
                return c;
            }
        }
        return null;

        // return cursos.stream().filter(curso -> curso.getId() == id).findFirst().orElse(null);
    }

    @PostMapping("/crearCurso")
    public Curso crearCurso(@RequestBody CrearCurso data){
        Curso nuevo = new Curso(++ultimoID, data.getNombre());
        cursos.add(nuevo);
        return nuevo;
    }

}
