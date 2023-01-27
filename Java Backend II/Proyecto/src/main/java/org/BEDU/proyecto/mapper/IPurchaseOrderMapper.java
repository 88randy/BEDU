package org.BEDU.proyecto.mapper;

import org.BEDU.proyecto.dto.PurchaseOrderDTO;
import org.BEDU.proyecto.model.PurchaseOrder;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface IPurchaseOrderMapper {
    PurchaseOrderDTO toDTO(PurchaseOrder data);
    PurchaseOrder toEntity(PurchaseOrderDTO data);
}
