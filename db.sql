
CREATE DATABASE banco_nome;
USE banco_nome;


CREATE TABLE transacoes (
    id INT PRIMARY KEY AUTO_INCREMENT, -- [cite: 25]
    descricao VARCHAR(255),            -- [cite: 26]
    valor DOUBLE,                      -- [cite: 27]
    data VARCHAR(20),                  -- [cite: 30]
    tipo VARCHAR(10)                   -- [cite: 31]
);
