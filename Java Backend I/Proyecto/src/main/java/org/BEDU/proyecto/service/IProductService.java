package org.BEDU.proyecto.service;

import java.util.List;
import java.util.Optional;

import org.BEDU.proyecto.dto.ProductDTO;

public interface IProductService {
    List<ProductDTO> findAll();
    Optional<ProductDTO> findById(Long id);
    ProductDTO save(ProductDTO data);
    void update(long id, ProductDTO data) throws Exception;
    void delete(long id) throws Exception;
}