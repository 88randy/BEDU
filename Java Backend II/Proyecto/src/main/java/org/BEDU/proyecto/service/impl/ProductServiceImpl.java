package org.BEDU.proyecto.service.impl;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.BEDU.proyecto.exception.InvalidDataException;
import org.BEDU.proyecto.exception.NotFoundException;
import org.BEDU.proyecto.exception.ResourceNotFoundException;
import org.BEDU.proyecto.model.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.BEDU.proyecto.dto.ProductDTO;
import org.BEDU.proyecto.model.Product;
import org.BEDU.proyecto.mapper.IProductMapper;
import org.BEDU.proyecto.repository.IProductRepository;
import org.BEDU.proyecto.service.IProductService;


@Service
public class ProductServiceImpl implements IProductService {

    private IProductMapper mapper;
    private IProductRepository repository;
    private static Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);

    @Autowired
    public ProductServiceImpl(IProductMapper mapper, IProductRepository repository) {
        this.mapper = mapper;
        this.repository = repository;
    }

    public List<ProductDTO> findAll() {
        List<Product> products = repository.findAll();
        if (products.isEmpty()) {
            try {
                throw new ResourceNotFoundException("No se encontraron productos en la base de datos", 404);
            } catch (ResourceNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
        List<ProductDTO> mappedProducts = new LinkedList<>();
    
        for (Product c : products) {
            mappedProducts.add(mapper.toDTO(c));
        }
    
        return mappedProducts;
    }

    public Optional<ProductDTO> findById(Long id) {
        Optional<Product> result = repository.findById(id);
        if(result.isEmpty()){
            try {
                throw new ResourceNotFoundException("No se encontró un producto con el id:" + " especificado",404);
            } catch (ResourceNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
        return result.map(product -> mapper.toDTO(product));
    }

    public ProductDTO save(ProductDTO data) {
        if (data == null) {
            try {
                throw new InvalidDataException("Los datos proporcionados son inválidos", 400);
            } catch (InvalidDataException e) {
                throw new RuntimeException(e);
            }
        }
        Product entity = mapper.toEntity(data);
        logger.info("Creado con exito el producto: {} con un precio de: {}", data.getName(), data.getPrice());
        return mapper.toDTO(repository.save(entity));
    }

    public void update(long id, ProductDTO data) throws Exception {
        Optional<Product> result = repository.findById(id);

        if (result.isEmpty()) {
            throw new NotFoundException(404, "No se puede actualizar un producto que no existe");
        }

        if (data == null) {
            try {
                throw new InvalidDataException("Los datos proporcionados son inválidos", 400);
            } catch (InvalidDataException e) {
                throw new RuntimeException(e);
            }
        }
    
        Product product = result.get();
    
        product.setName(data.getName());
        product.setPrice(data.getPrice());
    
        repository.save(product);
    }

    public void delete(long id) throws Exception {
        Optional<Product> result = repository.findById(id);

        if (result.isEmpty()) {
            throw new NotFoundException(404, "No se puede borrar un producto que no existe");
        }
    
        repository.deleteById(id);
    }
}