package org.BEDU.proyecto.dto;

import org.BEDU.proyecto.model.Product;
import org.BEDU.proyecto.model.PurchaseOrder;

import lombok.Data;

@Data
public class PurchaseOrderItemDTO {
    private Long id;
    private Product product;
    private Integer quantity;
    private PurchaseOrder purchaseOrder;
}
