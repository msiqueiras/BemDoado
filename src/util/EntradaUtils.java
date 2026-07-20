package util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

import model.ResultadoAptidao;
import model.Sexo;
import model.TipoSanguineo;

public class EntradaUtils {

    public static LocalDate lerData(Scanner scanner) {
    // Formatador para a data de nascimento
    DateTimeFormatter formatadorData = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    while (true) {
        try {

        System.out.print("Data de Nascimento (dd/mm/aaaa): ");
            
        return LocalDate.parse(scanner.nextLine(), formatadorData); // retorna data formatada

        } catch (DateTimeParseException e) {
            System.out.println("Erro: Data inválida. Tente novamente.");
        }
    }
    }

    public static String lerNome(Scanner scanner) {
    String nome = "";
    boolean valido = false;

    while (!valido) {
        try {
            System.out.print("Nome completo: ");
            nome = scanner.nextLine().trim();   // lê a linha toda e remove espaços extras

            // Se a string estiver vazia, lança uma exceção
            if (nome.isEmpty()) {
                throw new IllegalArgumentException("Nome não pode ser vazio.");
            }

            valido = true;  // saída do loop se não houve exceção

        } catch (IllegalArgumentException e) {
            // Captura a exceção de string vazia e informa o usuário
            System.out.println("Erro: " + e.getMessage() + " Tente novamente.");
        } catch (Exception e) {
            // Captura qualquer outra exceção inesperada 
            System.out.println("Erro inesperado: " + e.getMessage() + " Tente novamente.");
        }
    }
    return nome;
    }

    public static String lerCPF(Scanner scanner) {
    String cpf = "";
    boolean valido = false;

    while (!valido) {
        try {
            System.out.print("Digite o CPF (apenas números, 11 dígitos): ");
            cpf = scanner.nextLine().trim();   // lê a linha toda e remove espaços extras

            // Verifica se contém apenas números
            boolean apenasNumeros = cpf.matches("^[0-9]+$");
            
            // Validações: não vazio, 11 caracteres e apenas números
            if (cpf.isEmpty()) {
                throw new IllegalArgumentException("CPF não pode ser vazio.");
            } else if (cpf.length() != 11) {
                throw new IllegalArgumentException("CPF deve ter exatamente 11 dígitos. Você digitou " + cpf.length() + " caracteres.");
            } else if (!apenasNumeros) {
                throw new IllegalArgumentException("CPF deve conter apenas números (0-9).");
            }

            valido = true; 

        } catch (IllegalArgumentException e) {
            // Captura a exceção de validação e informa o usuário
            System.out.println("Erro: " + e.getMessage() + " Tente novamente.");
        } catch (Exception e) {
            // Captura qualquer outra exceção inesperada
            System.out.println("Erro inesperado: " + e.getMessage() + " Tente novamente.");
        }
    }
    return cpf;
    }
        
    public static Sexo lerSexo(Scanner scanner) {
    Sexo sexo = null;
    boolean valido = false;

    while (!valido) {
        try {
            // Recebe String com scanner, remove espaços extra e deixa tudo em maiusculo 
            System.out.print("Sexo (MASCULINO ou FEMININO): ");
            sexo = Sexo.valueOf(scanner.nextLine().trim().toUpperCase());

            valido = true; 

        } catch (IllegalArgumentException e) {
            System.out.println("Erro: valor invalido. Tente novamente.");
        } catch (Exception e) {
            // Captura qualquer outra exceção inesperada
            System.out.println("Erro inesperado: " + e.getMessage() + " Tente novamente.");
        }
    }
    return sexo;
    }

    public static String lerTelefone(Scanner scanner) {
    String telefone = "";
    boolean valido = false;

    while (!valido) {
        try {
            System.out.print("Numero de Telefone (ex: 21988887777): ");
            telefone = scanner.nextLine().trim(); // Le a linha e remove espaços extra

            // Verifica se contém apenas números
            boolean apenasNumeros = telefone.matches("^[0-9]+$");

            // Validações: não vazio, 11 caracteres e apenas números
            if (telefone.isEmpty()) {
                throw new IllegalArgumentException("O Telefone não pode ser vazio.");
            } else if (telefone.length() != 11) {
                throw new IllegalArgumentException("O Telefone deve ter exatamente 11 dígitos (DDD + numero.)");
            } else if (!apenasNumeros) {
                throw new IllegalArgumentException("O Telefone deve conter apenas números (0-9).");
            }

            valido = true;

        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
            System.out.println("Tente novamente.");
        } catch (Exception e) {
            System.out.println("Erro inesperado: " + e.getMessage());
            System.out.println("Tente novamente.");
        }
    }
    return telefone;
    }

