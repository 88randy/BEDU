# Sesión 03: Niveles de software testing

Desarrollo de pruebas en código ya existente para comprender cómo realizar pruebas a nivel componente e integración.

## Actividad 1

Código con al menos 8 pruebas unitarias del código proporcionado.

Vamos a la carpeta `test` y dentro del archivo `TestPizzeriaEjercicio1.java` encontraremos los test.

```java
@BeforeClass
    public void initialConditions() {
        Common = new CommonMethods();
        stdOutputPath = "output_files/output.txt";
    }

    @BeforeTest
    public void preConditions() {
        nuevaOrden = new PizzaOrden();
    }

    @Test
    public void verificarMensajeDeInicioSeDespliega() throws
            FileNotFoundException {
        Common.redirectStdOutput(stdOutputPath);
        nuevaOrden.desplegarMensajeInicio();
        String actualResult
                = Common.readFileContents(stdOutputPath);
        String expectedResult = "Bienvenido a la aplicación para ordenar pizza.\n\n"
        + "Sigue lasinstrucciones por favor.\n\n";
        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test
    public void verificarOpcionVeganaVerdadera() {
        nuevaOrden.setOpcionVeg("Y");
        boolean actualResult = nuevaOrden.getOpcionVeg();
        boolean expectedResult = true;
        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test
    public void verificarOpcopnVeganaFalsa() {
        nuevaOrden.setOpcionVeg("N");
        boolean actualResult = nuevaOrden.getOpcionVeg();
        boolean expectedResult = false;
        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test
    public void verificarGuardarIngrediente1ComoPimiento() {
        nuevaOrden.setIngrediente1("a");
        String actualResult = nuevaOrden.getIngrediente1();
        String expectedResult = "Pimiento";
        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test
    public void verificarGuardarIngrediente2ComoHongos() {
        nuevaOrden.setIngrediente2("b");
        String actualResult = nuevaOrden.getIngrediente2();
        String expectedResult = "Hongos";
        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test
    public void verificarGuardarIngrediente3ComoEspinaca() {
        nuevaOrden.setIngrediente3("c");
        String actualResult = nuevaOrden.getIngrediente3();
        String expectedResult = "Espinaca";
        Assert.assertEquals(actualResult, expectedResult);
    }
```

## Actividad 1.1

Video de menos de 1 minuto mostrando evidencia de los resultados arrojados por las pruebas unitarias.

[![Actividad 1.1 postwork BEDU](https://img.youtube.com/vi/rBZfV9K3m5Y/0.jpg)](https://www.youtube.com/watch?v=rBZfV9K3m5Y)


## Actividad 2

Código de diseño pruebas TDD y de la aplicación del requerimiento del ejercicio 2

Vamos a la carpeta `test` y dentro del archivo `TestPizzeriaEjercicio2.java` encontraremos los test.

Para encontrar la aplicación, vamos a la carpeta `src` y ejecutamos el archivo `SistemaLealtad.java`

## Actividad 2.1

Video de un minuto máximo mostrando el funcionamiento del ejercicio 2

[![Actividad 2.1 postwork BEDU](https://img.youtube.com/vi/TTvDp6RQg_Q/0.jpg)](https://www.youtube.com/watch?v=TTvDp6RQg_Q)
