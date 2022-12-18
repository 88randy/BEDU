package org.BEDU.proyecto.service;

import java.util.List;
import java.util.Optional;

import org.BEDU.proyecto.dto.PurchaseOrderItemDTO;

public interface IPurchaseOrderItemService {
    List<PurchaseOrderItemDTO> findAll();
    Optional<PurchaseOrderItemDTO> findById(Long id);
    PurchaseOrderItemDTO save(PurchaseOrderItemDTO data);
    void update(long id, PurchaseOrderItemDTO data) throws Exception;
    void delete(long id) throws Exception;
}
