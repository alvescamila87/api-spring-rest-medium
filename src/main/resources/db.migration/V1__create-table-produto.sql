CREATE TABLE produto (
    id TEXT PRIMARY KEY UNIQUE NOT NULL,
    categoria TEXT NOT NULL,
    descricao TEXT NOT NULL,
    valor INT NOT NULL
);