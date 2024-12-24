CREATE TABLE manutencao_peca (
    id UUID PRIMARY KEY,
    manutencao_id UUID NOT NULL,
    peca_id UUID NOT NULL,
    quantidade_usada INT NOT NULL,
    FOREIGN KEY (manutencao_id) REFERENCES manutencao(id) ON DELETE CASCADE,
    FOREIGN KEY (peca_id) REFERENCES peca(id) ON DELETE CASCADE
);
