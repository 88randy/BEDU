package org.BEDU.proyecto.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import org.BEDU.proyecto.model.Product;

@Repository
public interface IProductRepository extends JpaRepository<Product, Long> { 
    Optional<Product> findOneByName(String name);
}