package org.bedu.ejemplo01.model;

import lombok.Data;

@Data
public class Producto {
    private long id;
    private String name;
    private double price;
}