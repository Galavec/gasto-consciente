package com.galavec.ws_gasto_consciente.component.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Collection;
import java.util.List;

/**
 * Filtro de autenticación para solicitudes HTTP utilizando tokens JWT.
 * <p>
 * Este filtro se encarga de extraer, validar y procesar los tokens JWT en las solicitudes HTTP entrantes,
 * estableciendo la autenticación correspondiente en el contexto de seguridad de Spring.
 * </p>
 *
 * @author Héctor Galavec
 * @version 1.0.0
 * @since 1.0.0
 */
@Slf4j
@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {
    private final JwtTokenProvider jwtTokenProvider;

    /**
     * Constructor que inyecta las demás validaciones para JWT.
     *
     * @param jwtTokenProvider el proveedor de tokens JWT para la autenticación y autorización.
     * @author Héctor Galavec
     * @since 1.0.0
     */
    public JwtAuthenticationFilter(JwtTokenProvider jwtTokenProvider) {
        this.jwtTokenProvider = jwtTokenProvider;
    }

    /**
     * Filtra las solicitudes HTTP entrantes para verificar y autenticar tokens JWT.
     * <p>
     * Extrae el token JWT de la solicitud, lo valida, extrae el nombre de usuario y roles,
     * y establece la autenticación en el contexto de seguridad si el token es válido.
     * </p>
     *
     * @param request     La solicitud HTTP entrante.
     * @param response    La respuesta HTTP saliente.
     * @param filterChain La cadena de filtros a través de la cual se debe pasar la solicitud/response.
     * @throws ServletException Si ocurre un error en el procesamiento del filtro.
     * @throws IOException      Si ocurre un error de entrada/salida en el filtro.
     * @author Héctor Galavec
     * @since 1.0.0
     */
    @Override
    protected void doFilterInternal(@NonNull HttpServletRequest request, @NonNull HttpServletResponse response, @NonNull FilterChain filterChain) throws ServletException, IOException {
        String token = resolveToken(request);

        if (token != null) {
            if (jwtTokenProvider.validateToken(token)) {
                String username = jwtTokenProvider.obtainUserNameFromJWT(token);

                List<String> roles = jwtTokenProvider.getRolesFromJWT(token);

                Collection<? extends GrantedAuthority> authorities = roles.stream()
                        .map(SimpleGrantedAuthority::new)
                        .toList();

                Authentication authentication = new UsernamePasswordAuthenticationToken(username, null, authorities);

                SecurityContextHolder.getContext().setAuthentication(authentication);
            } else log.info("Token NO válido o nulo.");
        }

        filterChain.doFilter(request, response);
    }

    /**
     * Resuelve el token JWT desde la solicitud HTTP.
     *
     * @param request La solicitud HTTP desde la cual se obtendrá el token.
     * @return el token JWT en formato String, o null si no se encuentra o no es válido.
     * @author Héctor Galavec
     * @since 1.0.0
     */
    private String resolveToken(HttpServletRequest request) {
        String bearerToken = request.getHeader("Authorization");

        if (bearerToken != null && bearerToken.startsWith("Bearer ")) {
            return bearerToken.substring(7);
        }

        return null;
    }
}
