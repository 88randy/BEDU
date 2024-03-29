import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class FeaturesTest {

    @Test
    @DisabledOnOs(OS.LINUX)
    public void prueba1(){
        assertTrue(true);
    }

    @Test
    @EnabledOnOs(OS.WINDOWS)
    public void prueba2(){
        assertTrue(true);
    }

    @Test
    @EnabledOnOs({OS.WINDOWS, OS.MAC})
    public void prueba3(){
        assertTrue(true);
    }

    @Test
    @DisabledOnJre(JRE.JAVA_15)
    public void prueba4(){
        assertTrue(true);
    }

    @Test
    @DisabledForJreRange(min = JRE.JAVA_9, max = JRE.JAVA_15)
    public void prueba5(){
        assertTrue(true);
    }

    @Test
    public void par(){
        assertFalse(5%2 == 0);
    }

    @ParameterizedTest
    @ValueSource(ints = {1,2,3,4,5,6,7,8,9})
    public void par28(int n){
        assertTrue(n%2 == 0);
    }
}
