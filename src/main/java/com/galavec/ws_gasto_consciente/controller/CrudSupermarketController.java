package com.galavec.ws_gasto_consciente.controller;

import com.galavec.ws_gasto_consciente.dto.ResponseDto;
import com.galavec.ws_gasto_consciente.dto.SupermarketDto;
import com.galavec.ws_gasto_consciente.entity.SupermarketEntity;
import com.galavec.ws_gasto_consciente.enums.ErrorTypeEnum;
import com.galavec.ws_gasto_consciente.enums.SuccessTypeEnum;
import com.galavec.ws_gasto_consciente.service.SupermarketService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
     * @param supermarketDto el objeto {@code SupermarketDto} que contiene los datos del nuevo supermercado.
     * @return una respuesta HTTP con un mensaje sobre el resultado de la solicitud y el estado {@code CREATED}.
     * @author Héctor Galavec
     * @since 1.0.0
     */
    @PostMapping("/new-supermarket")
    public ResponseEntity<ResponseDto> newSupermarket(@RequestBody @Valid SupermarketDto supermarketDto) {
        log.info("****** Proceso newSupermarket: {} ******", supermarketDto.getSupermarketName());

        ResponseDto responseDto;

        String registrationCode;

        try {
            registrationCode = String.valueOf(supermarketService.createSupermarket(supermarketDto).getCodSupermarket());

            responseDto = new ResponseDto(SuccessTypeEnum.DATA_INSERTION_SUCCESS, registrationCode);

            return new ResponseEntity<>(responseDto, HttpStatus.CREATED);
        } catch (Exception ex) {
            log.error("Error en newSupermarket: ", ex);

            responseDto = new ResponseDto(ErrorTypeEnum.DATA_INSERTION_FAILURE, ex.getMessage());

            return new ResponseEntity<>(responseDto, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Maneja las solicitudes GET para obtener el listado de todos los supermercados registrados.
     *
     * @return una respuesta HTTP con el listado de los supermercados que se encuentran registrados y, el estado {@code OK}.
     * @author Héctor Galavec
     * @since 1.0.0
     */
    @GetMapping("/get-all-supermarkets")
    public ResponseEntity<List<SupermarketEntity>> getAllSupermarkets() {
        log.info("****** Proceso getAllSupermarkets ******");

        return new ResponseEntity<>(supermarketService.getAllSupermarkets(), HttpStatus.OK);
    }

    @PostMapping("/test")
    public ResponseEntity<String> testPost() {
        return new ResponseEntity<>("Test POST Successful", HttpStatus.OK);
    }

}
