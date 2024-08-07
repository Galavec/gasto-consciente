package com.galavec.ws_gasto_consciente.service.impl;

import com.galavec.ws_gasto_consciente.entity.SupermarketEntity;
import com.galavec.ws_gasto_consciente.repository.SupermarketRepository;
import com.galavec.ws_gasto_consciente.service.SupermarketService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupermarketServiceImpl implements SupermarketService {
    private final SupermarketRepository supermarketRepository;

    public SupermarketServiceImpl(SupermarketRepository supermarketRepository) {
        this.supermarketRepository = supermarketRepository;
    }

    @Override
    public List<SupermarketEntity> getAllSupermarkets() {
        return (List<SupermarketEntity>) supermarketRepository.findAll();
    }
}
