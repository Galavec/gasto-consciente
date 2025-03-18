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
- [spring-boot-starter-security](#spring-boot-starter-security).
- [spring-security-core](#spring-security-core).
- [spring-security-config](#spring-security-config).
- [spring-security-web](#spring-security-web).
- [jjwt-api](#jjwt-api).
- [jjwt-impl](#jjwt-impl).
- [jjwt-jackson](#jjwt-jackson).

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

## spring-boot-starter-security

- **Grupo**: org.springframework.boot
- **Artefacto**: spring-boot-starter-security
- **Versión**: 3.4.1
- **Propósito**: Proporciona una integración rápida y sencilla con Spring Security, permitiendo implementar autenticación, autorización y protección contra vulnerabilidades comunes como CSRF en aplicaciones Spring Boot.
- **Configuración Especial**: Requiere definir un SecurityFilterChain para personalizar las reglas de seguridad. Si se utiliza autenticación basada en JWT, es necesario deshabilitar CSRF y agregar un filtro personalizado para validar los tokens.

## spring-security-core

- **Grupo**: org.springframework.security
- **Artefacto**: spring-security-core
- **Versión**: 6.4.2
- **Propósito**: Proporciona las clases y funcionalidades esenciales para manejar autenticación, autorización y seguridad en aplicaciones Java, como `AuthenticationManager`, `UserDetailsService` y `PasswordEncoder`.
- **Configuración Especial**: Requiere ser complementada con otras dependencias como `spring-security-config` para personalizar la configuración de seguridad.

## spring-security-config

- **Grupo**: org.springframework.security
- **Artefacto**: spring-security-config
- **Versión**: 6.4.2
- **Propósito**: Permite personalizar aspectos como reglas de autorización, métodos de autenticación y el manejo de usuarios mediante clases como `SecurityConfigurer` y `HttpSecurity`.
- **Configuración Especial**: Requiere crear un `SecurityFilterChain` para definir las políticas de seguridad específicas. Se utiliza en combinación con `spring-security-core` para establecer estrategias avanzadas de autenticación y autorización.

## spring-security-web

- **Grupo**: org.springframework.security
- **Artefacto**: spring-security-web
- **Versión**: 6.4.2
- **Propósito**: Maneja filtros de seguridad, intercepta solicitudes HTTP y aplica reglas de autenticación y autorización en el contexto de una aplicación web. Es fundamental para configurar reglas de autorización por URL, excepciones de seguridad y políticas de acceso.
- **Configuración Especial**: Requiere definir un filtro de seguridad, como `SecurityFilterChain`, para gestionar solicitudes HTTP.

## jjwt-api

- **Grupo**: io.jsonwebtoken
- **Artefacto**: jjwt-api
- **Versión**: 0.12.6
- **Propósito**: Facilita la creación, firma y validación de JSON Web Tokens (JWT) en aplicaciones Java. Es compatible con estándares como JWS (JSON Web Signature) y JWE (JSON Web Encryption).
- **Configuración Especial**: Requiere configurar una clave secreta o un par de claves públicas/privadas para firmar y verificar los tokens. Puede combinarse con otras dependencias del mismo grupo, como `jjwt-impl` y `jjwt-jackson`, para funcionalidades adicionales como serialización JSON.

## jjwt-impl

- **Grupo**: io.jsonwebtoken
- **Artefacto**: jjwt-impl
- **Versión**: 0.12.6
- **Propósito**: Proporciona la implementación interna de las funcionalidades de JJWT, como la creación, firma y validación de JSON Web Tokens (JWT). Es un complemento necesario para que `jjwt-api` funcione correctamente.
- **Configuración Especial**: Requiere configurar una clave secreta o un par de claves públicas/privadas para firmar y verificar los tokens. Debe usarse junto con `jjwt-api` y, opcionalmente, `jjwt-jackson` para manejar la serialización/deserialización de tokens en formato JSON.

## jjwt-jackson

- **Grupo**: io.jsonwebtoken
- **Artefacto**: jjwt-jackson
- **Versión**: 0.12.6
- **Propósito**: Permite la integración de JJWT con Jackson para manejar la serialización y deserialización de JSON en tokens JWT. Es útil para trabajar con claims complejos en formato JSON.
- **Configuración Especial**: Debe usarse junto con `jjwt-api` y `jjwt-impl` para una funcionalidad completa. Se debe incluir Jackson en el proyecto, ya que esta dependencia lo utiliza para procesar JSON.
