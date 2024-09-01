# Dependencias del Proyecto

- [spring-boot-starter-web](#spring-boot-starter-web).
- [spring-boot-starter](#spring-boot-starter).
- [spring-boot-starter-web-services](#spring-boot-starter-web-services).
- [spring-boot-starter-tomcat](#spring-boot-starter-tomcat).
- [lombok](#lombok).
- [slf4j-api](#slf4j-api).
- [spring-boot-starter-data-jpa](#spring-boot-starter-data-jpa).
- [postgresql](#postgresql).
- [spring-boot-starter-validation](#spring-boot-starter-validation).
- [jackson-datatype-jsr310](#jackson-datatype-jsr310).
- [springdoc-openapi-starter-webmvc-ui](#springdoc-openapi-starter-webmvc-ui).

## spring-boot-starter-web

- **Grupo**: org.springframework.boot
- **Artefacto**: spring-boot-starter-web
- **Versión**: A elección de la versión 3.3.2 del parent.
- **Propósito**: Para crear aplicaciones web con Spring Boot.
- **Configuración Especial**: Se han excluido las dependencias `log4j-to-slf4j` y `logback-classic` para evitar conflictos con otras dependencias de logging en el proyecto.

## spring-boot-starter

- **Grupo**: org.springframework.boot
- **Artefacto**: spring-boot-starter
- **Versión**: A elección de la versión 3.3.2 del parent.
- **Propósito**: Para iniciar una aplicación Spring Boot.
- **Configuración Especial**: Se ha excluido la dependencia `spring-boot-starter-logging` para evitar conflictos con otras dependencias de logging en el proyecto.

## spring-boot-starter-web-services

- **Grupo**: org.springframework.boot
- **Artefacto**: spring-boot-starter-web-services
- **Versión**: A elección de la versión 3.3.2 del parent.
- **Propósito**: Se utiliza para facilitar la creación y consumo de servicios web basados en SOAP en aplicaciones Spring Boot.
- **Configuración Especial**: No requiere configuración especial.

## spring-boot-starter-tomcat

- **Grupo**: org.springframework.boot
- **Artefacto**: spring-boot-starter-tomcat
- **Versión**: A elección de la versión 3.3.2 del parent.
- **Propósito**: Para incluir Tomcat como el contenedor de servlets embebido en una aplicación Spring Boot y permitir el uso de Logs en WildFly. El uso del alcance `provided` indica que esta dependencia estará disponible en el entorno de desarrollo y compilación, pero no se incluirá en el paquete final de la aplicación.
- **Configuración Especial**: No requiere configuración especial.

## lombok

- **Grupo**: org.projectlombok
- **Artefacto**: lombok
- **Versión**: A elección de la versión 3.3.2 del parent.
- **Propósito**: Para reducir el código repetitivo en las clases Java mediante el uso de anotaciones.
- **Configuración Especial**: No requiere configuración especial.

## slf4j-api

- **Grupo**: org.slf4j
- **Artefacto**: slf4j-api
- **Versión**: A elección de la versión 3.3.2 del parent.
- **Propósito**: Para integrar la API de logging SLF4J (Simple Logging Facade for Java) en el proyecto. Al usar `slf4j-api`, podemos escribir código de logging independiente de la implementación específica, lo que mejora la flexibilidad y mantenibilidad de la aplicación.
- **Configuración Especial**: No requiere configuración especial.

## spring-boot-starter-data-jpa

- **Grupo**: org.springframework.boot
- **Artefacto**: spring-boot-starter-data-jpa
- **Versión**: A elección de la versión 3.3.2 del parent.
- **Propósito**: Para simplificar el acceso y la manipulación de datos en aplicaciones Spring Boot mediante JPA (Java Persistence API). Spring Boot configura automáticamente las conexiones a la base de datos y los repositorios JPA, reduciendo la cantidad de configuración manual necesaria.
- **Configuración Especial**: No requiere configuración especial.

## postgresql

- **Grupo**: org.postgresql
- **Artefacto**: postgresql
- **Versión**: 42.7.3
- **Propósito**: Nos permite que la aplicación Java se conecte y se comunique con una base de datos PostgreSQL.
- **Configuración Especial**: No requiere configuración especial.

## spring-boot-starter-validation

- **Grupo**: org.springframework.boot
- **Artefacto**: spring-boot-starter-validation
- **Versión**: A elección de la versión 3.3.2 del parent.
- **Propósito**: Para habilitar la validación de datos en aplicaciones Spring Boot. Facilita la integración de validaciones en métodos de servicios y controladores usando anotaciones como @Valid y @Validated.
- **Configuración Especial**: No requiere configuración especial.

## jackson-datatype-jsr310

- **Grupo**: com.fasterxml.jackson.datatype
- **Artefacto**: jackson-datatype-jsr310
- **Versión**: 2.17.2
- **Propósito**: Para agregar soporte a Jackson como el manejo de las clases de fecha y hora de Java 8 (como LocalDate, LocalDateTime, ZonedDateTime, etc.). Esta extensión permite que Jackson serialice y deserialice correctamente estos tipos de datos, que no son compatibles de forma nativa con Jackson. Esta dependencia es para el uso de la anotación `@JsonDeserialize` en las clases de obtención de datos como los DTO.
- **Configuración Especial**: No requiere configuración especial.

## springdoc-openapi-starter-webmvc-ui

- **Grupo**: org.springdoc
- **Artefacto**: springdoc-openapi-starter-webmvc-ui
- **Versión**: 2.6.0
- **Propósito**: En Maven se utiliza para integrar y automatizar la generación de documentación de APIs RESTful en aplicaciones Spring Boot, utilizando la especificación OpenAPI.
- **Configuración Especial**: No requiere configuración especial.
