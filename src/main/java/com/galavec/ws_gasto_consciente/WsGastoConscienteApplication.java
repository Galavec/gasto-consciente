package com.galavec.ws_gasto_consciente;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * Clase principal de la aplicación.
 *
 * @author Héctor Galavec
 * @version 1.0.0
 * @since 1.0.0
 */
@SpringBootApplication
public class WsGastoConscienteApplication extends SpringBootServletInitializer {

    /**
     * Función principal que sirve como punto de entrada para la aplicación Spring Boot.
     *
     * @param args argumentos de la línea de comandos pasados a la aplicación.
     * @since 1.0.0
     */
    public static void main(String[] args) {
        SpringApplication.run(WsGastoConscienteApplication.class, args);
    }

    /**
     * Configura la aplicación cuando se inicia mediante un contenedor de servlets.
     *
     * @param application un constructor para el contexto de la aplicación.
     * @return una instancia de SpringApplicationBuilder configurada.
     * @author Héctor Galavec
     * @since 1.0.0
     */
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(WsGastoConscienteApplication.class);
    }
}
