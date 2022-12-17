package org.BEDU.proyecto.service;

import java.util.List;
import java.util.Optional;

import org.BEDU.proyecto.model.PurchaseOrder;

public interface IPurchaseOrderService {
    List<PurchaseOrder> getAll();
    
    Optional<PurchaseOrder> findById(Long id);

    PurchaseOrder create(PurchaseOrder data);

    PurchaseOrder save(PurchaseOrder data);
}
