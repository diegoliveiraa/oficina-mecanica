CREATE TABLE veiculo (
    id UUID PRIMARY KEY,
    placa VARCHAR(20) NOT NULL UNIQUE,
    modelo VARCHAR(100) NOT NULL,
    quilometragem DECIMAL(10,2) NOT NULL
);
