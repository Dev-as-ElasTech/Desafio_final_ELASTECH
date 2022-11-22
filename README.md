# Desafio_final_ELASTECH

<h1 align="center"><img src="https://user-images.githubusercontent.com/109546269/203392670-e81ac46e-c147-459a-b0dd-a118e778da9d.jpg" width="400" height="341"></h1>

<h2>Status do Projeto</h2>

![Badge em Desenvolvimento](http://img.shields.io/static/v1?label=STATUS&message=EM%20DESENVOLVIMENTO&color=GREEN&style=for-the-badge)
![GitHub Org's stars](https://img.shields.io/github/stars/camilafernanda?style=social)

# Índice
<!--ts-->
   * [Sobre](#sobre)
   * [Requisitos](#requisitos)
   * [Estruturação de Dados](#estruturação-de-dados)
   * [Documentação da API](#documentação-da-api)
       * [Cadastro do cliente](#cadastro-do-cliente)
       * [Rota de Contas](#rota-de-contas)
       * [Rotas de Endereço](#rotas-de-endereço)
       * [Rotas de Transações](#rotas-de-transações)
   * [Ferramentas e Tecnologias](#ferramentas-e-tecnologias)
 
<!--te-->
 
 # 🧾Sobre
 
 Desenvolvimento de API de simulação de banco, com operações bancárias do dia a dia, obedencendo algumas entregas mínimas como:
  
  
- [x] Cadastro de Clientes<br>
- [x] Buscar os Clientes Cadastrados<br>
- [x] Transferências de saldo entre as contas<br>
- [x] Buscar o histórico de transações entre as contas<br>

# Requisitos 

<img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/java/java-original.svg" width="50" height="50"/> <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/mysql/mysql-original.svg" width="40" height="40"/> <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/intellij/intellij-original.svg" width="40" height="40"/><img src="https://cdn.worldvectorlogo.com/logos/postman.svg" width="40" height="40"/>

* Ter instalado na sua máquina: MySQL, uma IDE (recomendamos o Intellij) e Java.
* Como rodar a aplicação: Clone este repositório
* Configure o arquivo application.properties com seu dados pessoais do Banco de dados de MySql: o SQL para popular o banco de dados no MySQL Workbench se encontra na pasta `bancoDeDados` e o arquivo é chamado de `bd_divasbank.sql`.
* Caso prefira utilizar o banco de dados H2, o projeto já possui esta dependência.
* Acesse a pasta do projeto no terminal/cmd e vá para a pasta do Divas Bank,
* Execute a aplicação: o servidor entra pela porta 8080.


# Estruturação de Dados

<h1 align="center"><img src="https://user-images.githubusercontent.com/109546269/203402084-b687350d-418c-4ee4-ac2e-070c1db0ae80.png"></h1>

# Arquitetura da API
 
 <h1 align="center"><img src="https://user-images.githubusercontent.com/79167856/202822321-c0bd3a98-ace6-485e-a830-0e95d8e4388a.jpeg"></h1>

# Documentação da API

## Modelo Postman
- Caso tenha interesse:
    - O documento chamado `divasBank_postman_collection.json` que está na pasta `postman` disponibiliza os modelos das rotas da API que foram testadas no Postman.

## Cadastro do cliente
```http
  POST/SEU-SERVER/cliente
```
Passar parâmetros no body da requisição em formato JSON:

| Parâmetro   | Tipo       | Descrição                           |
| :---------- | :--------- | :---------------------------------- |
| `nome` | `String` | **Obrigatório** |
| `cpf` | `String` | **Obrigatório**. Campo único e não editável.|
| `email` | `String` | **Obrigatório**. Campo único.|
| `dataNascimento` | `String` | **Obrigatório**. Não editável.|
| `telefone` | `String` | **Obrigatório**.|
| `rendaMensal` | `Double` | **Obrigatório**. |
| `ativo` | `Boolean` | **Opcional**. Default = true |
| `Agencia` | `Integer` | A agencia é enviada automaticamente e tem o valor Default de 1 |
| `conta` | Relacionamento com tabela conta | **Obrigatório**. A conta é criada somente quando o cliente for cadastrado. Não podendo ser cadastada separadamente.| 
| `numero` | `Long` | O numero é enviado automaticamente e randomicamente. Possui 4 dígitos. Este campo não pode ser editado|
| `digito` | `Integer` | O dígito é enviado automaticamente e randomicamente. Possui 1 dígito. Este campo não pode ser editado|
| `saldo` | `Double` | **Opcional**. Default = 0.00 |
| `ativo` | `Boolean` | **Opcional**. Default = true |
| `endereco` | Relacionamento com tabela endereco | **Obrigatório**. A endereço é criado somente quando o cliente for cadastrado. Não podendo ser cadastrado separadamente.| 
| `rua` | `String` | **Obrigatório**.|
| `numero` | `String` | **Obrigatório**.|
| `bairro` | `String` | **Obrigatório**.|
| `estado` | `String` | **Obrigatório**.|
| `cep` | `String` | **Obrigatório**.|
| `pais` | `String` | **Obrigatório**.|



#### Retorna todos os clientes cadastrados

```http
  GET/SEU-SERVER/cliente
```

#### Retorna um cliente pelo seu id

```http
  GET/SEU-SERVER/cliente/{id}
```
| Parâmetro   | Descrição                                   |
| :---------- | :------------------------------------------ |
| `id`       | **Obrigatório** passar como parâmetro na URL da requisição. O ID do cliente que você quer detalhar.|


#### Editar um cliente (update) pelo seu Id

```http
  PUT/SEU-SERVER/cliente/{id}
```
Passar parâmetros no body da requisição em formato JSON:


| Parâmetro   | Tipo       | Descrição                           |
| :---------- | :--------- | :---------------------------------- |
| `nome` | `String` | **Opcional** |
| `email` | `String` | **Opcional**. Campo único |
| `telefone` | `String` | **Opcional**.|
| `rendaMensal` | `Double` | **Opcional**.|
| `conta` | Relacionamento com tabela conta | **Opcional**. |
| `saldo` | `Double` | **Opcional**|
| `endereco` | Relacionamento com tabela endereco | **Opcional**.| 
| `rua` | `String` | **Opcional**.|
| `numero` | `String` | **Opcional**.|
| `bairro` | `String` | **Opcional**.|
| `estado` | `String` | **Opcional**.|
| `cep` | `String` | **Opcional**.|
| `pais` | `String` | **Opcional**.|


#### Soft delete de um cliente - Inativar
```http
  PUT/SEU-SERVER/cliente/inativar/{id}
```
| Parâmetro   | Descrição                                   |
| :---------- | :------------------------------------------ |
| `id`       | **Obrigatório** passar como parâmetro na URL da requisição. O ID do cliente que você quer inativar.|

 Obs: Ao inativar o cliente automaticamente a conta será inativada. 

## Rota de contas

#### Retorna todos as contas cadastradas

```http
  GET/SEU-SERVER/conta
```

#### Retorna uma conta pelo seu id

```http
  GET/SEU-SERVER/conta/{id}
```
| Parâmetro   | Descrição                                   |
| :---------- | :------------------------------------------ |
| `id`       | **Obrigatório** passar como parâmetro na URL da requisição. O ID da conta que você quer detalhar.|


## Rotas de endereço

#### Retorna todos os endereços cadastrados

```http
  GET/SEU-SERVER/endereco
```

#### Retorna um endereço pelo seu id

```http
  GET/SEU-SERVER/endereco/{id}
```
| Parâmetro   | Descrição                                   |
| :---------- | :------------------------------------------ |
| `id`       | **Obrigatório** passar como parâmetro na URL da requisição. O ID do endereço que você quer detalhar.|


#### Editar um endereço
```http
  PUT/SEU-SERVER/endereco/{id}
```
| Parâmetro   | Descrição                                   |
| :---------- | :------------------------------------------ |
| `id`       | **Obrigatório** passar como parâmetro na URL da requisição. O ID do endereço que você quer editar.|

| Parâmetro   | Tipo       | Descrição                           |
| :---------- | :--------- | :---------------------------------- |
| `rua` | `String` | **Opcional**.|
| `numero` | `String` | **Opcional**.|
| `bairro` | `String` | **Opcional**.|
| `estado` | `String` | **Opcional**.|
| `cep` | `String` | **Opcional**.|
| `pais` | `String` | **Opcional**.|


## Rotas de transações

#### Retorna todas as transações cadastradas

```http
  GET/SEU-SERVER/transacao
```

#### Retorna uma transação pelo seu id

```http
  GET/SEU-SERVER/transacao/{id}
```
| Parâmetro   | Descrição                                   |
| :---------- | :------------------------------------------ |
| `id`       | **Obrigatório** passar como parâmetro na URL da requisição. O ID da transacao que você quer detalhar.|


#### Extrato de transacões pelo número da conta de origem (histórico de transacões)

```http
  GET/SEU-SERVER/transacao/{numeroContaOrigem}
```
| Parâmetro   | Descrição                                   |
| :---------- | :------------------------------------------ |
| `numeroContaOrigem`       | **Obrigatório** passar como parâmetro na URL da requisição. O número da conta de origem com as transacões que quer detalhar.|


#### Cadastro de uma transação (Transferência)
```http
  POST/SEU-SERVER/transacao
```
Passar parâmetros no body da requisição em formato JSON:

| Parâmetro   | Tipo       | Descrição                           |
| :---------- | :--------- | :---------------------------------- |
| `valor` | `String` | **Obrigatório** |
| `numeroContaOrigem` | `String` | **Obrigatório**. |
| `numeroContaDestino`| `String` | **Obrigatório**. |
| `tipoTransacao` | `String` | O tipoTransacao é enviado automaticamente e seu valor Default é "transaferencia". Pois no momento é a única transação que o projeto realiza.|
| `data` | `Date` | A data da transação é enviada automaticamente.|


# 🛠Ferramentas e Tecnologias

<table>
<tr>
	<th>Dependência</th>
	<th>Versão</th>
</tr>
<tr>
	<td>Spring initialzr</td>
	<td><a href="https://start.spring.io/">https://start.spring.io/</a></td>
</tr>
<tr>
	<td>Spring-boot-starter-web</td>
	<td>2.7.5</td>
</tr>
<tr>
	<td>Spring-boot-devtools</td>
	<td>2.7.5</td>
</tr>
<tr>
	<td>Spring-boot-starter-data-jpa</td>
	<td>2.7.5</td>
</tr>
<tr>
	<td>Spring-boot-starter-test</td>
	<td>2.7.5</td>
</tr>
<tr>
	<td>Spring-boot-starter-actuator</td>
	<td><a href="https://localhost:8080/actuator/">https://localhost:8080/actuator/</a></td>
</tr>
<tr>
	<td>Jpa</td>
	<td>17</td>
</tr>
<tr>
	<td>Lombok</td>
	<td>1.18.24</td>
</tr>
<tr>
	<td>Maven</td>
	<td>4</td>
</tr>
<tr>
   <td>Postman</td>
	<td>5.5.6</td>
</tr>
<tr>
	<td>Mysql</td>
	<td>8.0.31</td>
</tr>
</table>

<h3> ❤️ Desenvolvedoras❤️  </h3>

<div>

[![Linkedin Badge](https://img.shields.io/badge/-Bruna-blue?style=flat-square&logo=Linkedin&logoColor=white&link=https://www.linkedin.com/in/bruna-hirano/)](https://www.linkedin.com/in/bruna-hirano/) [![Linkedin Badge](https://img.shields.io/badge/-Luiza-blue?style=flat-square&logo=Linkedin&logoColor=white&link=https://www.linkedin.com/in/luizatrocino/)](https://www.linkedin.com/in/luizatrocino/) [![Linkedin Badge](https://img.shields.io/badge/-Paula-blue?style=flat-square&logo=Linkedin&logoColor=white&link=https://www.linkedin.com/in/paula-cristiane-belmiro-26386859/)](https://www.linkedin.com/in/paula-cristiane-belmiro-26386859/) [![Linkedin Badge](https://img.shields.io/badge/-Rosana-blue?style=flat-square&logo=Linkedin&logoColor=white&link=https://www.linkedin.com/in/rosana-oliveira-47a686244/)](https://www.linkedin.com/in/rosana-oliveira-47a686244/)
[![Linkedin Badge](https://img.shields.io/badge/-Kalliandra-blue?style=flat-square&logo=Linkedin&logoColor=white&link=https://www.linkedin.com/in/kalliandra-carla-de-lima-b68678127/)](https://www.linkedin.com/in/kalliandra-carla-de-lima-b68678127/) [![Linkedin Badge](https://img.shields.io/badge/-Yasmin-blue?style=flat-square&logo=Linkedin&logoColor=white&link=https://www.linkedin.com/in/yasmin-porto-costa/)](https://www.linkedin.com/in/yasmin-porto-costa/) 

</div>
