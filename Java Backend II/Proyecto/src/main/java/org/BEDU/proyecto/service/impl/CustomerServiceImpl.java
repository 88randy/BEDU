package org.BEDU.proyecto.service.impl;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.BEDU.proyecto.dto.CustomerDTO;
import org.BEDU.proyecto.model.Customer;
import org.BEDU.proyecto.mapper.ICustomerMapper;
import org.BEDU.proyecto.repository.ICustomerRepository;
import org.BEDU.proyecto.service.ICustomerService;

@Service
public class CustomerServiceImpl implements ICustomerService{

    private ICustomerMapper mapper;
    private ICustomerRepository repository;
    private static Logger logger = LoggerFactory.getLogger(CustomerServiceImpl.class);

    @Autowired
    public CustomerServiceImpl(ICustomerMapper mapper, ICustomerRepository repository) {
        this.mapper = mapper;
        this.repository = repository;
    }

    public List<CustomerDTO> findAll() {
        List<Customer> customers = repository.findAll();

        List<CustomerDTO> mappedCustomers = new LinkedList<>();
    
        for (Customer c : customers) {
            mappedCustomers.add(mapper.toDTO(c));
        }
    
        return mappedCustomers;
    }

    public Optional<CustomerDTO> findById(Long id) {
        return repository.findById(id).map(customer -> mapper.toDTO(customer));
    }

    public CustomerDTO save(CustomerDTO data) {
        Customer entity = mapper.toEntity(data);
        return mapper.toDTO(repository.save(entity));
    }

    public void update(long id, CustomerDTO data) throws Exception {
        Optional<Customer> result = repository.findById(id);
    
        if (result.isEmpty()) {
            logger.error("Intento fallido ya que no se puede actualizar un cliente que no existe");
        }
    
        Customer customer = result.get();
    
        customer.setCustomer(data.getCustomer());
    
        repository.save(customer);
    }

    public void delete(long id) throws Exception {
        Optional<Customer> result = repository.findById(id);
    
        if (result.isEmpty()) {
            logger.error("Intento fallido ya que no se puede borrar un cliente que no existe");
        }
    
        repository.deleteById(id);
    }
}
