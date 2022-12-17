package org.bedu.primos;

import org.bedu.primos.Primos;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class Runner implements CommandLineRunner{

    @Override
    public void run(String[] args){
        Primos isPrimo1 = new Primos();
        isPrimo1.primo(3);

        Primos isPrimo2 = new Primos();
        isPrimo2.primo(-10);

        Primos isPrimo3 = new Primos();
        isPrimo3.primo(8);
    }
}