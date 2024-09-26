# 📈 API de Cotações de Moedas

Este projeto é uma aplicação Spring Boot que obtém taxas de câmbio de moedas a partir da [Open Exchange Rates](https://openexchangerates.org) e fornece funcionalidades para consultar, armazenar e gerenciar essas taxas. A aplicação utiliza o padrão Adapter para converter as taxas de câmbio para a moeda base **BRL** (Real Brasileiro).

## 🚀 Funcionalidades

- **📊 Buscar e armazenar taxas de câmbio** da API Open Exchange Rates.
- **🔍 Consultar todas as taxas armazenadas** ou uma taxa específica por ID.
- **🗑️ Deletar registros de taxas de câmbio**.
- **🔄 Converter taxas de câmbio** para Real Brasileiro e outras moedas.
- **🌐 Endpoints RESTful** para interação com as cotações.

## 🗂 Estrutura do Projeto

A aplicação está dividida nos seguintes componentes principais:

### 1. **Adapter**

Componente responsável por:

- Converter os dados brutos de taxas de câmbio da API Open Exchange Rates para a moeda base **BRL**.
- Formatar o timestamp da resposta da API em uma data e hora legíveis.

### 2. **CotacaoController**

Controlador que expõe os endpoints REST para interação com os dados de câmbio:

- `GET /cotacoes` - Recupera todas as taxas de câmbio armazenadas.
- `GET /cotacoes/{id}` - Recupera uma taxa de câmbio específica pelo ID.
- `POST /cotacoes` - Armazena uma nova taxa de câmbio.
- `DELETE /cotacoes/{id}` - Deleta uma taxa de câmbio pelo ID.

### 3. **OpenExchangeService**

Interface que utiliza o cliente Feign para:

- Fazer chamadas à API Open Exchange Rates.
- Obter as últimas taxas de câmbio para as moedas especificadas.

### 4. **CotacaoService**

Serviço que contém a lógica de negócio para:

- Buscar e armazenar as taxas de câmbio.
- Converter a resposta da API usando o **Adapter**.
- Salvar as cotações no banco de dados.

### 5. **Cotacao**

Entidade que representa a taxa de câmbio armazenada no banco de dados, incluindo:

- `id`: Identificador único da cotação.
- `moedasPesquisadas`: Moedas para as quais a taxa foi consultada.
- `data`: Data e hora da cotação.
- `base`: Moeda base para conversão (sempre "BRL").
- `cotacoes`: Mapa com as cotações das diferentes moedas.

## 🛠 Tecnologias Utilizadas

- **Java 17**
- **Spring Boot 3**
- **Spring Data JPA**
- **Feign Client**
- **Open Exchange Rates API**
- **H2 Database** (ou outro banco de dados à escolha)
- **Mockito** para testes unitários

## 📝 Observações

- Este projeto usa a API Open Exchange Rates com um **app_id** (chave de API). Certifique-se de configurar a chave no arquivo `application.properties`:
  ```properties
  app_id=coloque_sua_chave_aqui

### ✨ Desenvolvido com ❤️ por Murilo Luzzi
