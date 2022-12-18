package org.BEDU.proyecto.service.impl;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.BEDU.proyecto.dto.PurchaseOrderItemDTO;
import org.BEDU.proyecto.model.PurchaseOrderItem;
import org.BEDU.proyecto.mapper.IPurchaseOrderItemMapper;
import org.BEDU.proyecto.repository.IPurchaseOrderItemRepository;
import org.BEDU.proyecto.service.IPurchaseOrderItemService;


@Service
public class PurchaseOrderItemServiceImpl implements IPurchaseOrderItemService{
    
    private IPurchaseOrderItemMapper mapper;
    private IPurchaseOrderItemRepository repository;

    @Autowired
    public PurchaseOrderItemServiceImpl(IPurchaseOrderItemMapper mapper, IPurchaseOrderItemRepository repository) {
        this.mapper = mapper;
        this.repository = repository;
    }

    public List<PurchaseOrderItemDTO> findAll() {
        List<PurchaseOrderItem> purchaseOrderItem = repository.findAll();

        List<PurchaseOrderItemDTO> mappedPurchaseOrderItem = new LinkedList<>();
    
        for (PurchaseOrderItem c : purchaseOrderItem) {
            mappedPurchaseOrderItem.add(mapper.toDTO(c));
        }
    
        return mappedPurchaseOrderItem;
    }

    public Optional<PurchaseOrderItemDTO> findById(Long id) {
        return repository.findById(id).map(purchaseOrderItem -> mapper.toDTO(purchaseOrderItem));
    }

    public PurchaseOrderItemDTO save(PurchaseOrderItemDTO data) {
        PurchaseOrderItem entity = mapper.toEntity(data);
        return mapper.toDTO(repository.save(entity));
    }

    public void update(long id, PurchaseOrderItemDTO data) throws Exception {
        Optional<PurchaseOrderItem> result = repository.findById(id);
    
        if (result.isEmpty()) {
            throw new Exception("No existe");
        }
    
        PurchaseOrderItem purchaseOrderItem = result.get();
    
        purchaseOrderItem.setProduct(data.getProduct());
        purchaseOrderItem.setQuantity(data.getQuantity());
        purchaseOrderItem.setPurchaseOrder(data.getPurchaseOrder());
    
        repository.save(purchaseOrderItem);
    }

    public void delete(long id) throws Exception {
        Optional<PurchaseOrderItem> result = repository.findById(id);
    
        if (result.isEmpty()) {
            throw new Exception("No existe");
        }
    
        repository.deleteById(id);
    }
}
