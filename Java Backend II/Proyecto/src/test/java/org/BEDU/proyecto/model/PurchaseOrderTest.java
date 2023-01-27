package org.BEDU.proyecto.model;

import org.hibernate.exception.ConstraintViolationException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.xml.validation.Validator;
import java.math.BigDecimal;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class PurchaseOrderTest {

    /*
    * Test para comprobar que el nombre del producto no sea nulo
    */

    @Test
    public void testProductNameNotNull() {
        Product product = new Product();
        Assertions.assertThrows(ConstraintViolationException.class, () -> {
            product.setName(null);
        });
    }

    /*
    * Test para comprobar que el precio del producto no sea nulo
    */
    @Test
    public void testProductPriceNotNull() {
        Product product = new Product();
        Assertions.assertThrows(ConstraintViolationException.class, () -> {
            product.setPrice(null);
        });
    }

    /*
    * Test para comprobar que la fecha de la orden de compra no sea nula:
    */
    @Test
    public void testPurchaseOrderDateNotNull() {
        PurchaseOrder purchaseOrder = new PurchaseOrder();
        Assertions.assertThrows(ConstraintViolationException.class, () -> {
            purchaseOrder.setDate(null);
        });
    }

    /*
    * Test para comprobar que el cliente de la orden de compra no sea nulo
    */
    @Test
    public void testPurchaseOrderCustomerNotNull() {
        PurchaseOrder purchaseOrder = new PurchaseOrder();
        Assertions.assertThrows(ConstraintViolationException.class, () -> {
            purchaseOrder.setCustomer(null);
        });
    }

}