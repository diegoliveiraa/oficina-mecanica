CREATE TABLE manutencao (
    id UUID PRIMARY KEY,
    veiculo_id UUID NOT NULL,
    descricao VARCHAR(255),
    data TIMESTAMP NOT NULL,
    FOREIGN KEY (veiculo_id) REFERENCES veiculo(id) ON DELETE CASCADE
);
