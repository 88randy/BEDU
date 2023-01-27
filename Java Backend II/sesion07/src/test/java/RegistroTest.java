import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RegistroTest {

    Registro registro = new Registro();

    /*
    * La entrada No es válida si:
    * - el username o password son vacíos.
    * - el username contiene el caracter '#'.
    * - las contraseñas no coinciden.
    * - la contraseña tiene una longitud menor a 8 caracteres.
    * */

    @Test
    public void username1(){
        boolean result = registro.valida("",
                "12345678",
                "12345678");

        assertFalse(result);
    }

    @Test
    public void password1(){
        boolean result = registro.valida("Pepito",
                "",
                "");

        assertFalse(result);
    }

    @Test
    public void username2(){
        boolean result = registro.valida("#Pepito",
                "12345678",
                "asdweqrt");

        assertFalse(result);
    }

    @Test
    public void password2(){
        boolean result = registro.valida("Pepito",
                "12345678",
                "asdweqrt");

        assertFalse(result);
    }

    @Test
    public void password3(){
        boolean result = registro.valida("Pepito",
                "123",
                "123");

        assertFalse(result);
    }

    @Test
    public void general(){
        boolean result = registro.valida("#Pepito",
                "",
                "1234");

        assertFalse(result);
    }

    @Test
    public void general2(){
        boolean result = registro.valida("Pepito",
                "12345678",
                "12345678");

        assertTrue(result);
    }
}