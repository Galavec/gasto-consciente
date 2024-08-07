package com.galavec.ws_gasto_consciente.controller;

import com.galavec.ws_gasto_consciente.dto.BranchDto;
import com.galavec.ws_gasto_consciente.entity.SupermarketEntity;
import com.galavec.ws_gasto_consciente.service.SupermarketService;
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

@Slf4j
@RestController
@CrossOrigin(origins = "http://localhost:8080", methods = {RequestMethod.GET, RequestMethod.POST})
@RequestMapping(value = "/crud-supermarket")
public class CrudSupermarketController {
    private final SupermarketService supermarketService;

    @Autowired
    public CrudSupermarketController(SupermarketService supermarketService) {
        this.supermarketService = supermarketService;
    }

    @PostMapping("/new-supermarket")
    public ResponseEntity<String> newSupermarket(@RequestBody BranchDto supermarketEntity) {
        log.info("****** Proceso newSupermarket ******");

        return new ResponseEntity<>("Successfully", HttpStatus.CREATED);
    }

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
