package org.BEDU.proyecto.mapper;

import org.BEDU.proyecto.dto.CustomerDTO;
import org.BEDU.proyecto.model.Customer;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface ICustomerMapper {
    CustomerDTO toDTO(Customer data);
    Customer toEntity(CustomerDTO data);
}
