# CRUD de Clientes
Create / Read / Update / Delete

A aplicação consiste na criação de uma API para acesso de recursos de CRUD completo de Web Services Rest.
Utilizando a versão 11 do Java (Java 11 LTS) e o projeto Spring Boot 2.4.x.

- Consulta Páginada
- Consulta por Id
- Atualização de Registro
- Inseração de novo Registro
- Exclusão de Registro

## Modelo Conceitual do CRUD de Clientes
![Modelo Conceitual](https://github.com/eliasneri/DsCatalogClient/blob/main/backEnd/assets/clientUML.png)

Um cliente possui nome, CPF, renda, data de nascimento, e quantidade de filhos. (conforme no diagrama abaixo)


# Tecnologias utilizadas
- Java
- Spring Boot
- JPA / Hibernate
- Maven

# Como executar o projeto
Pré-requisitos: Java 11

```bash
# clonar repositório
git clone https://github.com/eliasneri/DsCatalogClient.git

# entrar na pasta do projeto back end
cd backend

# executar o projeto
./mvnw spring-boot:run
```

## End Points
Busca paginada de clientes

```bash

GET /clients?page=0&linesPerPage=6&direction=ASC&orderBy=name

```

Busca de cliente por id
```bash

GET /clients/1

```

Busca total de clientes

```bash

GET /all

```

Inserção de novo cliente
```bash

POST /clients
{
  "name": "Maria Silva",
  "cpf": "12345678901",
  "income": 6500.0,
  "birthDate": "1994-07-20T10:30:00Z",
  "children": 2
}

```

Atualização de cliente
```bash

PUT /clients/1
{
  "name": "Maria Silvaaa",
  "cpf": "12345678901",
  "income": 6500.0,
  "birthDate": "1994-07-20T10:30:00Z",
  "children": 2
}

```

Deleção de cliente
```bash

DELETE /clients/1

```

## Autor

Elias Antonio Néri<br>
https://linkedin.com/in/elias-neri

Curriculum em HTML e CSS<br>
https://eliasneri.github.io/Curriculum/
