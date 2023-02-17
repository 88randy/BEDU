package org.bedu.proyectofinal.controllers;

import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = {"*"}, maxAge = 3600)
@RestController
@RequestMapping("/")
public class IndexController {

    @GetMapping
    public String index(){
        return "Bienvenido a mi aplicación de ordenes de compra!";
    }
}