    public static String lerEmail(Scanner scanner) {
    // Expressao regular que garante que o email esteja em um formato aceitavel
    // Sem espaços em branco, algo antes e depois do arroba, apenas um arroba e o ponto de dominio
    String REGEX_EMAIL = "^[^\\s@]+@[^\\s@]+\\.[^\\s@]+$";

    String email = "";
    boolean valido = false;

    while (!valido) {
        try {
            System.out.print("Email (ex: exemplo1@gmail.com): ");
            email = scanner.nextLine().trim(); // Le o texto e remove espaços extra

            boolean formatoValido = email.matches(REGEX_EMAIL); // Verifica o formato do email

            // Validaçoes: não vazio e formato
            if (email.isEmpty()){
                throw new IllegalArgumentException("O Email não pode estar vazio.");
            } else if (!formatoValido) {
                throw new IllegalArgumentException("O Email informado não esta no formato adequado.");
            }

            valido = true;

        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
            System.out.println("Tente novamente.");
        } catch (Exception e) {
            System.out.println("Erro inesperado: " + e.getMessage());
            System.out.println("Tente novamente.");
        }
    }
    return email;
    } 

    public static TipoSanguineo lerTipoSanguineo(Scanner scanner) {
    TipoSanguineo tipoSanguineo = null;
    boolean valido = false;

    while (!valido) {
        try {
            // Recebe String com scanner, remove espaços extra e deixa tudo em maiusculo 
            System.out.print("Tipo Sanguíneo (Ex: A_POSITIVO, O_NEGATIVO): ");
            tipoSanguineo = TipoSanguineo.valueOf(scanner.nextLine().trim().toUpperCase());

            valido = true; 

        } catch (IllegalArgumentException e) {
            System.out.println("Erro: valor invalido. Tente novamente.\n");
        } catch (Exception e) {
            // Captura qualquer outra exceção inesperada
            System.out.println("Erro inesperado: " + e.getMessage() + " Tente novamente.");
        }
    }
    return tipoSanguineo;
    }

    public static Double lerPeso(Scanner scanner) {
    Double peso = null;
    boolean valido = false;
    
    while (!valido) {
        try {
            System.out.print("Peso (kg): ");
            peso = Double.parseDouble(scanner.nextLine());

            valido = true;

        } catch (IllegalArgumentException e) {
            System.out.println("Erro: valor invalido. Tente novamente.");
        } catch (Exception e) {
            // Captura qualquer outra exceção inesperada
            System.out.println("Erro inesperado: " + e.getMessage() + " Tente novamente.");
        }
    }
    return peso;
    }

    public static ResultadoAptidao lerResultadoAptidao(Scanner scanner) {
    ResultadoAptidao resultadoAptidao = null;
    boolean valido = false;

    while (!valido) {
        try {
            // Recebe String com scanner, remove espaços extra e deixa tudo em maiusculo 
            System.out.print("Condição de Triagem (APTO, INAPTO_TEMPORARIO, INAPTO_PERMANENTE): ");
            resultadoAptidao = ResultadoAptidao.valueOf(scanner.nextLine().trim().toUpperCase());

            valido = true;

        } catch (IllegalArgumentException e) {
            System.out.println("Erro: valor invalido. Tente novamente.\n");
        } catch (Exception e) {
            // Captura qualquer outra exceção inesperada
            System.out.println("Erro inesperado: " + e.getMessage() + " Tente novamente.");
        }
    }
    return resultadoAptidao;
    }

    public static boolean lerAutorizacao(Scanner scanner) {
    boolean autorizacao = false;
    boolean valido = false;

    while (!valido) {
        try {
            System.out.print("Possui autorização de um responsável? \n(digite 1 para POSSUI e 0 para NAO POSSUI): ");
            autorizacao = Boolean.parseBoolean(scanner.nextLine());

            valido = true;

        } catch (IllegalArgumentException e) {
            System.out.println("Erro: valor invalido. Tente novamente.");
        } catch (Exception e) {
            // Captura qualquer outra exceção inesperada
            System.out.println("Erro inesperado: " + e.getMessage() + " Tente novamente.");
        }
    }
    return autorizacao;
    }

}
