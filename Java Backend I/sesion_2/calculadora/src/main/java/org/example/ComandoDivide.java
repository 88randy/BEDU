package org.example;

public class ComandoDivide extends ComandoCalculadora implements Comando{
    public ComandoDivide(float acumulador, float valor){

        super(acumulador, valor);
    }
    public float ejecutar(){

        if ( valor == 0 ){
            throw new ArithmeticException("No es posible dividir entre cero");
        }else{
            return acumulador / valor;
        }
    }
}
