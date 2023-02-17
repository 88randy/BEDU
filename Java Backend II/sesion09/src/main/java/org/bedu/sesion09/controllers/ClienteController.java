package org.bedu.sesion09.controllers;

import lombok.AllArgsConstructor;
import org.bedu.sesion09.models.Cliente;
import org.bedu.sesion09.repository.ClienteRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/clientes")
@AllArgsConstructor
public class ClienteController {

    private final ClienteRepository clienteRepository;

    @GetMapping
    public List<Cliente> listaClientes(){
        return clienteRepository.findAll();
    }
}
