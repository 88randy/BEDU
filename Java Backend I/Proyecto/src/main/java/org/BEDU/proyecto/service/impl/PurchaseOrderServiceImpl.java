package org.BEDU.proyecto.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.BEDU.proyecto.dto.PurchaseOrderDTO;
import org.BEDU.proyecto.model.PurchaseOrder;
import org.BEDU.proyecto.model.PurchaseOrderItem;
import org.BEDU.proyecto.mapper.IPurchaseOrderMapper;
import org.BEDU.proyecto.repository.IPurchaseOrderRepository;
import org.BEDU.proyecto.service.IPurchaseOrderService;


@Service
public class PurchaseOrderServiceImpl implements IPurchaseOrderService{

    private IPurchaseOrderMapper mapper;
    private IPurchaseOrderRepository repository;
    private static Logger logger = LoggerFactory.getLogger(PurchaseOrderServiceImpl.class);

    @Autowired
    public PurchaseOrderServiceImpl(IPurchaseOrderMapper mapper, IPurchaseOrderRepository repository) {
        this.mapper = mapper;
        this.repository = repository;
    }

    public List<PurchaseOrderDTO> findAll() {
        List<PurchaseOrder> purchaseOrder = repository.findAll();
    
        return purchaseOrder.stream()
            .map(mapper::toDTO)
            .collect(Collectors.toUnmodifiableList());
    }

    public Optional<PurchaseOrderDTO> findById(Long id) {
        return repository.findById(id).map(purchaseOrder -> mapper.toDTO(purchaseOrder));
    }


    public PurchaseOrderDTO save(PurchaseOrderDTO data) {
        PurchaseOrder entity = mapper.toEntity(data);
        for (PurchaseOrderItem item : entity.getItems()) {
            item.setPurchaseOrder(entity);
        }

        return mapper.toDTO(repository.save(entity));
    }

    public void update(long id, PurchaseOrderDTO data) throws Exception {
        Optional<PurchaseOrder> result = repository.findById(id);
    
        if (result.isEmpty()) {
            throw new Exception("No existe la orden de compra");
        }
    
        PurchaseOrder purchaseOrder = result.get();
        Set<PurchaseOrderItem> items = data.getItems();

        purchaseOrder.setCustomer(data.getCustomer());
        purchaseOrder.getItems().clear();

        for (PurchaseOrderItem item : items) {
            item.setPurchaseOrder(purchaseOrder);
            purchaseOrder.getItems().add(item);
        }
        repository.save(purchaseOrder);
    }

    public void delete(long id) throws Exception {
        Optional<PurchaseOrder> result = repository.findById(id);
    
        if (result.isEmpty()) {
            throw new Exception("No existe la orden de compra");
        }
    
        repository.deleteById(id);
    }
}
