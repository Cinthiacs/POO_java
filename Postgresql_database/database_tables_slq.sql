--create database armazem;
select * from produtos;
-- create table Produtos(
-- 	id serial primary key,
-- 	nome_produto varchar (100),
-- 	descricao_produto varchar (100),
-- 	preco_produto numeric(7,2),
-- 	codigo_produto varchar (100),
-- 	categoria_produto varchar (100),
-- 	quantidade_estoque numeric (100),
-- 	disponibilidade_produto varchar(10),
-- 	data_validade_produto varchar(10)
-- );

-- create table hortifrutis(
-- 	id serial primary key,
-- 	nome_produto varchar(50),
-- 	tipo varchar(50),
-- 	preco_kg numeric(7,2)
-- );

-- create table laticinios(
-- 	id serial primary key,
-- 	nome_produto varchar(50),
-- 	tipo varchar(50),
-- 	preco_unidade numeric(7,2),
-- 	preco_kg numeric(7,2)
-- );

-- create table carnes(
-- 	id serial primary key,
-- 	nome_produto varchar (50),
-- 	tipo varchar (50),
-- 	preco_kg numeric (7,2)
-- );

-- create table padaria(
-- 	id serial primary key,
-- 	nome_produto varchar(50),
-- 	tipo varchar (50),
-- 	preco_kg numeric (7,2),
--  	preco_unidade numeric (7,2)
-- );

--  create table bebidas(
--  	id serial primary key,
-- 	nome_produto varchar (50),
-- 	tipo varchar (50),
-- 	preco_unidade numeric (7,2)
--  );
 
--  create table nao_pereciveis(
--  	id serial primary key,
-- 	nome_produto varchar (50),
-- 	tipo varchar (50),
-- 	preco_unidade numeric(7,2)
--  );
  
--  create table higiene_pessoal(
--   	id serial primary key,
-- 	nome_produto varchar (50),
-- 	tipo varchar (50),
-- 	preco_unidade numeric(7,2)
--  );
 
--  create table produtos_limpeza(
--  	id serial primary key,
-- 	nome_produto varchar (50),
-- 	tipo varchar (50),
-- 	preco_unidade numeric(7,2)
--  );
 
--  create table cadastro_servico_cliente(
--  	id serial primary key,
-- 	nome_cliente varchar (50),
-- 	cpf numeric (20),
-- 	logradouro (100),
-- 	numero numeric(10),
-- 	complemento varchar (20)
-- 	bairro varchar (100),
-- 	cep numeric (12),
-- 	cidade varchar (100),
-- 	estado varchar (5)	
--  );
 
--  create table pedidos_cliente(
--  	id serial primary key,
-- 	id_cliente int,
-- 	pedido_cliente_hortifruti varchar(200),
-- 	pedido_cliente_laticinios varchar(200),
-- 	pedido_cliente_carnes varchar(200),
-- 	pedido_cliente_padaria varchar(200), 
-- 	pedido_cliente_bebidas varchar(200),
-- 	pedido_cliente_nao_pereciveis varchar(200),
-- 	pedido_higiene_pessoal varchar(200), 
-- 	pedido_prod_limpeza varchar(200),
-- 	pedido_recarga_celular numeric (7,2),
-- 	encomenda_padaria varchar (200),
	
-- 	foreing key (id_cliente) references cadastro_servico_cliente(id)
--  );
 
 



