# Arquitectura del Proyecto

- [Visión General](#visión-general).
- [Estructura del Proyecto](#estructura-del-proyecto).
- [Patrones y Principios](#patrones-y-principios).
- [Flujo de Datos](#flujo-de-datos).
- [Dependencias Clave](#dependencias-clave).
- [Consideraciones de Seguridad](#consideraciones-de-seguridad).
- [Despliegue y Entorno](#despliegue-y-entorno).
  - [Entorno de Desarrollo](#entorno-de-desarrollo).
  - [Entorno de Producción](#entorno-de-producción).
- [Guía de Contribución](#guía-de-contribución).

## Visión General

Este documento proporciona una visión general de la arquitectura de la API para "Gasto Consciente". La API está diseñada para registrar precios, listas de compras, lista de supermercados. La arquitectura está basada en microservicios con arquitectura MVC.

## Estructura del Proyecto

La estructura de este proyecto Maven se organiza de la siguiente manera:

```plaintext
/ws-gasto-consciente
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com
│   │   │       └── galavec
│   │   │           └── ws_gasto_consciente
│   │   │               ├── component
│   │   │               ├── configuration
│   │   │               ├── controller
│   │   │               ├── dto
│   │   │               ├── entity
│   │   │               ├── enums
│   │   │               ├── exception
│   │   │               ├── repository
│   │   │               ├── service
│   │   │               │   └── impl
│   │   │               ├── sources
│   │   │               └── util
│   │   ├── resources
│   │   └── webapp
│   │       └── WEB-INF
│   └── test
│       ├── java
│       └── resources
├── .gitignore
├── pom.xml
├── README.md
└── sonar-project.properties
```

- `src/main/webapp/WEB-INF`: Contiene configuración para el context-root en el WildFly.
- `src/main/java/com/galavec/ws_gasto_consciente/component`: Paquete para los clases de tipo componente generales del proyecto.
- `src/main/java/com/galavec/ws_gasto_consciente/configuration`: Configuraciones del proyecto.
- `src/main/java/com/galavec/ws_gasto_consciente/controller`: Controladores REST que gestionan las solicitudes HTTP.
- `src/main/java/com/galavec/ws_gasto_consciente/dto`: Contiene los "Data Transfer Objects" utilizados para transferir datos entre el cliente y el servidor.
- `src/main/java/com/galavec/ws_gasto_consciente/entity`: Contiene las entidades JPA que representan las tablas en la base de datos.
- `src/main/java/com/galavec/ws_gasto_consciente/enums`: Contiene las clases Enum para representar conjuntos de valores constantes.
- `src/main/java/com/galavec/ws_gasto_consciente/exception`: Contiene las excepciones personalizadas.
- `src/main/java/com/galavec/ws_gasto_consciente/repository`: Repositorios para acceder a la base de datos.
- `src/main/java/com/galavec/ws_gasto_consciente/service`: Servicios que contienen la lógica de negocio.
- `src/main/java/com/galavec/ws_gasto_consciente/sources`: Configuraciones de conexión hacia los dataSource que se encuentran en el servidor de aplicaciones.
- `src/main/java/com/galavec/ws_gasto_consciente/util`: Contiene clases y utilidades que proporcionan funcionalidades auxiliares y de apoyo para otras partes de la aplicación.

## Patrones y Principios

- **Arquitectura Basada en REST**: La API sigue los principios RESTful para la comunicación entre el cliente y el servidor.
- **Controladores**: Los controladores gestionan las solicitudes entrantes y envían respuestas. Están anotados con `@RestController` y utilizan mapeos HTTP (`@GetMapping`, `@PostMapping`, etc.).
- **Servicios**: Los servicios contienen la lógica de negocio y están anotados con `@Service`. Los controladores llaman a los servicios para realizar operaciones.
- **Repositorios**: Los repositorios interactúan con la base de datos y se encuentran en el package `Repository`. Utilizan Spring Data JPA para operaciones CRUD.
- **Configuraciones**: La configuración del proyecto se maneja en el package `configuration` y puede incluir configuraciones de seguridad y otras configuraciones del entorno. Las configuraciones para base de datos, se encuentran en el package `sources`.

## Flujo de Datos

1. **Recepción de Solicitud**: El cliente envía una solicitud HTTP a uno de los controladores.
2. **Procesamiento de Solicitud**: El controlador llama al servicio correspondiente para procesar la solicitud.
3. **Lógica de Negocio**: El servicio realiza la lógica de negocio y puede interactuar con uno o más repositorios.
4. **Acceso a Datos**: Los repositorios interactúan con la base de datos para obtener o almacenar datos.
5. **Respuesta**: El servicio devuelve una respuesta al controlador, que luego la envía de vuelta al cliente.

## Dependencias Clave

- **Spring Boot**: Facilita la configuración y el desarrollo de aplicaciones Java basadas en Spring.
- **Spring Data JPA**: Proporciona una interfaz para acceder a la base de datos utilizando JPA.
- **Spring Security**: Próximamente.

## Consideraciones de Seguridad

Próximamente.

## Despliegue y Entorno

### Entorno de Desarrollo

Para el entorno de Desarrollo debes tener los siguientes software instalados:

- Git.
- Java 17.
- PostgreSql 16.4 o posterior.
- WildFly 33.0.0 o posterior.
- SonarQube 10.6 o posterior.
- Sonar Scanner 6.1
- IDE para poder realizar los cambios, recomendado "Intellij IDEA".

### Entorno de Producción

Próximamente.

## Guía de Contribución

Para contribuir a este proyecto, sigue las siguientes pautas:

1. **Fork y Clonación**: Realiza un fork del repositorio y clónalo a tu entorno local.
2. **Desarrollo**: Crea una rama para tus cambios y realiza las modificaciones necesarias.
3. **Pruebas**: Ejecuta las pruebas unitarias y de integración para asegurar que tus cambios no rompan la funcionalidad existente.
4. **Pull Request**: Abre un pull request con una descripción detallada de los cambios realizados.
