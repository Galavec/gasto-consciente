package com.galavec.ws_gasto_consciente.controller;

import com.galavec.ws_gasto_consciente.component.security.JwtTokenProvider;
import com.galavec.ws_gasto_consciente.dto.ErrorResponseDto;
import com.galavec.ws_gasto_consciente.dto.JwtResponseDto;
import com.galavec.ws_gasto_consciente.dto.LoginRequestDto;
import com.galavec.ws_gasto_consciente.enums.SuccessTypeEnum;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

/**
 * Controlador para la autenticación de usuarios.
 *
 * <p>
 * Esta clase maneja las solicitudes de autenticación, generando y proporcionando tokens JWT.
 * </p>
 *
 * @author Héctor Galavec
 * @version 1.0.0
 * @since 1.0.0
 */
@Slf4j
@RestController
@CrossOrigin(origins = "http://localhost:8080", methods = {RequestMethod.GET, RequestMethod.POST})
@RequestMapping("/auth")
@Tag(name = "Autenticación", description = "Operaciones relacionadas con autenticaciones")
public class AuthenticationController {

    private final AuthenticationManager authenticationManager;
    private final JwtTokenProvider jwtTokenProvider;

    /**
     * Constructor que inyecta las validaciones para JWT y Autenticación.
     *
     * @param authenticationManager contiene las validaciones para la autenticación.
     * @param jwtTokenProvider      el proveedor de tokens JWT para la autenticación y autorización.
     * @author Héctor Galavec
     * @since 1.0.0
     */
    public AuthenticationController(AuthenticationManager authenticationManager, JwtTokenProvider jwtTokenProvider) {
        this.authenticationManager = authenticationManager;
        this.jwtTokenProvider = jwtTokenProvider;
    }

    /**
     * Autentica al usuario y genera un token JWT.
     *
     * <p>
     * Maneja la solicitud de inicio de sesión, autenticando al usuario basado en
     * sus credenciales y generando un token JWT en caso de éxito.
     * </p>
     *
     * @param loginRequestDto El objeto que contiene las credenciales de inicio de sesión.
     * @return una respuesta HTTP con el token JWT.
     * @author Héctor Galavec
     * @since 1.0.0
     */
    @Operation(
            summary = "Autentica al usuario y genera un token JWT",
            description = "Maneja la solicitud de inicio de sesión, autenticando al usuario basado en sus credenciales y generando un token JWT en caso de éxito."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Token generado exitosamente", content = @Content(
                    schema = @Schema(implementation = JwtResponseDto.class)
            )),
            @ApiResponse(responseCode = "403", description = "Credenciales incorrectas.", content = @Content(
                    schema = @Schema(implementation = ErrorResponseDto.class)
            ))
    })
    @io.swagger.v3.oas.annotations.parameters.RequestBody(
            description = "Credenciales del usuario",
            required = true,
            content = @Content(
                    schema = @Schema(implementation = LoginRequestDto.class)
            )
    )
    @PostMapping("/login")
    public ResponseEntity<JwtResponseDto> authenticateUser(@RequestBody LoginRequestDto loginRequestDto) {
        log.info("****** Proceso authenticateUser ******");

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequestDto.getUsername(),
                        loginRequestDto.getPassword()
                )
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String generateJwt = jwtTokenProvider.generateToken(authentication);

        return new ResponseEntity<>((new JwtResponseDto(SuccessTypeEnum.SUCCESSFUL_EXECUTION.getCode(), generateJwt)),
                HttpStatus.OK);
    }
}
