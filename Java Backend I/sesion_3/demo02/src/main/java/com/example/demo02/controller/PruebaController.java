package com.example.demo02.controller;


import com.example.demo02.model.Curso;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/prueba")
public class PruebaController {

    @GetMapping("/hello")
    public String helloWorld(){
        return "Hello World";
    }

    @GetMapping("/goodbye")
    public String goodBye(){
        return "Good Bye!";
    }

    @GetMapping("/curso")
    public Curso enviarCurso(){
        return new Curso(100l, "Backend con Java 1");
    }
}
