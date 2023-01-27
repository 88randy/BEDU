package org.BEDU.proyecto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import org.BEDU.proyecto.model.Customer;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer, Long> {

}

