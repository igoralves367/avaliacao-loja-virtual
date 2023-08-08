# Projeto Loja Virtual - Desafio Siteware
Este projeto apresenta um protótipo funcional da Loja Virtual da Siteware, um módulo de e-commerce. O objetivo é desenvolver uma aplicação que permita a gestão de produtos, cálculo de preços com promoções e funcionalidades de carrinho de compras.

Este projeto consiste em uma aplicação de loja virtual com as seguintes funcionalidades:

## Funcionalidades

### Produto

1. **Cadastrar Produto (POST)**: Cria um novo produto no sistema.
2. **Listar Todos os Produtos (GET)**: Retorna uma lista de todos os produtos cadastrados.
3. **Consultar Produto (GET)**: Retorna detalhes de um produto específico.
4. **Alterar Produto (PATCH)**: Atualiza informações de um produto existente.
5. **Deletar Produto (DELETE)**: Remove um produto do sistema.

### Carrinho de Compras

1. **Criar Carrinho de Compras**: Cria um novo carrinho de compras.
2. **Adicionar Item ao Carrinho (POST)**: Adiciona um produto e sua quantidade ao carrinho.
3. **Listar Itens do Carrinho (GET)**: Retorna a lista de itens presentes no carrinho.

## Tecnologias Utilizadas

- Java 11
- Spring Boot
- Spring Data JPA
- Hibernate
- H2 Database (em memória)
- Swagger para documentação da API: [http://localhost:8080/loja-virtual/api/public/swagger](http://localhost:8080/loja-virtual/api/public/swagger)
- Testes Unitários com JUnit

## Instruções para Rodar o Projeto

1. Clone este repositório para sua máquina local:

   ```bash
   git clone https://github.com/igoralves367/avaliacao-loja-virtual.git

2. Acesse a pasta raiz do projeto: cd avaliacao-loja-virtual

3. Execute a classe principal para rodar o projeto:
LojaVirtualApplication.java

Acesse a documentação Swagger da API em seu navegador:
http://localhost:8080/loja-virtual/api/public/swagger

Você também pode utilizar o Postman para testar as funcionalidades da API. A coleção do Postman está disponível neste link: 

Este é um guia básico para rodar e entender as funcionalidades deste projeto de loja virtual. Certifique-se de que tem o Java 11 e o Maven instalados em seu ambiente para executar o projeto sem problemas. Se desejar, você pode personalizar e expandir este projeto de acordo com as necessidades específicas da empresa Siteware.
