package com.galavec.ws_gasto_consciente.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
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

/**
 * Clase entity que representa a la tabla {@code supermarket} en la base de datos postgresql.
 *
 * <p>
 * Esta clase está anotada con varias anotaciones de Lombok para generar
 * automáticamente getters, setters, constructores y la función toString.
 * También está mapeada a la tabla "supermarket" en el esquema "public".
 * </p>
 *
 * @author Héctor Galavec
 * @version 1.0.0
 * @since 1.0.0
 */
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

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime dateCreation;

    private String userModification;
    private LocalDateTime dateModification;
    private String supermarketStatus;
}
