package com.galavec.ws_gasto_consciente.configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Configuración de Swagger/OpenAPI para el servicio web Gasto Consciente.
 * <p>
 * Esta clase configura la documentación de la API REST utilizando Swagger y OpenAPI.
 * Incluye información sobre el servicio, contacto, licencia y esquemas de seguridad.
 * </p>
 *
 * @author Héctor Galavec
 * @version 1.0.0
 * @since 1.0.0
 */
@OpenAPIDefinition(
        info = @Info(
                title = "Web Service: Gasto Consciente",
                version = "1.0.0-SNAPSHOT",
                description = "API REST para llevar un control sobre los gastos domésticos realizados en supermercados.",
                termsOfService = "https://www.galavec.com/terminos",
                contact = @Contact(
                        name = "Administrador",
                        url = "https://www.x.com/galavec",
                        email = "galavec@hotmail.com"
                ),
                license = @License(
                        name = "Licencia Apache 2.0",
                        url = "https://www.apache.org/licenses/LICENSE-2.0"
                )
        )
)
@Configuration
public class OpenApiConfig {

    /**
     * Configura un grupo de API para las operaciones CRUD en supermercados.
     *
     * @return una instancia de {@link GroupedOpenApi} configurada para los endpoints de CRUD de supermercados.
     * @author Héctor Galavec
     * @since 1.0.0
     */
    @Bean
    public org.springdoc.core.models.GroupedOpenApi crudSupermarket() {
        return GroupedOpenApi.builder()
                .group("crud-supermarket")
                .pathsToMatch("/crud-supermarket/**")
                .build();
    }

    /**
     * Configura un grupo de API para las operaciones de autenticaciones.
     *
     * @return una instancia de {@link GroupedOpenApi} configurada para los endpoints de autenticaciones.
     * @author Héctor Galavec
     * @since 1.0.0
     */
    @Bean
    public org.springdoc.core.models.GroupedOpenApi authentication() {
        return GroupedOpenApi.builder()
                .group("authentication")
                .pathsToMatch("/auth/**")
                .build();
    }

    /**
     * Configura el esquema de seguridad para la autenticación JWT en Swagger, donde
     * se define un esquema de autenticación basado en Bearer Tokens (JWT).
     *
     * @return un objeto {@link SecurityScheme} para la autenticación Bearer.
     * @author Héctor Galavec
     * @since 1.0.0
     */
    @Bean
    public SecurityScheme securityScheme() {
        return new SecurityScheme()
                .type(SecurityScheme.Type.HTTP)
                .scheme("bearer")
                .bearerFormat("JWT")
                .name("bearerAuth")
                .in(SecurityScheme.In.HEADER);
    }

    /**
     * Configura los requerimientos de seguridad para los grupos de API.
     *
     * @return una lista de requerimientos de seguridad que se usan en Swagger.
     * @author Héctor Galavec
     * @since 1.0.0
     */
    @Bean
    public SecurityRequirement securityRequirement() {
        return new SecurityRequirement().addList("bearerAuth");
    }
}