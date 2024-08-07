CREATE TABLE IF NOT EXISTS supermarket (
    codSupermarket SERIAL PRIMARY KEY,
    supermarketName VARCHAR(255),
    supermarketDescription TEXT,
    userCreation VARCHAR(50),
    dateCreation TIMESTAMP,
    userModification VARCHAR(50),
    dateModification TIMESTAMP,
    supermarketStatus VARCHAR(10)
);
