package org.BEDU.proyecto.mapper;

import org.BEDU.proyecto.dto.ProductDTO;
import org.BEDU.proyecto.model.Product;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface IProductMapper {
    ProductDTO toDTO(Product data);
    Product toEntity(ProductDTO data);
}
