package org.bedu.sesion08;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    @GetMapping("")
    String welcome (){
        return "Bienvenido a la API";
    }

    @GetMapping("/saludo")
    String saluda(){
        return "Hola API";
    }
}
