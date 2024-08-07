CREATE TABLE IF NOT EXISTS products (
    codProduct BIGINT PRIMARY KEY AUTO_INCREMENT,
    productName VARCHAR(255),
    productDescription VARCHAR(255),
    codSupermarket BIGINT,
    productPrice DOUBLE,
    productQuantity INT,
    userCreation VARCHAR(50),
    dateCreation TIMESTAMP,
    userModification VARCHAR(50),
    dateModification TIMESTAMP,
    productStatus VARCHAR(1)
);