# **Java Backend I (Proyecto)**

## **Introducción**
En el siguiente proyecto creado a partir del curso Java Backend I impartido por BEDU en colaboración con HSBC, se presenta una API desarrollada con Spring Boot, que permite a los usuarios gestionar órdenes de compra, clientes y productos de manera eficiente y sencilla.

Este permite realizar operaciones CRUD (Crear, Leer, Actualizar y Eliminar) sobre entidades de clientes, productos y órdenes de compra. Además, permite realizar consultas sobre estas entidades y sus relaciones.

La aplicación es amigable y fácil de usar, ya que permite al usuario crear, editar y eliminar órdenes de compra, así como gestionar a los clientes y productos de manera rápida y sencilla.

Además, la aplicación utiliza una base de datos relacional para almacenar toda la información, lo que permite que los datos sean persistentes y estén disponibles en todo momento.

En resumen, este proyecto es una implementación de un API sencilla de gestión de órdenes de compra, clientes y productos, gracias a la utilización de Spring Boot y JPA.

## Entidades
Las entidades del sistema son:

- `Customer`: representa a un cliente. Tiene un atributo `customer` que representa el nombre del cliente.
- `Product`: representa a un producto. Tiene atributos `name` y `price`, que representan el nombre y el precio del producto, respectivamente.
- `PurchaseOrder`: representa una orden de compra. Tiene un atributo `date` que representa la fecha de la orden de compra y una relación con la entidad `Customer` que representa al cliente que realiza la compra. Además, tiene una relación con la entidad `PurchaseOrderItem`, que representa los productos incluidos en la orden de compra.
- `PurchaseOrderItem`: representa un producto incluido en una orden de compra. Tiene una relación con la entidad `Product` que representa al producto y un atributo `quantity` que representa la cantidad del producto. Además, tiene una relación con la entidad `PurchaseOrder` que representa la orden de compra a la que pertenece.

## Mapeos

Se han creado mapeos entre las entidades y sus respectivos DTO (Data Transfer Object, objeto de transferencia de datos) para poder realizar operaciones de manera más sencilla y evitar problemas de seguridad. Los mapeos se encuentran en las interfaces `ICustomerMapper`, `IProductMapper`, `IPurchaseOrderMapper` y `IPurchaseOrderItemMapper`.

## Repositorios

Se han creado repositorios para cada entidad que permiten realizar operaciones CRUD sobre las mismas y realizar consultas. Los repositorios se encuentran en las interfaces `ICustomerRepository`, `IProductRepository`, `IPurchaseOrderRepository` y `IPurchaseOrderItemRepository`.

## Controladores

Se han creado controladores para cada entidad que permiten realizar operaciones CRUD y consultas sobre las mismas. Los controladores son `CustomerController`, `ProductController`, `PurchaseOrderController` y `PurchaseOrderItemController`.

## Servicios

Se han creado servicios para cada entidad que realizan las operaciones necesarias sobre las entidades y sus relaciones. Los servicios son `CustomerService`, `ProductService`, `PurchaseOrderService` y `PurchaseOrderItemService`.

## LOGS

Se ha implementado el uso de logs ya que puede ser muy útil para mejorar la calidad y el rendimiento del proyecto, y para facilitar la solución de problemas que puedan presentarse durante su ejecución.

## **Requerimientos**

- `java 15`
- `Java(TM) SE Runtime Environment bu(ild 15)`
- `Maven`
- Base de datos `MySQL`
- Postman

## **Instrucciones**

1. Clonar el repositorio del siguiente <a href="https://github.com/88randy/BEDU" target="_blank">Enlace</a>.

    ```
    git clone https://github.com/88randy/BEDU

    ```

2. Ingresar a la carpeta del proyecto.

    ```
    cd Bedu/Java Backend I/Proyecto
    ```

3. Abrir el archivo `application.properties` con cualquier editor de texto.
   ```
    vim src/main/resources/application.properties
   ```

4. Configurar la conexión a la base de datos.
   (Dentro del archivo se encuentran más propiedades pero solo hay que modificar las  siguientes tres).

   ```javascript
    spring.datasource.url=jdbc:mysql://localhost:{PUERTO}/{NOMBRE_BD}
    spring.datasource.username={USUARIO}
    spring.datasource.password={CONTRASENA}
   ```
   (Ejemplo de como quedaría el archivo)
   ```javascript
    spring.datasource.url=jdbc:mysql://localhost:3306/proyecto
    spring.datasource.username=root
    spring.datasource.password=123456789
   ```
   Una vez configurado el archivo con la información de la base de datos, guardamos cambios y cerramos.

