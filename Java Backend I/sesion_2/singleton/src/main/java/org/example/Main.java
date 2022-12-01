package org.example;

public class Main {
    public static void main(String[] args) {

        // Singleton s1 = new Singleton("1");
        // Singleton s2 = new Singleton("2");

        Singleton s1 = Singleton.getInstance("FOO");
        Singleton s2 = Singleton.getInstance("BAR");

        System.out.println(s1.getValue());
        System.out.println(s2.getValue());

        s1.setValue("Hola");

        System.out.println(s1.getValue());
        System.out.println(s2.getValue());
    }
}