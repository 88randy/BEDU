package org.BEDU.proyecto.service;

import java.util.List;
import java.util.Optional;

import org.BEDU.proyecto.model.Product;

public interface IProductService {
    List<Product> getAll();
    
    Optional<Product> findById(Long id);

    Product create(Product data);

    Product save(Product data);

    public void deleteById(Long id);
}