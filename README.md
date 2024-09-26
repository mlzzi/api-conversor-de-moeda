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

- No futuro vou colocar um GET para buscar quais cotações utilizar. Por hora vou colocar as moedas aqui.
- Este projeto usa a API Open Exchange Rates com um **app_id** (chave de API). Certifique-se de configurar a chave no arquivo `application.properties`:
  ```properties
  app_id=coloque_sua_chave_aqui

### ✨ Desenvolvido com ❤️ por Murilo Luzzi

## Moedas e suas Abreviações para buscar na API. Utilizar as abreviações em Capslock:

- **AED**: Dirham dos Emirados Árabes Unidos
- **AFN**: Afghani Afegão
- **ALL**: Lek Albanês
- **AMD**: Dram Armênio
- **ANG**: Florim das Antilhas Neerlandesas
- **AOA**: Kwanza Angolano
- **ARS**: Peso Argentino
- **AUD**: Dólar Australiano
- **AWG**: Florim Arubano
- **AZN**: Manat Azerbaijano
- **BAM**: Marco Conversível da Bósnia-Herzegovina
- **BBD**: Dólar Barbadense
- **BDT**: Taka Bangladês
- **BGN**: Lev Búlgaro
- **BHD**: Dinar Bahreinita
- **BIF**: Franco Burundense
- **BMD**: Dólar Bermudense
- **BND**: Dólar de Brunei
- **BOB**: Boliviano Boliviano
- **BRL**: Real Brasileiro
- **BSD**: Dólar Bahamense
- **BTC**: Bitcoin
- **BTN**: Ngultrum Butanês
- **BWP**: Pula de Botsuana
- **BYN**: Rublo Bielorrusso
- **BZD**: Dólar de Belize
- **CAD**: Dólar Canadense
- **CDF**: Franco Congolês
- **CHF**: Franco Suíço
- **CLF**: Unidade de Conta Chilena (UF)
- **CLP**: Peso Chileno
- **CNH**: Yuan Chinês (Offshore)
- **CNY**: Yuan Chinês
- **COP**: Peso Colombiano
- **CRC**: Colón Costarriquenho
- **CUC**: Peso Cubano Conversível
- **CUP**: Peso Cubano
- **CVE**: Escudo Cabo-Verdiano
- **CZK**: Coroa Checa
- **DJF**: Franco Djibutiense
- **DKK**: Coroa Dinamarquesa
- **DOP**: Peso Dominicano
- **DZD**: Dinar Argelino
- **EGP**: Libra Egípcia
- **ERN**: Nakfa Eritreia
- **ETB**: Birr Etíope
- **EUR**: Euro
- **FJD**: Dólar Fijiano
- **FKP**: Libra das Ilhas Falkland
- **GBP**: Libra Esterlina Britânica
- **GEL**: Lari Georgiano
- **GGP**: Libra de Guernsey
- **GHS**: Cedi Ganês
- **GIP**: Libra de Gibraltar
- **GMD**: Dalasi Gambiano
- **GNF**: Franco Guineano
- **GTQ**: Quetzal Guatemalteco
- **GYD**: Dólar Guyanense
- **HKD**: Dólar de Hong Kong
- **HNL**: Lempira Hondurenha
- **HRK**: Kuna Croata
- **HTG**: Gourde Haitiano
- **HUF**: Forint Húngaro
- **IDR**: Rupia Indonésia
- **ILS**: Novo Shequel Israelense
- **IMP**: Libra de Man
- **INR**: Rúpia Indiana
- **IQD**: Dinar Iraquiano
- **IRR**: Rial Iraniano
- **ISK**: Coroa Islandesa
- **JEP**: Libra de Jersey
- **JMD**: Dólar Jamaicano
- **JOD**: Dinar Jordaniano
- **JPY**: Iene Japonês
- **KES**: Xelim Queniano
- **KGS**: Som Quirguiz
- **KHR**: Riel Cambojano
- **KMF**: Franco Comorense
- **KPW**: Won Norte-Coreano
- **KRW**: Won Sul-Coreano
- **KWD**: Dinar Kuaitiano
- **KYD**: Dólar das Ilhas Cayman
- **KZT**: Tenge Cazaque
- **LAK**: Kip Laociano
- **LBP**: Libra Libanesa
- **LKR**: Rúpia do Sri Lanka
- **LRD**: Dólar Liberiano
- **LSL**: Loti de Lesoto
- **LYD**: Dinar Líbio
- **MAD**: Dirham Marroquino
- **MDL**: Leu Moldavo
- **MGA**: Ariary Malgaxe
- **MKD**: Dinar Macedônio
- **MMK**: Kyat Mianmar
- **MNT**: Tugrik Mongol
- **MOP**: Pataca Macaense
- **MRU**: Ouguiya Mauritano
- **MUR**: Rúpia Mauriciana
- **MVR**: Rufiyaa Maldiva
- **MWK**: Kwacha Malawiano
- **MXN**: Peso Mexicano
- **MYR**: Ringgit Malaio
- **MZN**: Metical Moçambicano
- **NAD**: Dólar Namibiano
- **NGN**: Naira Nigeriana
- **NIO**: Córdobas Nicaraguenses
- **NOK**: Coroa Norueguesa
- **NPR**: Rúpia Nepalense
- **NZD**: Dólar Neozelandês
- **OMR**: Rial Omanense
- **PAB**: Balboa Panamenho
- **PEN**: Novo Sol Peruano
- **PGK**: Kina da Papua Nova Guiné
- **PHP**: Peso Filipino
- **PKR**: Rúpia Paquistanesa
- **PLN**: Zloty Polonês
- **PYG**: Guarani Paraguaio
- **QAR**: Rial Qatarense
- **RON**: Leu Romeno
- **RSD**: Dinar Servo
- **RUB**: Rublo Russo
- **RWF**: Franco Ruandense
- **SAR**: Rial Saudita
- **SBD**: Dólar das Ilhas Salomão
- **SCR**: Rúpia Seychelles
- **SDG**: Libra Sudanesa
- **SEK**: Coroa Sueca
- **SGD**: Dólar de Singapura
- **SHP**: Libra de Santa Helena
- **SLL**: Leone de Serra Leoa
- **SOS**: Xelim Somali
- **SRD**: Dólar Surinamês
- **SSP**: Libra do Sudão do Sul
- **STD**: Dobra de São Tomé e Príncipe (pré-2018)
- **STN**: Dobra de São Tomé e Príncipe
- **SVC**: Colón Salvadorenho
- **SYP**: Libra Síria
- **SZL**: Lilangeni Suázi
- **THB**: Baht Tailandês
- **TJS**: Somoni Tajique
- **TMT**: Manat Turcomeno
- **TND**: Dinar Tunisiano
- **TOP**: Pa'anga Tonganesa
- **TRY**: Lira Turca
- **TTD**: Dólar de Trinidad e Tobago
- **TWD**: Novo Dólar de Taiwan
- **TZS**: Xelim Tanzaniano
- **UAH**: Grivna Ucraniana
- **UGX**: Xelim Ugandense
- **USD**: Dólar dos Estados Unidos
- **UYU**: Peso Uruguaio
- **UZS**: Som Uzbeque
- **VEF**: Bolívar Fuerte Venezuelano (Antigo)
- **VES**: Bolívar Soberano Venezuelano
- **VND**: Dong Vietnamita
- **VUV**: Vatu de Vanuatu
- **WST**: Tala Samoano
- **XAF**: Franco CFA BEAC
- **XAG**: Onça de Prata
- **XAU**: Onça de Ouro
- **XCD**: Dólar do Caribe Oriental
- **XDR**: Direitos Especiais de Saque
- **XOF**: Franco CFA BCEAO
- **XPD**: Onça de Paládio
- **XPF**: Franco CFP
- **XPT**: Onça de Platina
- **YER**: Rial Yemenita
- **ZAR**: Rand Sul-Africano
- **ZMW**: Kwacha Zambiano
- **ZWL**: Dólar Zimbabuense

