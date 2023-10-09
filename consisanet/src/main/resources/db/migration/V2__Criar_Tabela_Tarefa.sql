CREATE TABLE tarefa (
    id SERIAL PRIMARY KEY,
    data_inicio DATE,
    data_fim DATE,
    nome_tarefa VARCHAR(255),
    situacao VARCHAR(255),
    usuario_responsavel_id BIGINT,
    tarefa_principal_id BIGINT,
    FOREIGN KEY (usuario_responsavel_id) REFERENCES usuario(id),
    FOREIGN KEY (tarefa_principal_id) REFERENCES tarefa(id)
);