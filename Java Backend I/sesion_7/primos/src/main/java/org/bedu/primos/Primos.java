package org.bedu.primos;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Primos {

    private static Logger logger = LoggerFactory.getLogger(Runner.class);

    public void primo(int num) {
        if(num < 0){
            logger.error("El numero no puede ser negativo");
            return;
        } 
        for(int i = 2; i <= num/i; ++i) {
            if(num % i == 0) {
                logger.warn("El numero: {} no es primo", num);
            }
            return;
        }
        logger.info("El numero: {} si es primo", num);
        return;
    }
}
