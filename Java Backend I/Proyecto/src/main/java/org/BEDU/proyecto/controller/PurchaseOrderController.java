package org.BEDU.proyecto.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import org.BEDU.proyecto.dto.PurchaseOrderDTO;
import org.BEDU.proyecto.service.IPurchaseOrderService;


@RestController
@RequestMapping("/purchase-orders")
public class PurchaseOrderController {

    private IPurchaseOrderService service;

    @Autowired
    public PurchaseOrderController(IPurchaseOrderService service) {
        this.service = service;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<PurchaseOrderDTO> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public PurchaseOrderDTO findById(@PathVariable Long id) {
        Optional<PurchaseOrderDTO> product = service.findById(id);
        return product.get();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PurchaseOrderDTO save(@RequestBody PurchaseOrderDTO data) {
        return service.save(data);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@PathVariable("id") Long id, @RequestBody PurchaseOrderDTO data) throws Exception {
        service.update(id, data);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") Long id) throws Exception {
        service.delete(id);
    }
    
}