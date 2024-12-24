CREATE TABLE peca (
    id UUID PRIMARY KEY,
    codigo_barras VARCHAR(50) UNIQUE NOT NULL,
    nome VARCHAR(100) NOT NULL,
    categoria VARCHAR(100),
    fornecedor VARCHAR(100),
    preco_unitario DECIMAL(10,2) NOT NULL,
    quantidade INT NOT NULL,
    data TIMESTAMP NOT NULL
);
