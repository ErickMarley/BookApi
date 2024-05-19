Esta es una API REST para gestionar libros, desarrollada con Spring Boot.

## Prerrequisitos

- Java 8
- Maven
- Git

Clonar el repositori de GitHub

1-Compilar y Construir el Proyecto
mvn clean install

2-Ejecutar la Aplicación
mvn spring-boot:run

3-La API estará disponible en http://localhost:8080

ENDPOINTS

GET: http://localhost:8080/api/books
POST: http://localhost:8080/api/books
{
    "bookName": "Nuevo Libro",
    "author": "Autor2",
    "releaseDate": "2024-01-01"
}

DELETE: http://localhost:8080/api/books?author=Author1

PUT: http://localhost:8080/api/books
{
    "bookName": "La naturaleza",
    "author": "Pascal",
    "releaseDate": "2024-01-01"
}
