# Postwork

Ejercicio con Docker del postwork de la sesión 14 - 11 - 2022


Ya tener docker instalado


## Instalación

Abrir terminal y descargar la imagen httpd

```
docker pull httpd

```


Levantamos la imagen.

```
docker run -d --name apache-server -p 80:80 httpd

```


Ubicamos el contenedor (se puede ubicar con el comando "docker ps") y ejecutamos.

"Reemplazar los corchetes con el id del contenedor"

```
docker exec -it {id} bash

```


Dentro del contenedor actualizamos.

```
apt-get update & apt-get upgrade -y

```


Instalamos las herramientas (wget, zip).

```
apt install wget zip

```


Nos posicionamos en el siguiente path.

```
cd /usr/local/apache2/htdocs

```


Descargamos el zip que contiene la aplicación

```
wget https://github.com/beduExpert/DevOps-Fundamentals-2021/raw/main/Sesion-01/coming-soon-evening-html.zip

```


Lo descomprimimos y eliminamos

```
unzip coming-soon-evening-html.zip

rm -r coming-soon-evening-html.zip

```

Vamos al navegador e ingresamos la siguiente ruta: [https://127.0.0.1](https://127.0.0.1)


![Localhost ejercicio BEDU](./images/BEDU%20postwork%20modulo%204.png)



