# 📦 Sistema de Gerenciamento de Fornecedores

Projeto desenvolvido para a disciplina de Projeto Integrador da UNIVESP – Polo Mauá.  
  
O tema é: Desenvolvimento de um software com framework web que utilize noções de banco de dados, praticando controle de versão.  
  
O sistema permite o **cadastro**, **edição**, **remoção** e **visualização** de fornecedores, com uma interface web simples e funcional construída com **Spring Boot**, **Thymeleaf** e **MySQL**.

---

## 👥 Membros do grupo

- JAIME ALVES PEREIRA  
- WILLIANS APARECIDO DO CARMO  
- FLAVIO DA SILVA HIPOLITO  
- ISABELA DE ARAUJO FEITOSA  
- GABRIEL ELIZEU ALVES DE SIQUEIRA  
- ALEQUIS SANDRO BINDER  
- GUILHERME VEDOVATE  
- DAVID WILLIAM DA SILVA  

---

## 🚀 Tecnologias utilizadas

- Java 21  
- Spring Boot 3.4.4  
- Spring Web, Data JPA e Validation  
- Thymeleaf  
- MySQL 8  
- Maven  

---

## 🛠️ Requisitos

- Java 21 instalado  
- MySQL rodando localmente (ou remotamente)  
- Maven instalado ou uso do wrapper incluído no projeto  

---

## ⚙️ Configuração do banco de dados

### 1. Crie o banco e a tabela no MySQL:

```sql
CREATE DATABASE fornecedores_db;

USE fornecedores_db;

CREATE TABLE `fornecedores` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `comentario` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `material` varchar(255) DEFAULT NULL,
  `nome` varchar(255) DEFAULT NULL,
  `telefone` varchar(20) DEFAULT NULL,
  `valor` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
```

### 2. Configure o arquivo `application.properties`

Edite o arquivo `src/main/resources/application.properties` com suas credenciais do banco:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/fornecedores_db
spring.datasource.username=SEU_USUARIO
spring.datasource.password=SUA_SENHA
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect

spring.thymeleaf.cache=false
server.port=8080
```

> 🔐 Substitua `SEU_USUARIO` e `SUA_SENHA` pelas credenciais corretas do seu MySQL.

---

## ▶️ Como executar o projeto

### Usando terminal:

```bash
./mvnw spring-boot:run
```

No Windows:

```bash
mvnw.cmd spring-boot:run
```

### Usando IDE:

Abra o projeto na sua IDE (IntelliJ, Eclipse, VSCode...) e execute a classe principal com `@SpringBootApplication`.

---

## 🌐 Acessar aplicação

Após subir, acesse no navegador:

```
http://localhost:8080
```

---
