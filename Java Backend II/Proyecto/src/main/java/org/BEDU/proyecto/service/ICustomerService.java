package org.BEDU.proyecto.service;

import java.util.List;
import java.util.Optional;

import org.BEDU.proyecto.dto.CustomerDTO;


public interface ICustomerService {
    List<CustomerDTO> findAll();
    Optional<CustomerDTO> findById(Long id);
    CustomerDTO save(CustomerDTO data);
    void update(long id, CustomerDTO data) throws Exception;
    void delete(long id) throws Exception;
}