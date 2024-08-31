package com.galavec.ws_gasto_consciente.service;

import com.galavec.ws_gasto_consciente.dto.SupermarketDto;
import com.galavec.ws_gasto_consciente.entity.SupermarketEntity;

import java.util.List;

/**
 * Servicio para gestionar operaciones relacionadas con supermercados.
 *
 * <p>
 * Esta interfaz define las funciones utilizadas para el servicio de supermercados.
 * </p>
 *
 * @author Héctor Galavec
 * @version 1.0.0
 * @since 1.0.0
 */
public interface SupermarketService {

    /**
     * Registra un nuevo supermercado.
     *
     * @param supermarketDto el DTO con la información del supermercado a crear.
     * @return la entidad del supermercado creado.
     * @author Héctor Galavec
     * @since 1.0.0
     */
    SupermarketEntity createSupermarket(SupermarketDto supermarketDto);

    /**
     * Obtiene una lista de todos los supermercados.
     *
     * @return una lista de entidades de supermercados.
     * @author Héctor Galavec
     * @since 1.0.0
     */
    List<SupermarketEntity> getAllSupermarkets();
}
