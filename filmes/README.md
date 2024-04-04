# Projeto de Cadastro de Filmes
Este projeto consiste em um aplicativo Java para cadastro de filmes em um banco de dados PostgreSQL. O aplicativo permite ao usuário inserir informações sobre filmes, como título, duração e gênero, e armazená-las no banco de dados.

## Pré-requisitos
Para executar este projeto, é necessário ter instalado:

Java Development Kit (JDK)
PostgreSQL
Além disso, é necessário baixar o driver JDBC do PostgreSQL para permitir a conexão com o banco de dados. O driver pode ser baixado aqui:
```bash
https://jdbc.postgresql.org/download/
```
Neste projeto, estou utilizando a IDE VSCode, então adiciono o driver na opção:
- Java Projects
- Referenced Libraries+ (selecionar o local onde o driver foi baixado)

### Configuração do Banco de Dados
Antes de executar o aplicativo, é necessário configurar o banco de dados PostgreSQL. Certifique-se de criar um banco de dados chamado locadora e uma tabela chamada filmes com a seguinte estrutura:

```bash
CREATE TABLE Filmes (
    id_filme SERIAL PRIMARY KEY,
    título VARCHAR(255),
    duracao INT,
    gênero VARCHAR(45)
);
```
### Execução do Aplicativo:

Baixe o projeto para o seu ambiente local.
Certifique-se de ter o driver JDBC do PostgreSQL baixado e configurado no seu projeto.
Compile e execute o arquivo App.java.

### Funcionalidades
Cadastro de novos filmes com título, duração e gênero.
Armazenamento dos dados dos filmes no banco de dados PostgreSQL.

### Contribuição:
Contribuições são sempre bem-vindas! Se você encontrou algum problema no código ou tem alguma sugestão de melhoria, sinta-se à vontade para abrir uma issue ou enviar um pull request.
