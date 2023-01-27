package org.BEDU.proyecto.model;

import org.hibernate.exception.ConstraintViolationException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.persistence.PersistenceException;
import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {
    /*
    * Test para validar que un producto no puede ser creado con un nombre nulo
    */

    @Test
    public void testNullProductName() {
        Assertions.assertThrows(ConstraintViolationException.class, () -> {
            Product product = new Product();
            product.setName(null);
        });
    }

    /*
    * Test para validar que un producto no puede ser creado con un precio nulo:
    */

    @Test
    public void testNullProductPrice() {
        Assertions.assertThrows(ConstraintViolationException.class, () -> {
            Product product = new Product();
            product.setPrice(null);
        });
    }

    /*
    * Test para validar que un producto no puede ser creado con un nombre vacío
    */
    @Test
    public void testEmptyProductName() {
        Assertions.assertThrows(ConstraintViolationException.class, () -> {
            Product product = new Product();
            product.setName("");
        });
    }

    /*
    * Test para validar que un producto no puede ser creado con un precio negativo
    */

    @Test
    public void testNegativeProductPrice() {
        Assertions.assertThrows(ConstraintViolationException.class, () -> {
            Product product = new Product();
            product.setPrice(new BigDecimal(-1));
        });
    }

    /*
    * Test para validar que no se pueden crear dos productos con el mismo nombre
    */

    @Test
    public void testUniqueProductName() {
        Product product1 = new Product(1l, "Product 1", new BigDecimal(10));
        Assertions.assertThrows(PersistenceException.class, () -> {
            Product product2 = new Product(1l, "Product 1", new BigDecimal(10));
        });
    }

    /*
    * Test para validar que un producto se puede crear correctamente con un nombre y precio válido
    */
    @Test
    public void testValidProduct() {
        Product product = new Product(1l, "Product 1", new BigDecimal(10));
        Assertions.assertNotNull(product);
    }

    /*
    * Test para validar que el id de un producto se asigna automáticamente al crearlo
    */
    @Test
    public void testAutogeneratedId() {
        Product product = new Product(1l,"Product 1", new BigDecimal(10));
        Assertions.assertNotNull(product.getId());
    }

}