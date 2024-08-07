package com.galavec.ws_gasto_consciente.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
@Table(name = "supermarket", schema = "public")
public class SupermarketEntity {


    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long codSupermarket;
    private String supermarketName;
    private String supermarketDescription;
    private String userCreation;
    private LocalDateTime dateCreation;
    private String userModification;
    private LocalDateTime dateModification;
    private String supermarketStatus;
}
