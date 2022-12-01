# Reto - Calculadora

Desarrollamos en clase una pila a travéz de un Comando para poder deshacer los cambios al momento de realizar una operación.


El comando nos servirá para ejecutar y para deshacer.

```java
public interface Comando {
    public float ejecutar();

    public float deshacer();

}
```

A su vez, realizamos los comandos para cada tipo de operación.

- Suma
- Resta
- Multiplicación
- División


### Comando SUMA

```java
public class ComandoSumar extends ComandoCalculadora implements Comando {
    public ComandoSumar(float acumulador, float valor) {
        super(acumulador, valor);
    }

    public float ejecutar() {
        return acumulador + valor;
    }
}
```

### Comando RESTA

```java
public class ComandoResta extends ComandoCalculadora implements Comando{
    public ComandoResta(float acumulador, float valor){
        super(acumulador, valor);
    }
    public float ejecutar(){

        return acumulador - valor;
    }
}
```

### Comando MULTIPLICACIÓN

```java
public class ComandoMultiplicar extends ComandoCalculadora implements Comando{
    public ComandoMultiplicar(float acumulador, float valor){

        super(acumulador, valor);
    }
    public float ejecutar(){

        return acumulador * valor;
    }
}
```

### Comando DIVISIÓN

```java
public class ComandoDivide extends ComandoCalculadora implements Comando{
    public ComandoDivide(float acumulador, float valor){

        super(acumulador, valor);
    }
    public float ejecutar(){

        return acumulador / valor;
    }
}
```

Y a continuación un comando general donde el constructor solicitará el valor y el acumulador.


```java
public abstract class ComandoCalculadora {
    protected float acumulador;
    protected float valor;

    public ComandoCalculadora(float acumulador, float valor) {
        this.acumulador = acumulador;
        this.valor = valor;
    }

    public float deshacer() {
        return acumulador;
    }
}
```