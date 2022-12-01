package org.BEDU;

public class Main {
    public static void main(String[] args) {

        Persona juan = new PersonaBuilder("Juan", "Perez", "Ortiz")
                .estadoCivil("casado")
                .edad(20)
                .direccion("Av. Juarez 26")
                .construir();

        System.out.println(juan.toString());
    }
}