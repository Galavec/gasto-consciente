package com.galavec.ws_gasto_consciente.util;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

/**
 * Utilidad para operaciones con claves secretas.
 *
 * @author Héctor Galavec
 * @version 1.0.0
 * @since 1.0.0
 */
public class SecretKeyUtil {

    /**
     * Constructor privado para evitar instanciación de la clase
     *
     * @author Héctor Galavec
     * @since 1.0.0
     */
    private SecretKeyUtil() {
        throw new UnsupportedOperationException("No se puede instanciar esta clase.");
    }

    /**
     * Convierte una clave secreta en una clave secreta con algoritmo.
     *
     * @return Genera la clave secreta con algoritmo.
     * @author Héctor Galavec
     * @since 1.0.0
     */
    public static SecretKey generateSecretKeyWithAlgorithm(String secretKey, String algorithm) {
        Objects.requireNonNull(secretKey, "||generateSecretKeyWithAlgorithm|| La clave secreta no puede ser nula.");

        if (secretKey.isEmpty()) {
            throw new IllegalArgumentException("||generateSecretKeyWithAlgorithm|| La clave secreta no puede estar vacía.");
        }

        return new SecretKeySpec(secretKey.getBytes(StandardCharsets.UTF_8), algorithm);
    }
}
