import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariable;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    Calculator calculator = new Calculator();

    /*
    * Realiza las siguientes pruebas:
    * - Una prueba que solo se ejecute cunado nos encontramos en nuestro sistema operativo actual
    * - Una prueba que solo se ejecute en algún sistema operativo diferente a nuestro sistema operativo actual
    * - Una prueba que solo se ejecute en el ambiente de desarrollo y configurar nuestras variables de entorno para indicar que estamos en el ambiente de desarrollo
    * - Una prueba parametrizada para la suma
    * - Una prueba parametrizada para la multiplicación
    * - Una prueba con un display name distinto al nombre de la función
    */

    @Test
    @EnabledOnOs(OS.WINDOWS)
    public void pruebaOS1(){
        assertEquals(5, calculator.add(3,2));
    }

    @Test
    @EnabledOnOs(OS.MAC)
    public void pruebaOS2(){
        assertEquals(6, calculator.multiply(3,2));
    }

    @Test
    @EnabledIfEnvironmentVariable(named = "ENV", matches = "staging-server")
    public void onlyOnStagingServer(){
        assertEquals(36, calculator.add(25,11));
    }

    @ParameterizedTest
    @ValueSource(ints = {1,2,3,4})
    public void suma(int n){
        int result = calculator.add(n,11);
        assertTrue(result > 12);
    }

    @ParameterizedTest
    @ValueSource(ints = {1,2,3,4})
    public void multiplica(int n){
        int result = calculator.multiply(n,n);
        assertEquals(n*n, result);
    }

    @Test
    @DisplayName("Prueba para sumar dos números")
    public void multiplica2(){
        assertEquals(6, calculator.add(4,2));
    }
}