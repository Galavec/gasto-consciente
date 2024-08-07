package com.galavec.ws_gasto_consciente.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class ProductsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codProduct;
    private String productName;
    private String productDescription;
    private Long codSupermarket;
    private Double productPrice;
    private Integer productQuantity;
    private String userCreation;
    private LocalDateTime dateCreation;
    private String userModification;
    private LocalDateTime dateModification;
    private String productStatus;
}
