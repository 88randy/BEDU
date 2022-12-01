package org.example;

public class ComandoResta extends ComandoCalculadora implements Comando{
    public ComandoResta(float acumulador, float valor){
        super(acumulador, valor);
    }
    public float ejecutar(){

        return acumulador - valor;
    }
}
