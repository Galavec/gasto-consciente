# Gasto Consciente

[![Java Version](https://img.shields.io/badge/Java-17-E3903C.svg)](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)
[![Spring Parent Version](https://img.shields.io/badge/Spring_parent-3.3.2-4FA02E.svg)](https://spring.io/projects/spring-boot)
[![Wildfly Version](https://img.shields.io/badge/WildFly-33.0.0-33787B.svg)](https://www.wildfly.org/downloads/)
[![PostgreSql Version](https://img.shields.io/badge/PostgreSql-16.4-295383.svg)](https://www.postgresql.org/download/)
[![SonarQube Version](https://img.shields.io/badge/SonarQube-10.6-4095AF.svg)](https://www.sonarsource.com/products/sonarqube/downloads/)
[![Sonar Scanner Version](https://img.shields.io/badge/Sonar_Scanner-6.1-4095AF.svg)](https://docs.sonarsource.com/sonarqube/10.6/analyzing-source-code/scanners/sonarscanner/#running-from-zip-file)

- [Introducción](#introducción).
- [Requerimientos](#requerimientos).
- [Guía de Contribución](#guía-de-contribución).
- [Clonar nuestro repositorio GitHub](#clonar-nuestro-repositorio-github).
- [Documentación adicional](#documentación-adicional).

## Introducción

API creada para llevar un control de nuestros gastos en cada supermercado.

Pensada para registrar precios, listas de compras, lista de supermercados.

## Requerimientos

Para ejecutar localmente la API tendrás que tener instalado los siguientes software:

- Java 17.
- PostgreSql 16.4 o posterior.
- WildFly 33.0.0 o posterior.

Para poder modificarlo o aportar con cambios en este repositorio, necesitas los siguientes software:

- Git.
- Java 17.
- PostgreSql 16.4 o posterior.
- WildFly 33.0.0 o posterior.
- SonarQube 10.6 o posterior.
- Sonar Scanner 6.1
- IDE para poder realizar los cambios, recomendado "Intellij IDEA".

## Guía de Contribución

Para contribuir a este proyecto, sigue las siguientes pautas:

1. **Fork y Clonación**: Realiza un fork del repositorio y clónalo a tu entorno local.
2. **Desarrollo**: Crea una rama para tus cambios y realiza las modificaciones necesarias.
3. **Pruebas**: Ejecuta las pruebas unitarias y de integración para asegurar que tus cambios no rompan la funcionalidad existente.
4. **Pull Request**: Abre un pull request con una descripción detallada de los cambios realizados.

## Clonar nuestro repositorio GitHub

Puedes clonar el repositorio mediante tres opciones:

- SSH: `git clone git@github.com:Galavec/ws-gasto-consciente.git`
- HTTPS: `git clone https://github.com/Galavec/ws-gasto-consciente.git`
- GitHub CLI: `gh repo clone Galavec/ws-gasto-consciente`

¡Toda contribución es bien recibida!

## Documentación adicional

Para más detalles, consulta los siguientes documentos:

- [Documento sobre la Arquitectura](docs/ARCHITECTURE.md).
- [Documento sobre las Configuraciones](docs/CONFIGURATION.md).
- [Documento sobre las Dependencias](docs/DEPENDENCIES.md).
