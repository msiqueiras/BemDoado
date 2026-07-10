# BemDoado - Sistema de Hemocentro Digital
BemDoado é um sistema desenvolvido como projeto final da disciplina de Programação de Computadores II da 
Faculdade de Computação (FACOMP) da Universidade Federal do Pará (UFPA), ofertada no período de 2026.2
e ministrada pela Profa. Dra. Flávia Monteiro

Desenvolvido pelos discentes:
* Bruno Farias Amaral - 202511140028
* João Vitor Martins Ferreira Maia - 202511140030
* Maria Luiza Rodrigues Siqueira - 202511140013

### O que é o BemDoado?
BemDoado é um sistema de administração de estoques
de sangue. Ele é responsável por controlar as quantias das tipagens
sanguíneas (A, B, AB, O) juntamente aos seus fatores Rh, registrar 
entradas e saídas de bolsas de sangue e gerenciar dados dos doadores.

![logo_bem_doado](logo_bemdoado.jpg)

---
## Requisitos do sistema

### Requisitos Funcionais

* RF01 - Cadastrar Doador
* RF02 - Consultar Doador
* RF03 - Atualizar dados do doador
* RF04 - Verificar aptidão para doação
* RF05 - Registrar doação 
* RF06 - Registrar saída de sangue
* RF07 - Consultar estoque
* RF08 - Emitir alerta de estoque baixo
* RF09 - Consultar histórico de doação de um doador
* RF10 - Consultar movimentações do estoque

### Requisitos Não Funcionais

* RNF01 - O sistema deve ser desenvolvido em Java 21
* RNF02 - O sistema deve utilizar Programação Orientada a Objetos
* RNF03 - A interface deve ser executada em console

### Regras de Negócio

* RN01 - O doador deve possuir mais de 16 anos
* RN02 - Em caso de doador menor de idade, o doador precisa possuir autorização formal do responsável
* RN03 - O doador deve possuir até 69 anos de idade
* RN04 - O doador deve possuir mais de 50kg
* RN05 - O doador regular só pode doar de 2 em 2 meses se for do sexo masculino, 3 em 3 meses se for do sexo feminino
* RN06 - Não pode existir mais de um doador com o mesmo CPF
* RN07 - O estoque nunca pode ser menor que zero
* RN08 - Uma bolsa retirada deve existir no estoque
* RN09 - Um doador só pode doar se for considerado APTO
* RN10 – Cada doação registrada deve atualizar automaticamente o estoque do tipo sanguíneo correspondente
----

## Documentação e organização do projeto
A documentação do projeto está na pasta `docs` e conta com os artefatos de diagramação de casos de uso, de classes e de 
sequência, além de contar com o documento de especificação do sistema.



```
BemDoado/
│
├── src/
│   ├── Main.java
│   │
│   ├── model/
│   │   ├── Pessoa.java
│   │   ├── Doador.java
│   │   ├── Doacao.java
│   │   ├── ...
│   │   
│   ├── service/
│   │   ├── DoadorService.java
│   │   ├── DoacaoService.java
│   │   ├── EstoqueService.java
│   │   ├── ...
│   │
│   ├── repository/
│   │
│   └── view/
│       └── Menu.java
│
├── docs/
│
└── README.md
```
---
## Como executar

### Pré-requisitos

- Java Development Kit (JDK) 21 ou superior.
- Uma IDE compatível com Java, como IntelliJ IDEA, Eclipse ou Visual Studio Code com as extensões para Java.

### Executando o projeto

1. Clone ou faça o download deste repositório.
2. Abra a pasta do projeto na IDE de sua preferência.
3. Certifique-se de que o projeto está configurado para utilizar o JDK 21.
4. Execute a classe `Main.java`.
5. O menu principal do sistema será exibido no console.