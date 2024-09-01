# Configuraciones del Proyecto

- [maven-compiler](#maven-compiler).
- [wildfly-maven-plugin](#wildfly-maven-plugin).
- [maven-javadoc-plugin](#maven-javadoc-plugin).
- [JacksonConfig](#jacksonconfig).
- [GastoConscienteData](#gastoconscientedata).
- [OpenApiConfig](#openapiconfig).

## maven-compiler

- **Ubicación**: En el archivo `pom.xml`
- **Descripción**: Plugin para compilar el código fuente.
- **Configuración Importante**: Se especifica la versión de Java para la compilación.

```xml
<java.version>17</java.version>
<maven.compiler.source>${java.version}</maven.compiler.source>
<maven.compiler.target>${java.version}</maven.compiler.target>
```

## wildfly-maven-plugin

- **Ubicación**: En el archivo `pom.xml`
- **Descripción**: Plugin para desplegar el proyecto en el servidor de aplicaciones, WildFly.
- **Configuración Importante**: Se especifica la fase cuando se debe iniciar el despliegue en WildFly.

```xml
<plugin>
    <groupId>org.wildfly.plugins</groupId>
    <artifactId>wildfly-maven-plugin</artifactId>
    <version>5.0.0.Final</version>

    <executions>
        <execution>
            <phase>install</phase>
            <goals>
                <goal>deploy</goal>
            </goals>
        </execution>
    </executions>

    <configuration>
        <filename>${project.build.finalName}.war</filename>
        <hostname>${deploy.wildfly.host}</hostname>
        <port>${deploy.wildfly.port}</port>
    </configuration>
</plugin>
```

## maven-javadoc-plugin

- **Ubicación**: En el archivo `pom.xml`
- **Descripción**: Plugin para la documentación con JavaDoc.
- **Configuración Importante**: Se especifica la versión de Java a utilizar y el método de ejecución.

```xml
<plugin>
    <groupId>org.apache.maven.plugins</groupId>
    <artifactId>maven-javadoc-plugin</artifactId>
    <version>3.8.0</version>
    <configuration>
        <source>${java.version}</source>
        <show>protected</show>
    </configuration>
    <executions>
        <execution>
            <goals>
                <goal>javadoc</goal>
            </goals>
        </execution>
    </executions>
</plugin>
```

## JacksonConfig

- **Ubicación**: Clase ubicada en: `src/main/java/com/galavec/ws_gasto_consciente/configuration/JacksonConfig.java`
- **Descripción**: Configuración utilizada para validar el nombre de cada objeto en el request.
- **Configuración Importante**: Validación de los campos en un request.

```java
public class JacksonConfig {
    @Bean
    public ObjectMapper objectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        return objectMapper;
    }
}
```

## GastoConscienteData

- **Ubicación**: Clase ubicada en: `src/main/java/com/galavec/ws_gasto_consciente/sources/GastoConscienteData.java`
- **Descripción**: Configuración utilizada para conexión hacia la base de datos PostgreSql "gasto-consciente".
- **Configuración Importante**: Conexión hacia base de datos "gasto-consciente".

## OpenApiConfig

- **Ubicación**: Clase ubicada en: `src/main/java/com/galavec/ws_gasto_consciente/configuration/OpenApiConfig.java`
- **Descripción**: Esta clase configura la documentación de la API REST utilizando Swagger y OpenAPI.
- **Configuración Importante**: Implementación de Swagger.
