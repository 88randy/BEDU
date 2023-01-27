package org.BEDU.proyecto.model;

import org.hibernate.exception.ConstraintViolationException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.persistence.PersistenceException;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class CustomerTest {
    /*
    * Test para comprobar que se establece correctamente el valor
    * del atributo "customer" en un objeto de la clase Customer
    */
    @Test
    public void testSetCustomer() {
        Customer customer = new Customer();
        customer.setCustomer("Pepe Pecas Pica Papas");
        assertEquals("Pepe Pecas Pica Papas", customer.getCustomer());
    }

    /*
    * Test para comprobar que se genera correctamente un valor
    * para el atributo "id" al crear un objeto de la clase Customer
    */
    @Test
    public void testIdGeneration() {
        Customer customer = new Customer(1l, "Pepito");
        assertNotNull(customer.getId());
    }

    /*
    * Test para comprobar que se lanza una excepción cuando se intenta
    * crear un objeto de la clase Customer con un valor null para el atributo "customer":
    */

    @Test
    public void testNullCustomer() {
        Customer customer = new Customer();
        Assertions.assertThrows(ConstraintViolationException.class, () -> {
            customer.setCustomer(null);
        });
    }




    /*
    * Test para comprobar que se lanza una excepción cuando se intenta crear
    * un objeto de la clase Customer con un valor vacío para el atributo "customer"
    */
    @Test
    public void testEmptyCustomer() {
        Customer customer = new Customer();
        try {
            customer.setCustomer("");
            fail("Expected ConstraintViolationException to be thrown");
        } catch (ConstraintViolationException e) {
            // expected exception
        }
    }



    /*
    * Test para comprobar que se lanza una excepción cuando se intenta crear
    * dos objetos de la clase Customer con el mismo valor para el atributo "customer":
    */
    @Test
    public void testUniqueCustomer() {
        Customer customer1 = new Customer(1l, "pepito");
        try {
            Customer customer2 = new Customer(1l, "pepito");
            fail("Expected PersistenceException to be thrown");
        } catch (PersistenceException e) {
            // expected exception
        }
    }
}