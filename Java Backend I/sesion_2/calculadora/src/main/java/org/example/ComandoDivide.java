package org.example;

public class ComandoDivide extends ComandoCalculadora implements Comando{
    public ComandoDivide(float acumulador, float valor){

        super(acumulador, valor);
    }
    public float ejecutar(){

        return acumulador / valor;
    }
}
