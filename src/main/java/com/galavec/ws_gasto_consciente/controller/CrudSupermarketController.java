package com.galavec.ws_gasto_consciente.controller;

import com.galavec.ws_gasto_consciente.dto.ErrorResponseDto;
import com.galavec.ws_gasto_consciente.dto.ResponseDto;
import com.galavec.ws_gasto_consciente.dto.SuccessResponseDto;
import com.galavec.ws_gasto_consciente.dto.SupermarketDto;
import com.galavec.ws_gasto_consciente.entity.SupermarketEntity;
import com.galavec.ws_gasto_consciente.enums.ErrorTypeEnum;
import com.galavec.ws_gasto_consciente.enums.SuccessTypeEnum;
import com.galavec.ws_gasto_consciente.service.SupermarketService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Clase {@code RestController} para endpoints correspondientes a supermercados.
 *
 * @author Héctor Galavec
 * @version 1.0.0
 * @since 1.0.0
 */
@Slf4j
@RestController
@CrossOrigin(origins = "http://localhost:8080", methods = {RequestMethod.GET, RequestMethod.POST})
@RequestMapping(value = "/crud-supermarket")
@Tag(name = "Supermercado", description = "Operaciones relacionadas con supermercados")
public class CrudSupermarketController {
    private final SupermarketService supermarketService;

    /**
     * Constructor público para crear instancias.
     *
     * @param supermarketService el objeto {@code SupermarketService} que contiene los servicios con la lógica de negocio para los supermercados.
     * @author Héctor Galavec
     * @since 1.0.0
     */
    @Autowired
    public CrudSupermarketController(SupermarketService supermarketService) {
        this.supermarketService = supermarketService;
    }

    /**
     * Maneja las solicitudes POST para crear un nuevo supermercado.
     *
     * <p>Esta función recibe un objeto {@code SupermarketDto} válido en el cuerpo de la solicitud,
     * registra el inicio del proceso y devuelve una respuesta HTTP con un mensaje de éxito y el estado {@code CREATED}.</p>
     *
     * @param authorization  El token de autorización en el encabezado de la solicitud.
     * @param supermarketDto el objeto {@code SupermarketDto} que contiene los datos del nuevo supermercado.
     * @return una respuesta HTTP con un mensaje sobre el resultado de la solicitud y el estado {@code CREATED}.
     * @author Héctor Galavec
     * @since 1.0.0
     */
    @Operation(
            summary = "Crear un nuevo supermercado",
            description = "Maneja las solicitudes POST para crear un nuevo supermercado.",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Supermercado creado exitosamente", content = @Content(
                    schema = @Schema(implementation = SuccessResponseDto.class)
            )),
            @ApiResponse(responseCode = "-4", description = "Error al insertar registro en la base de datos", content = @Content(
                    schema = @Schema(implementation = ErrorResponseDto.class)
            )),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor", content = @Content(
                    schema = @Schema(implementation = ErrorResponseDto.class)
            ))
    })
    @io.swagger.v3.oas.annotations.parameters.RequestBody(
            description = "Datos del supermercado a crear",
            required = true,
            content = @Content(
                    schema = @Schema(implementation = SupermarketDto.class)
            )
    )
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping("/new-supermarket")
    public ResponseEntity<ResponseDto> newSupermarket(@RequestHeader("Authorization") String authorization, @RequestBody @Valid SupermarketDto supermarketDto) {
        log.info("****** Proceso newSupermarket: {} ******", supermarketDto.getSupermarketName());

        ResponseDto responseDto;

        String registrationCode;

        try {
            registrationCode = String.valueOf(supermarketService.createSupermarket(supermarketDto).getCodSupermarket());

            SuccessResponseDto successResponse = new SuccessResponseDto(SuccessTypeEnum.DATA_INSERTION_SUCCESS, registrationCode);

            responseDto = new ResponseDto(successResponse);

            return new ResponseEntity<>(responseDto, HttpStatus.CREATED);
        } catch (Exception ex) {
            log.error("Error en newSupermarket: ", ex);

            ErrorResponseDto errorResponseDto = new ErrorResponseDto(ErrorTypeEnum.DATA_INSERTION_FAILURE, ex.getMessage());

            responseDto = new ResponseDto(errorResponseDto);

            return new ResponseEntity<>(responseDto, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Maneja las solicitudes GET para obtener el listado de todos los supermercados registrados.
     *
     * @param authorization El token de autorización en el encabezado de la solicitud.
     * @return una respuesta HTTP con el listado de los supermercados que se encuentran registrados y, el estado {@code OK}.
     * @author Héctor Galavec
     * @since 1.0.0
     */
    @Operation(
            summary = "Obtiene el listado de todos los supermercados registrados",
            description = "Maneja las solicitudes GET para obtener el listado de todos los supermercados registrados.",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Consulta realizada exitosamente")
    })
    @PreAuthorize("hasRole('ROLE_USER')")
    @GetMapping("/get-all-supermarkets")
    public ResponseEntity<List<SupermarketEntity>> getAllSupermarkets(@RequestHeader("Authorization") String authorization) {
        log.info("****** Proceso getAllSupermarkets ******");

        return new ResponseEntity<>(supermarketService.getAllSupermarkets(), HttpStatus.OK);
    }

    @PostMapping("/test")
    public ResponseEntity<String> testPost() {
        return new ResponseEntity<>("Test POST Successful", HttpStatus.OK);
    }

}
