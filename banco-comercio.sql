CREATE DATABASE IF NOT EXISTS comercio;

USE comercio;

CREATE TABLE IF NOT EXISTS vendas (
    id INT PRIMARY KEY AUTO_INCREMENT,
    produto VARCHAR(100) NOT NULL,
    quantidade INT NOT NULL,
    valortotal DOUBLE NOT NULL
);

select * from vendas;
