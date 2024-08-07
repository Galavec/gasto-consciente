package com.galavec.ws_gasto_consciente.repository;

import com.galavec.ws_gasto_consciente.entity.SupermarketEntity;
import org.springframework.data.repository.CrudRepository;

public interface SupermarketRepository extends CrudRepository
        <SupermarketEntity, Long> {
}
