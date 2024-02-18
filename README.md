# Desafío Técnico - Proyecto Desafío

Este es un proyecto desarrollado como parte de un desafío técnico. Proporciona una aplicación de backend construida con Spring Boot que ofrece una API REST para gestionar usuarios.

## Requisitos

- Java 17
- Maven
- IDE compatible con Spring Boot (por ejemplo, IntelliJ IDEA, Eclipse)

## Configuración

1. Clona este repositorio en tu máquina local.
2. Importa el proyecto en tu IDE como un proyecto Maven existente.
3. Asegúrate de tener configurada una base de datos H2 o modifica la configuración para utilizar otro proveedor de base de datos en `application.properties`.
4. Ejecuta la clase `DesafioApplication` para iniciar la aplicación.

## Uso

Una vez que la aplicación esté en funcionamiento, puedes acceder a la documentación de la API a través de Swagger UI. La URL predeterminada es `http://localhost:8080/swagger-ui/index.html`.

## Registro de Usuario

##  Endpoint

##  Descripción

Este endpoint permite registrar un nuevo usuario en el sistema.

#### Parámetros de Entrada

| Parámetro | Tipo   | Descripción       |
|-----------|--------|-------------------|
| user      | Object | Objeto del usuario a registrar |

## Ejemplo de Objeto de Usuario

```json
{
  "id": 1,
  "username": "usuarioejemplo",
  "email": "usuario@example.com",
  "password": "contrasena123"
}


Respuestas
201 Created: Se devuelve cuando el usuario se registra correctamente.
400 Bad Request: Se devuelve cuando hay un error de validación en los datos del usuario.
500 Internal Server Error: Se devuelve cuando ocurre un error interno en el servidor.

{
  "id": 1,
  "username": "usuarioejemplo",
  "email": "usuario@example.com"
}


Contribuir
Si deseas contribuir a este proyecto, sigue estos pasos:

Haz un fork del repositorio.
Crea una nueva rama (git checkout -b feature/nueva-caracteristica).
Realiza tus cambios y haz commits (git commit -am 'Agrega nueva característica').
Haz push a la rama (git push origin feature/nueva-caracteristica).
Crea un nuevo Pull Request.
Contacto
Si tienes alguna pregunta o sugerencia, no dudes en ponerte en contacto con el equipo de desarrollo:

Nombre: CtrlShiftCoder
Correo electrónico: ignacioandrecamilettim@gmail.com

¡Gracias por tu interés en este proyecto!

