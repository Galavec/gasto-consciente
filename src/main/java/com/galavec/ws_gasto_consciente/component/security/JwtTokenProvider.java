package com.galavec.ws_gasto_consciente.component.security;

import com.galavec.ws_gasto_consciente.util.SecretKeyUtil;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.UnsupportedJwtException;
import io.jsonwebtoken.security.SignatureException;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * Proveedor de tokens JWT para la autenticación y autorización.
 * <p>
 * Esta clase se encarga de generar, validar y extraer información de los tokens JWT.
 * Utiliza una clave secreta y un algoritmo especificado para firmar los tokens.
 * </p>
 *
 * @author Héctor Galavec
 * @version 1.0.0
 * @since 1.0.0
 */
@Slf4j
@Component
public class JwtTokenProvider {

    @Value("${app.jwtSecret}")
    private String jwtSecret;

    @Value("${app.jwtExpirationInMs}")
    private int jwtExpirationInMs;


    /**
     * Genera un token JWT basado en la autenticación proporcionada.
     *
     * @param authentication El objeto de autenticación que contiene la información del usuario autenticado.
     * @return un token JWT en formato String.
     * @author Héctor Galavec
     * @since 1.0.0
     */
    public String generateToken(@NonNull Authentication authentication) {
        String authenticationUsername = authentication.getName();

        Collection<? extends GrantedAuthority> obtainRoles = authentication.getAuthorities();

        Date expirationDate = new Date(System.currentTimeMillis() + jwtExpirationInMs);

        return Jwts.builder().subject(authenticationUsername)
                .claim("roles", obtainRoles.stream()
                        .map(GrantedAuthority::getAuthority) // Convertir los roles a strings
                        .toList())
                .issuedAt(new Date())
                .expiration(expirationDate)
                .signWith(SecretKeyUtil.generateSecretKeyWithAlgorithm(jwtSecret, "HMACSHA512"))
                .compact();
    }

    /**
     * Extraer el nombre de usuario del JWT.
     *
     * @param token El objeto de autenticación que contiene la información del usuario autenticado.
     * @return el 'subject' (nombre de usuario o 'sub' en el JWT).
     * @author Héctor Galavec
     * @since 1.0.0
     */
    public String obtainUserNameFromJWT(String token) {
        return theClaimsOfTheToken(token).getSubject();
    }

    /**
     * Se encarga de validar el token del JWT.
     *
     * @param token El objeto de autenticación que contiene la información del usuario autenticado.
     * @return true o false según la validación del token.
     * @author Héctor Galavec
     * @since 1.0.0
     */
    public boolean validateToken(String token) {
        try {
            theClaimsOfTheToken(token);

            return true;
        } catch (SignatureException ex) {
            log.error("||validateToken|| Firma inválida en el token: {}", ex.getMessage());
        } catch (ExpiredJwtException ex) {
            log.error("||validateToken|| El token ha expirado: {}", ex.getMessage());
        } catch (UnsupportedJwtException ex) {
            log.error("||validateToken|| Token no soportado: {}", ex.getMessage());
        } catch (MalformedJwtException ex) {
            log.error("||validateToken|| Token mal formado: {}", ex.getMessage());
        } catch (Exception ex) {
            log.error("||validateToken|| Error desconocido en el token: {}", ex.getMessage());
        }
        return false;
    }

    /**
     * Obtener los roles desde el JWT.
     *
     * @param token El objeto de autenticación que contiene la información del usuario autenticado.
     * @return una lista con todos los roles asociados al token.
     * @author Héctor Galavec
     * @since 1.0.0
     */
    public List<String> getRolesFromJWT(String token) {
        Object rolesObject = theClaimsOfTheToken(token).get("roles");

        if (rolesObject instanceof List<?> listRoles) {
            // Si todos los elementos son instancias de String, mapeamos el stream
            return listRoles.stream()
                    .filter(String.class::isInstance)  // Filtramos elementos que no sean String
                    .map(String.class::cast)           // Convertimos a String con cast seguro
                    .toList();
        } else {
            return Collections.emptyList();
        }
    }

    /**
     * Crea y configura un objeto JwtParser con la clave secreta y algoritmo especificados.
     *
     * @return un objeto JwtParser configurado.
     * @author Héctor Galavec
     * @since 1.0.0
     */
    private JwtParser createJwtParser() {
        return Jwts.parser()
                .verifyWith(SecretKeyUtil.generateSecretKeyWithAlgorithm(jwtSecret, "HMACSHA512"))
                .build();
    }

    /**
     * Obtiene las reclamaciones (claims) del token JWT proporcionado.
     *
     * @param token El token JWT del cual se extraerán las reclamaciones.
     * @return un objeto Claims que contiene las reclamaciones del token.
     * @author Héctor Galavec
     * @since 1.0.0
     */
    private Claims theClaimsOfTheToken(String token) {
        return createJwtParser().parseSignedClaims(token).getPayload();
    }
}
