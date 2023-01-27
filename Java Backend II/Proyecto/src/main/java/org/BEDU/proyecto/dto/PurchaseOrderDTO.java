package org.BEDU.proyecto.dto;

import java.time.LocalDateTime;
import java.util.Set;

import org.BEDU.proyecto.model.Customer;
import org.BEDU.proyecto.model.PurchaseOrderItem;

import lombok.Data;

@Data
public class PurchaseOrderDTO {
    private Long id;
    private LocalDateTime date;
    private Customer customer;
    private Set<PurchaseOrderItem> items;
}
