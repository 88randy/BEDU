package org.bedu;

public class Main {
    public static void main(String[] args) {

        int suma = 0;

        for (int i = 0; i <= 100; i++){
            suma += i;
        }

        System.out.println("La suma de los primeros 100 números es: " + suma);
    }
}