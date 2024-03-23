-- create database locadora;


create table Filmes(
    id_filme SERIAL PRIMARY KEY,
    titulo VARCHAR(255),
    duracao INT,
    genero VARCHAR(45)
);

