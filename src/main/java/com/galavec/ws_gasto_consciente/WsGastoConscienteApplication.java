package com.galavec.ws_gasto_consciente;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class WsGastoConscienteApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(WsGastoConscienteApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(WsGastoConscienteApplication.class);
    }
}
