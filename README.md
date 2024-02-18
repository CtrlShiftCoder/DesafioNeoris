# Desafío Técnico - Proyecto Desafío

Este proyecto es la implementación del backend para una aplicación web de gestión de usuarios. Utiliza tecnologías modernas como Spring Boot y Hibernate para proporcionar una API RESTful segura y eficiente.

## Características Principales

- **Autenticación Segura**: Utiliza JSON Web Tokens (JWT) para la autenticación de usuarios, asegurando que las solicitudes a la API estén protegidas y solo sean accesibles para usuarios autorizados.
- **Validación de Datos**: Implementa validaciones exhaustivas para garantizar la integridad y seguridad de los datos ingresados por los usuarios, evitando errores y posibles vulnerabilidades.
- **Persistencia Eficiente**: Utiliza Hibernate como ORM (Mapeo Objeto-Relacional) para interactuar con la base de datos de manera eficiente y mantener la consistencia de los datos.
- **Arquitectura MVC**: Sigue el patrón de diseño Modelo-Vista-Controlador para separar la lógica de negocio de la lógica de presentación, facilitando la escalabilidad y el mantenimiento del código.

## Requisitos 🛠️

- Java 17
- Maven
- IDE compatible con Spring Boot (por ejemplo, IntelliJ IDEA, Eclipse)

## Configuración ⚙️

1. Clona este repositorio en tu máquina local.
2. Importa el proyecto en tu IDE como un proyecto Maven existente.
3. Asegúrate de tener configurada una base de datos H2 o modifica la configuración para utilizar otro proveedor de base de datos en `application.properties`.
4. Ejecuta la clase `DesafioApplication` para iniciar la aplicación.

## Uso 🚀

Una vez que la aplicación esté en funcionamiento, puedes acceder a la documentación de la API a través de Swagger UI. La URL predeterminada es `http://localhost:8080/swagger-ui/index.html`.

## Registro de Usuario ✍️

### Endpoint

`POST /users/register`

### Descripción

Este endpoint permite registrar un nuevo usuario en el sistema.

#### Parámetros de Entrada

| Parámetro | Tipo   | Descripción       |
|-----------|--------|-------------------|
| user      | Object | Objeto del usuario a registrar |

#### Ejemplo de Objeto de Usuario

```
{
  "name": "Miguel Camiletti",
  "email": "miguelandrecamilettim@gmail.com",
  "password": "StrongPassword123!",
  "phones": [
    {
      "number": "984459250",
      "citycode": "1",
      "countrycode": "12"
    }
  ]
}

```

####  Respuestas 📋
- **201 Created:** Se devuelve cuando el usuario se registra correctamente.
- **400 Bad Request:** Se devuelve cuando hay un error de validación en los datos del usuario.
- **500 Internal Server Error:** Se devuelve cuando ocurre un error interno en el servidor.


Ejemplo de respuesta en formato JSON:

```
{
    "id": "aab447f5-bec4-42bc-8bee-f9bb919372b0",
    "name": "Miguel Camiletti",
    "email": "miguelcamilettim@gmail.com",
    "password": "d9d8e7ee4e92681edbb144557bbf512c15e51582ed8f4a03dac98e88d1065674",
    "phones": [
        {
            "id": 1,
            "number": "984459250",
            "cityCode": "1",
            "countryCode": "12"
        }
    ],
    "created": "2024-02-18T19:51:39.1254605",
    "modified": "2024-02-18T19:51:39.1254605",
    "lastLogin": "2024-02-18T19:51:39.1254605",
    "token": "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJtaWd1ZWxjYW1pbGV0dGltQGdtYWlsLmNvbSIsImNyZWF0ZWQiOjE3MDgyOTY2OTksImxhc3RfbG9naW4iOjE3MDgyOTY2OTksImlzYWN0aXZlIjp0cnVlLCJtb2RpZmllZCI6MTcwODI5NjY5OSwiaWQiOltudWxsXSwiZXhwIjoxNzA4Mjk2OTk5LCJpYXQiOjE3MDgyOTY2OTl9.fvUL5CwK67ohhzleegILXS2WDsYCokkgNptGfSMcjWE",
    "active": false
}
```
####  Diagrama de Componente 🤝
+-------------------------------------------------------------+
|                    Backend de la Aplicación                 |
|  +-------------------------------------------------------+  |
|  |                    Configuraciones	                   |  |
|  |                                                       |  |
|  |   - SwaggerConfig					                           |  |
|  +-------------------------------------------------------+  |
|  |                    Controladores                      |  |
|  |                                                       |  |
|  |   - UserController                                    |  |
|  +-------------------------------------------------------+  |
|  |                    Servicios                          |  |
|  |                                                       |  |
|  |   - UserServiceImpl                                   |  |
|  |   - PhoneServiceImpl                                  |  |
|  +-------------------------------------------------------+  |
|  |                    Repositorios                       |  |
|  |                                                       |  |
|  |   - UserRepository                                    |  |
|  |   - PhoneRepository                                   |  |
|  +-------------------------------------------------------+  |
|  |                    Modelos                            |  |
|  |                                                       |  |
|  |   - UserModel                                         |  |
|  |   - PhoneModel	                                       |  |
|  +-------------------------------------------------------+  |
|  |                    Utilidades                         |  |
|  |                                                       |  |
|  |   - JwtTokenUtil                                      |  |
|  |   - PasswordUtil                                      |  |
|  |   - Validators                                        |  |
|  |   - ErrorResponse					                           |  |
|  |   - ValidatorsException                               |  |
|  +-------------------------------------------------------+  |
|  |                    Base de Datos                      |  |
|  |                                                       |  |
|  |   - H2						                                     |  |
|  +-------------------------------------------------------+  |
|                                                             |
+-------------------------------------------------------------+


####  Contribuir 🤝

Si deseas contribuir a este proyecto, sigue estos pasos:

1. Haz un fork del repositorio.
2. Crea una nueva rama (`git checkout -b feature/nueva-caracteristica`).
3. Realiza tus cambios y haz commits (`git commit -am 'Agrega nueva característica'`).
4. Haz push a la rama (`git push origin feature/nueva-caracteristica`).
5. Crea un nuevo Pull Request.


####  Contacto 📧

Si tienes alguna pregunta o sugerencia, no dudes en ponerte en contacto con el equipo de desarrollo:

- **Nombre:** CtrlShiftCoder
- **Correo electrónico:** ignacioandrecamilettim@gmail.com


