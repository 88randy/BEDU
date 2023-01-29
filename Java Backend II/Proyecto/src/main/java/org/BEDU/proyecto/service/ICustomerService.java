package org.BEDU.proyecto.service;

import java.util.List;
import java.util.Optional;

import org.BEDU.proyecto.dto.CustomerDTO;
import org.BEDU.proyecto.exception.InvalidDataException;
import org.BEDU.proyecto.exception.ResourceNotFoundException;


public interface ICustomerService {
    List<CustomerDTO> findAll() throws ResourceNotFoundException;
    Optional<CustomerDTO> findById(Long id) throws ResourceNotFoundException;
    CustomerDTO save(CustomerDTO data) throws InvalidDataException;
    void update(long id, CustomerDTO data) throws Exception;
    void delete(long id) throws Exception;
}