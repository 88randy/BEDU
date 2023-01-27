package org.BEDU.proyecto.mapper;

import org.BEDU.proyecto.dto.PurchaseOrderItemDTO;
import org.BEDU.proyecto.model.PurchaseOrderItem;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface IPurchaseOrderItemMapper {
    PurchaseOrderItemDTO toDTO(PurchaseOrderItem data);
    PurchaseOrderItem toEntity(PurchaseOrderItemDTO data);
}
