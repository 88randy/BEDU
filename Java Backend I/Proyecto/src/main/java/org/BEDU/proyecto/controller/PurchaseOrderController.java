package org.BEDU.proyecto.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.server.ResponseStatusException;

import org.BEDU.proyecto.model.PurchaseOrder;
import org.BEDU.proyecto.service.IPurchaseOrderService;


@RestController
@RequestMapping("/purchase-orders")
public class PurchaseOrderController {

    @Autowired
    private IPurchaseOrderService purchaseOrderService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<PurchaseOrder> findAll() {
        return purchaseOrderService.getAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public PurchaseOrder findById(@PathVariable Long id) {
        Optional<PurchaseOrder> purchaseOrder = purchaseOrderService.findById(id);
        if (!purchaseOrder.isPresent()) {
            throw new RuntimeException("Orden de compra no encontrada");
        }
        return purchaseOrder.get();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody PurchaseOrder purchaseOrder) {
        purchaseOrderService.save(purchaseOrder);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void update(@PathVariable Long id, @RequestBody PurchaseOrder purchaseOrder) {
        purchaseOrder.setId(id);
        purchaseOrderService.save(purchaseOrder);
    }
    
}