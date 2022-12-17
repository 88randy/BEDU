package org.BEDU.proyecto.service;

import java.util.List;
import java.util.Optional;

import org.BEDU.proyecto.model.Customer;


public interface ICustomerService {

    List<Customer> getAll();
    
    Optional<Customer> findById(Long id);

    Customer create(Customer data);

    Customer save(Customer data);

    public void deleteById(Long id);

}

