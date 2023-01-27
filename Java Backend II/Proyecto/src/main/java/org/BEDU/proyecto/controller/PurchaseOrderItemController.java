package org.BEDU.proyecto.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import org.BEDU.proyecto.dto.PurchaseOrderItemDTO;
import org.BEDU.proyecto.service.IPurchaseOrderItemService;


@RestController
@RequestMapping("/purchase-order-items")
public class PurchaseOrderItemController {

    private IPurchaseOrderItemService service;

    @Autowired
    public PurchaseOrderItemController(IPurchaseOrderItemService service) {
        this.service = service;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<PurchaseOrderItemDTO> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public PurchaseOrderItemDTO findById(@PathVariable Long id) {
        Optional<PurchaseOrderItemDTO> product = service.findById(id);
        return product.get();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PurchaseOrderItemDTO save(@RequestBody PurchaseOrderItemDTO data) {
        return service.save(data);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@PathVariable("id") Long id, @RequestBody PurchaseOrderItemDTO data) throws Exception {
        service.update(id, data);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") Long id) throws Exception {
        service.delete(id);
    }
    
}