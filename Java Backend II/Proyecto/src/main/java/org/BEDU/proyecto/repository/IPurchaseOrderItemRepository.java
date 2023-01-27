package org.BEDU.proyecto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import org.BEDU.proyecto.model.PurchaseOrderItem;

@Repository
public interface IPurchaseOrderItemRepository extends JpaRepository<PurchaseOrderItem, Long>{
    
}
