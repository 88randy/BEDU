import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculadoraTest {

    private Calculadora calculadora = new Calculadora();

    @Test
    @DisplayName("Prueba del metodo suma")
    void sumaTest(){
        assertEquals(44, calculadora.suma(10,34));
    }

    @Test
    @DisplayName("Prueba de suma con números negativos y cero")
    void sumaNegativosCeroTest(){
        assertEquals(-5, calculadora.suma(-10,5));
        assertEquals(-5, calculadora.suma(5,-10));
        assertEquals(0, calculadora.suma(-5,5));
        assertEquals(0, calculadora.suma(0,0));
    }

    @Test
    @DisplayName("Prueba del metodo resta")
    void testResta() {
        assertEquals(2, calculadora.resta(5, 3));
    }

    @Test
    @DisplayName("Prueba del metodo multiplicacion")
    void testMultiplica() {
        assertEquals(6, calculadora.multiplica(2, 3));
    }

    @Test
    @DisplayName("Prueba división")
    void divideTest() {
        assertThrows(IllegalArgumentException.class, () -> calculadora.divide(100, 0), "No es posible dividir un valor entre 0");
    }

    @Test
    @DisplayName("Prueba división por cero")
    void dividePorCeroTest() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> calculadora.divide(100, 0));
        String expectedMessage = "No es posible dividir un valor entre 0";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

}