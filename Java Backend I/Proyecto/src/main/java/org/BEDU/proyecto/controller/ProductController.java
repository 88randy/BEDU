package org.BEDU.proyecto.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import org.BEDU.proyecto.dto.ProductDTO;
import org.BEDU.proyecto.service.IProductService;

@RestController
@RequestMapping("/products")
public class ProductController {
    
    private IProductService service;

    @Autowired
    public ProductController(IProductService service) {
        this.service = service;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ProductDTO> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ProductDTO findById(@PathVariable Long id) {
        Optional<ProductDTO> product = service.findById(id);
        return product.get();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProductDTO save(@RequestBody ProductDTO data) {
        return service.save(data);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@PathVariable("id") Long id, @RequestBody ProductDTO data) throws Exception {
        service.update(id, data);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") Long id) throws Exception {
        service.delete(id);
    }
}