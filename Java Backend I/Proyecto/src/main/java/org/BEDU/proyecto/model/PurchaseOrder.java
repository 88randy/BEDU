package org.BEDU.proyecto.model;

import javax.persistence.*;
import java.util.Set;

import java.time.LocalDateTime;

@Entity
@Table(name = "ordenes_de_compra")
public class PurchaseOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "fecha", nullable = false)
    private LocalDateTime date;

    @ManyToOne
    @JoinColumn(name = "cliente_id", nullable = false)
    private Customer customer;

    @OneToMany(mappedBy = "purchaseOrder")
    private Set<PurchaseOrderItem> items;

    // Getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Set<PurchaseOrderItem> getItems() {
        return items;
    }

    public void setItems(Set<PurchaseOrderItem> items) {
        this.items = items;
    }
}
