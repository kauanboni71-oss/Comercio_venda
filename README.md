# 🛒 Sistema de Vendas - Grupo 4

<div align="center">

<img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/java/java-original.svg" width="70" />
<img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/mysql/mysql-original.svg" width="70" />
<img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/maven/maven-original.svg" width="70" />
<img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/git/git-original.svg" width="70" />

</div>

---

Projeto desenvolvido para a disciplina de **Aplicações de Linguagem de Programação Orientada a Objetos**, como parte de uma atividade acadêmica, utilizando **Java, Swing, JDBC e MySQL**.

A proposta do projeto foi desenvolver uma aplicação desktop com interface gráfica para registro de vendas, colocando em prática conceitos de **Programação Orientada a Objetos**, **interface gráfica com Swing**, **conexão com banco de dados via JDBC** e uso de **funções agregadas SQL (SUM)**.

---

## 🚀 Tecnologias utilizadas

<div align="center">

<img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/java/java-original.svg" width="50" />
<img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/mysql/mysql-original.svg" width="50" />
<img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/maven/maven-original.svg" width="50" />
<img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/git/git-original.svg" width="50" />

</div>

- **Java** — linguagem principal do projeto
- **Swing** — biblioteca para criação da interface gráfica
- **JDBC** — API para conexão com o banco de dados
- **MySQL** — banco de dados relacional
- **Maven** — gerenciamento de dependências e build
- **Padrão MVC** — organização em Model, View e Controller

---

## 📚 Sobre o projeto

Este foi um dos projetos desenvolvidos durante a faculdade de **Ciência da Computação**.

O projeto teve como objetivo colocar na prática conhecimentos de **desenvolvimento desktop com Java**, incluindo:

- Criação de interface gráfica com **Swing**;
- Conexão com banco de dados **MySQL** via **JDBC**;
- Aplicação do padrão **MVC** (Model-View-Controller);
- Uso de **funções agregadas SQL** (`SUM`);
- Organização em camadas (`Model`, `View`, `DAO`);
- Tratamento de exceções com `try/catch`;
- Boas práticas com `PreparedStatement`.

---

## 🎯 Objetivo

Criar uma aplicação que permita ao usuário **selecionar produtos**, **inserir vendas** no banco de dados e **visualizar o total geral** das vendas realizadas, usando a função `SUM` do SQL.

---

## ⚙️ Funcionalidades

- ✅ Selecionar produtos com **checkboxes**
- ✅ Inserir apenas os produtos marcados no banco de dados
- ✅ Exibir o **total geral** das vendas com `SUM`
- ✅ Limpar a tela e opcionalmente apagar os dados do banco
- ✅ Confirmação antes de apagar os dados
- ✅ Mensagens de erro

---

## 🗂️ Estrutura do projeto

```
comercio/
├── Comercio.java         // Classe principal (main)
├── ConexaoBd.java        // Conexão com o MySQL
├── Venda.java            // Model (dados da venda)
├── VendaConect.java      // DAO (acesso ao banco)
└── TelaVenda.java        // View (interface Swing)
```
## 👥 Integrantes do Grupo 4

- Felipe Gabriel
- Gabrielle Garcia
- Kauan Boni
- Leticia Alves
- Marcele Silva
- Rafaela Pupim
- Yasmim Santos
