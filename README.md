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