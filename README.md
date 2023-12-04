# Prueba 

### Generar el jar
La aplicación esta construida en java 11 y springboot 2.1.3

Para generar el jar se puede realizar descargando el codigo y compilandolo con el siguiente comando

* $ mvn clean install

Para ejecutar la aplicacion:
 
* $ java -jar prueba-tecnica-1.0.jar 

La aplicacion escucha por el puerto 8081

### Ejemplo en el archivo para importar en postman. 

Donde se encuentran los recursos y ejemplos de invocacion al Servicio.

Post:
* localhost:8081/api/v1/required-remainder

Body request ejemplo :

{
    "data": [
        {
            "x": 7,
            "y": 5,
            "n": 12345
        },
        {
            "x": 5,
            "y": 0,
            "n": 4
        },
        {
            "x": 10,
            "y": 5,
            "n": 15
        },
        {
            "x": 17,
            "y": 8,
            "n": 54321
        },
        {
            "x": 499999993,
            "y": 9,
            "n": 1000000000
        }
    ]
}


Respuesta del servicio:

{
    "data": [
        {
            "x": 7,
            "y": 5,
            "n": 12345,
            "output": 12339
        },
        {
            "x": 5,
            "y": 0,
            "n": 4,
            "output": 0
        },
        {
            "x": 10,
            "y": 5,
            "n": 15,
            "output": 15
        },
        {
            "x": 17,
            "y": 8,
            "n": 54321,
            "output": 54306
        },
        {
            "x": 499999993,
            "y": 9,
            "n": 1000000000,
            "output": 999999995
        }
    ]
}

Cada entrada con su respectivo resultado.

GET: Array de datos llamado "data"
* localhost:8081/api/v1/required-remainder?data=7,5,12345&data=5,0,4&data=10,5,15&data=17,8,54321&data=499999993,9,1000000000


Respuesta del servicio:

{
    "data": [
        {
            "x": 7,
            "y": 5,
            "n": 12345,
            "output": 12339
        },
        {
            "x": 5,
            "y": 0,
            "n": 4,
            "output": 0
        },
        {
            "x": 10,
            "y": 5,
            "n": 15,
            "output": 15
        },
        {
            "x": 17,
            "y": 8,
            "n": 54321,
            "output": 54306
        },
        {
            "x": 499999993,
            "y": 9,
            "n": 1000000000,
            "output": 999999995
        }
    ]
}

## Docker

* docker build -t java-api-prueba .


* docker run -d -p 8081:8081 --name prueba-java11 java-api-prueba


## Postman
Importar el archivo que se encuentra en la carpeta /postman/prueba-tecnica.postman_collection.json

