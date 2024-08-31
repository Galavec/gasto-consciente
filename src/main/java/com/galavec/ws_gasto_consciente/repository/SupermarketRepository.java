package com.galavec.ws_gasto_consciente.repository;

import com.galavec.ws_gasto_consciente.entity.SupermarketEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repositorio para la entidad SupermarketEntity.
 *
 * <p>
 * Esta interfaz extiende JpaRepository, proporcionando métodos CRUD
 * para la entidad SupermarketEntity con identificadores de tipo Long.
 * </p>
 *
 * @author Héctor Galavec
 * @version 1.0.0
 * @see SupermarketEntity
 * @since 1.0.0
 */
public interface SupermarketRepository extends JpaRepository
        <SupermarketEntity, Long> {
}
