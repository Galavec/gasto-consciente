package com.galavec.ws_gasto_consciente.configuration.security;

import com.galavec.ws_gasto_consciente.component.exception.CustomAccessDeniedHandler;
import com.galavec.ws_gasto_consciente.component.exception.CustomAuthenticationEntryPoint;
import com.galavec.ws_gasto_consciente.component.security.JwtAuthenticationFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * Configuración de seguridad para la aplicación.
 * <p>
 * Esta clase configura la seguridad de la aplicación, incluyendo el filtro de autenticación JWT,
 * el manejo de usuarios en memoria, y la configuración de codificación de contraseñas.
 * </p>
 *
 * @author Héctor Galavec
 * @version 1.0.0
 * @since 1.0.0
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig {
    /**
     * Filtro de autenticación JWT para validar los tokens en cada solicitud.
     */
    private final JwtAuthenticationFilter jwtAuthenticationFilter;

    /**
     * Manejado personalizado para accesos denegados, utilizado para manejar errores de autorización.
     */
    private final CustomAccessDeniedHandler customAccessDeniedHandler;

    /**
     * Punto de entrada personalizado para manejar errores de autenticación.
     */
    private final CustomAuthenticationEntryPoint customAuthenticationEntryPoint;

    /**
     * Constructor que inyecta las dependencias necesarias para la configuración de seguridad.
     *
     * @param jwtAuthenticationFilter        Filtro de autenticación JWT.
     * @param customAccessDeniedHandler      Manejado personalizado para accesos denegados.
     * @param customAuthenticationEntryPoint Punto de entrada personalizado para errores de autenticación.
     * @author Héctor Galavec
     * @since 1.0.0
     */
    public SecurityConfig(JwtAuthenticationFilter jwtAuthenticationFilter, CustomAccessDeniedHandler customAccessDeniedHandler, CustomAuthenticationEntryPoint customAuthenticationEntryPoint) {
        this.jwtAuthenticationFilter = jwtAuthenticationFilter;
        this.customAccessDeniedHandler = customAccessDeniedHandler;
        this.customAuthenticationEntryPoint = customAuthenticationEntryPoint;
    }

    /**
     * Define el filtro de seguridad de la cadena de seguridad HTTP.
     * <p>
     * Configura la seguridad HTTP y agrega el filtro de autenticación JWT antes del filtro de autenticación de usuario y contraseña.
     * </p>
     *
     * @param httpSecurity el objeto HttpSecurity para configurar las políticas de seguridad.
     * @return la cadena de filtros de seguridad configurada.
     * @throws Exception si llegar a ocurrir un error durante la configuración de la seguridad HTTP.
     * @author Héctor Galavec
     * @since 1.0.0
     */
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        configureHttpSecurity(httpSecurity);

        httpSecurity.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);

        return httpSecurity.build();
    }

    /**
     * Define el administrador de autenticación para la seguridad HTTP.
     * <p>
     * Configura el administrador de autenticación con el servicio de detalles de usuario y el codificador de contraseñas.
     * </p>
     *
     * @param httpSecurity el objeto HttpSecurity para configurar las políticas de seguridad.
     * @return el administrador de autenticación configurado.
     * @throws Exception si llegar a ocurrir un error durante la configuración del administrador de autenticación.
     * @author Héctor Galavec
     * @since 1.0.0
     */
    @Bean
    public AuthenticationManager authenticationManager(HttpSecurity httpSecurity) throws Exception {
        var authenticationManagerBuilder =
                httpSecurity.getSharedObject(AuthenticationManagerBuilder.class);

        authenticationManagerBuilder
                .userDetailsService(userDetailsService())
                .passwordEncoder(passwordEncoder());

        return authenticationManagerBuilder.build();
    }

    /**
     * Define el servicio de detalles de usuario en memoria.
     * <p>
     * Crea un servicio en memoria con usuarios básicos para pruebas.
     * </p>
     *
     * @return el servicio de detalles de usuario en memoria.
     * @author Héctor Galavec
     * @since 1.0.0
     */
    @Bean
    public UserDetailsService userDetailsService() {
        // Aquí retornas un servicio en memoria con un usuario básico para pruebas
        var inMemoryUserDetails = new InMemoryUserDetailsManager();

        var adminUser = User.withUsername("admin_1")
                .password(passwordEncoder().encode("G3n3r@t3d@S3cur3Pa$$w0rd"))
                .roles("ADMIN")
                .build();

        var regularUser = User.withUsername("user_1")
                .password(passwordEncoder().encode("S3cur3T3stP@ssw0rd"))
                .roles("USER")
                .build();

        inMemoryUserDetails.createUser(adminUser);
        inMemoryUserDetails.createUser(regularUser);

        return inMemoryUserDetails;
    }

    /**
     * Define el codificador de contraseñas.
     * <p>
     * Retorna un codificador de contraseñas BCrypt o cualquier otro encoder que se esté utilizando.
     * </p>
     *
     * @return el codificador de contraseñas.
     * @author Héctor Galavec
     * @since 1.0.0
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();  // O cualquier otro encoder que estés usando
    }

    /**
     * Configura la seguridad HTTP para la aplicación.
     * <p>
     * Deshabilita la protección CSRF, configura las reglas de autorización
     * para las solicitudes HTTP, permitiendo acceso a la ruta de login sin autenticación,
     * requiriendo el rol de ADMIN para acceder a la ruta de obtención de supermercados,
     * y deshabilita el login basado en formularios.
     * </p>
     *
     * @param httpSecurity El objeto HttpSecurity para configurar las políticas de seguridad.
     * @throws Exception Si ocurre un error durante la configuración de la seguridad HTTP.
     * @author Héctor Galavec
     * @since 1.0.0
     */
    private void configureHttpSecurity(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.csrf(AbstractHttpConfigurer::disable) // Deshabilitar CSRF (no necesario con JWT)
                .exceptionHandling(exceptionHandling -> exceptionHandling
                        .accessDeniedHandler(customAccessDeniedHandler)
                        .authenticationEntryPoint(customAuthenticationEntryPoint))
                .authorizeHttpRequests(authorizeRequests -> authorizeRequests
                        .requestMatchers("/auth/login").permitAll() // Permitir acceso a login
                        .requestMatchers("/swagger-ui/**", "/v3/api-docs/**", "/swagger-ui/index.html").permitAll()
                        .requestMatchers("/crud-supermarket/get-all-supermarkets").hasRole("USER")
                        .anyRequest().authenticated()  // Requerir autenticación para otras rutas
                )
                .formLogin(AbstractHttpConfigurer::disable);  // Deshabilitar el login basado en formularios
    }
}
