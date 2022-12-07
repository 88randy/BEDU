# Introducción a Spring Boot

Spring Framework es un framework Open Source que facilita la creación de aplicaciones de todo tipo en Java , Kotlin y Groovy.

Si bien es cierto que, por lo que es más conocido es por la inyección de dependencias, Spring Framework está dividido en diversos módulos que podemos utilizar, ofreciéndonos muchas más funcionalidades:

- **Core container** : proporciona inyección de dependencias e inversión de control.
- **Web** : nos permite crear controladores Web, tanto de vistas MVC como aplicaciones REST.
- **Acceso a datos** : abstracciones sobre JDBC, ORMs como Hibernate, sistemas OXM (Object XML Mappers), JSM y transacciones.
- **Programación orientada a Aspectos (AOP)**: ofrece el soporte para aspectos.
- **Instrumentación** : proporciona soporte para la instrumentación de clases.
- **Pruebas de código** : contiene un framework de testing, con soporte para JUnit y TestNG y todo lo necesario para probar los mecanismos de Spring.

Estos módulos son opcionales , por lo que podemos utilizar los que necesitemos sin tener que llenar nuestro `classpath` con clases que no vamos a usar.

## Spring Boot

Si bien es cierto que Spring Framework es muy potente, la configuración inicial y la preparación de las aplicaciones para producción son tareas bastante tediosas. Spring Boot simplifica el proceso al máximo gracias a sus dos principales mecanismos.


## Contenedor de aplicaciones integrado

Spring Boot permite compilar nuestras aplicaciones Web como un archivo .jar que podemos ejecutar como una aplicación Java normal (como alternativa a un archivo .war, que desplegaríamos en un servidor de aplicaciones como Tomcat).

Esto lo consigue integrando el servidor de aplicaciones en el propio .jar y levantándolo cuando arrancamos la aplicación. De esta forma, podemos distribuir nuestras aplicaciones de una forma mucho más sencilla , al poder configurar el servidor junto con la aplicación. Esto también es muy útil en arquitecturas de microservicios , puesto que permite distribuir nuestras aplicaciones como imágenes Docker que podemos escalar horizontalmente (algo muy complicado con un .war).

## Starters

Spring Boot nos proporciona una serie de dependencias, llamadas starters, que podemos añadir a nuestro proyecto dependiendo de lo que necesitemos: crear un controlador REST, acceder a una base de datos usando JDBC, conectar con una cola de mensajes Apache ActiveMQ, etc.

Una vez añadimos un starter, éste nos proporciona todas las dependencias que necesitamos, tanto de Spring como de terceros. Además, los starters vienen configurados con valores por defecto, que pretenden minimizar la necesidad de configuración a la hora de desarrollar. Un buen ejemplo es el de `spring-boot-starter-actuator` : una vez que añadimos la dependencia, nuestra aplicación empezará a generar métricas tanto de la JVM como de la aplicación en sí (latencias, errores, etc).

Al igual que con Spring Framework, cualquier configuración puede ser modificada de ser necesario: desde el puerto en el que la aplicación escucha peticiones, hasta el banner que sale por consola al arrancar la aplicación.

## **Hola Mundo con Spring Boot**

```java
@SpringBootApplication
@RestController
public class Application {

    @GetMapping("/hello")
    public String hello() {
        return "Hello world!";
    }
}
```

## Referencia

¿Qué son Spring framework y Spring Boot? Tu primer programa Java con este framework - VIDEO. (2020, 8 octubre). DEV Community 👩‍💻👨‍💻. https://dev.to/campusmvp_es/que-son-spring-framework-y-spring-boot-tu-primer-programa-java-con-este-framework-4ao6