## **Ejecución del proyecto**

Para ejecutar el proyecto podemo hacerlo desde la terminal con el comando.
```
mvn spring-boot:run
```

A continuación, se pueden acceder a las operaciones y consultas disponibles a través de la API REST. 

Algunos ejemplos de operaciones que se pueden realizar son:

- Crear un nuevo cliente: `POST http://localhost:8080/customers` con un cuerpo de solicitud en formato JSON que incluya el atributo `customer` del cliente.

    ```json
    {
        "customer":"Pepito Sánchez"
    }
    ```

- Obtener un cliente existente: `GET http://localhost:8080/customers/{id}` donde `{id}` es el id del cliente a obtener.

    ```json
    [
        {
            "id": 1,
            "customer": "Pepito Sánchez"
        }
    ]
    ```

- Actualizar un cliente existente: `PUT http://localhost:8080/customers/{id}` con un cuerpo de solicitud en formato JSON que incluya el atributo customer del cliente y donde `{id}` es el id del cliente a actualizar.

    ```json
    {
        "customer":"Margarito Hernández"
    }
    ```

- Eliminar un cliente existente: `DELETE http://localhost:8080/customers/{id}` donde `{id}` es el id del cliente a eliminar.


- Crear una nueva orden de compra: `POST http://localhost:8080/purchase-orders` con un cuerpo de solicitud en formato JSON que incluya el atributo `customerId` del cliente que realiza la compra y una lista de objetos `items` que incluyan el atributo `productId` del producto y la cantidad del mismo.

    ```json
    {
    "customer": {
        "id": 1,
        "customer": "Pepito Sánchez"
    },
        "items": [
            {
                "product": {
                    "id": 1,
                    "name":"gorra",
                    "price":350.00
                },
                "quantity": 2
            },
            {
                "product": {
                    "id": 2,
                    "name":"abrigo",
                    "price":800.00
                },
                "quantity": 1
            }
        ]
    }
    ```

- Obtener una orden de compra existente: `GET http://localhost:8080/purchase-orders/{id}` donde `{id}` es el id de la orden de compra a obtener.

    ```json
    {
        "id": 2,
        "date": "2022-12-18T01:38:43",
        "customer": {
            "id": 2,
            "customer": "Pepito Sánchez"
        },
        "items": [
            {
                "id": 8,
                "product": {
                    "id": 2,
                    "name": "abrigo",
                    "price": 800.00
                },
                "quantity": 1
            },
            {
                "id": 7,
                "product": {
                    "id": 1,
                    "name": "gorra",
                    "price": 350.00
                },
                "quantity": 3
            }
        ]
    }
    ```

Entre muchos otros ejemplos.


## **Mejoras**
En cuanto a mejoras que se le podrían hacer al proyecto, algunas opciones que se me ocurren son:

- Implementar validaciones en las entidades y en los mapeos para asegurar que los datos ingresados cumplen con ciertas condiciones.
- Crear una interfaz de usuario para que los usuarios finales puedan interactuar con el sistema de manera más sencilla.
- Implementar seguridad en el proyecto para proteger las operaciones y consultas disponibles y restringir el acceso a ciertos usuarios.
- Agregar soporte para transacciones para garantizar la integridad de los datos.
- Mejorar la documentación del proyecto y agregar ejemplos de uso de la API REST.
- Realizar pruebas unitarias y de integración para asegurar la calidad del código.
- Montar en Docker la aplicación


## **Conclusiones**
Fue un verdadero reto y un gusto haber participado en el curso y debo decir que aprendí bastante y no me queda más que agradecer al Experto Jorge por su gran labor de compartir su conocimiento.

Sobre el proyecto podemos concluir que:

- El proyecto permite realizar operaciones CRUD y consultas sobre las entidades de clientes, productos y órdenes de compra.
- Se han creado mapeos y repositorios para facilitar el trabajo con las entidades y sus relaciones.
- Los controladores y servicios implementan las operaciones y consultas disponibles a través de la API REST.
- Se implementó el uso de logs para proporcionar información de monitoreo.


