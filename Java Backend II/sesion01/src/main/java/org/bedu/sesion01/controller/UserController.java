package org.bedu.sesion01.controller;

import org.bedu.sesion01.model.Address;
import org.bedu.sesion01.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLOutput;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    @PostMapping(params = {"id", "rol"})
    public ResponseEntity<User> createUser(@RequestBody User user, Long id, String rol){
        // 127.0.0.1:8080/api/v1/user/?id=156&rol=Administrador
        System.out.println("Creando usuario");
        System.out.println("Nombre: " + user.getName());
        System.out.println("Apellido: " + user.getLastname());
        System.out.println("Correo: " + user.getEmail());
        System.out.println("Usuario: " + user.getUsername());
        System.out.println("Rol: " + rol);

        Address address = new Address();

        address.setStreet("Córdoba");
        address.setNumber("56");
        address.setCp("06700");

        user.setAddress(address);

        return ResponseEntity.ok(user);
    }
}
