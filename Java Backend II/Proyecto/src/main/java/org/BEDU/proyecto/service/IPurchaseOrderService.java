package org.BEDU.proyecto.service;

import java.util.List;
import java.util.Optional;

import org.BEDU.proyecto.dto.PurchaseOrderDTO;

public interface IPurchaseOrderService {
    List<PurchaseOrderDTO> findAll();
    Optional<PurchaseOrderDTO> findById(Long id);
    PurchaseOrderDTO save(PurchaseOrderDTO data);
    void update(long id, PurchaseOrderDTO data) throws Exception;
    void delete(long id) throws Exception;
}
