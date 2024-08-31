package com.galavec.ws_gasto_consciente.service.impl;

import com.galavec.ws_gasto_consciente.dto.SupermarketDto;
import com.galavec.ws_gasto_consciente.entity.SupermarketEntity;
import com.galavec.ws_gasto_consciente.repository.SupermarketRepository;
import com.galavec.ws_gasto_consciente.service.SupermarketService;
import com.galavec.ws_gasto_consciente.util.DateUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Implementación del servicio para gestionar operaciones relacionadas con supermercados.
 *
 * <p>
 * Esta clase está anotada con @Service y @Transactional para indicar que es un servicio
 * de Spring y que las operaciones deben ser transaccionales. Implementa la interfaz
 * SupermarketService.
 * </p>
 *
 * @author Héctor Galavec
 * @version 1.0.0
 * @see SupermarketService
 * @see SupermarketRepository
 * @since 1.0.0
 */
@Slf4j
@Service
@Transactional
public class SupermarketServiceImpl implements SupermarketService {
    private final SupermarketRepository supermarketRepository;

    /**
     * Constructor que inyecta el repositorio de supermercados.
     *
     * @param supermarketRepository el repositorio de supermercados.
     * @author Héctor Galavec
     * @since 1.0.0
     */
    public SupermarketServiceImpl(SupermarketRepository supermarketRepository) {
        this.supermarketRepository = supermarketRepository;
    }

    /**
     * Crea un nuevo supermercado.
     *
     * @param supermarketDto el DTO con la información del supermercado a crear.
     * @return la entidad del supermercado creado.
     * @author Héctor Galavec
     * @since 1.0.0
     */
    @Override
    public SupermarketEntity createSupermarket(SupermarketDto supermarketDto) {
        SupermarketEntity supermarketEntity = new SupermarketEntity();

        supermarketEntity.setSupermarketName(supermarketDto.getSupermarketName());
        supermarketEntity.setSupermarketDescription(supermarketDto.getSupermarketDescription());
        supermarketEntity.setUserCreation(supermarketDto.getUserCreation());
        supermarketEntity.setDateCreation(DateUtil.getCurrentDateTimeWithLocalDateTime());
        supermarketEntity.setSupermarketStatus(supermarketDto.getSupermarketStatus());

        return supermarketRepository.save(supermarketEntity);
    }

    /**
     * Obtiene una lista de todos los supermercados.
     *
     * @return una lista de entidades de supermercados.
     * @author Héctor Galavec
     * @since 1.0.0
     */
    @Override
    public List<SupermarketEntity> getAllSupermarkets() {
        return supermarketRepository.findAll();
    }
}
