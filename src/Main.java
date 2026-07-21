import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import model.Doador;
import model.Estoque;
import model.ResultadoAptidao;
import model.Sexo;
import model.TipoSanguineo;
import util.EntradaUtils;
import views.Menu;

public class Main {

    public static Doador buscarDoadorPorCPF(List<Doador> listaDoadores, String cpf){
        for (Doador doador : listaDoadores){
            if (cpf.equals(doador.getCpf())) {
                return doador;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Inicializar os dados base do sistema
        Estoque estoqueHemocentro = new Estoque(5);
        List<Doador> listaDoadores = new ArrayList<>();
        int opcao = 0;

        System.out.println("=== Bem-vindo ao sistema BemDoado! ===");

        while (opcao != 5) {

            Menu.exibirMenuPrincipal();

            try {
                opcao = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                opcao = 0;
            }

            switch (opcao) {
                case 1:
                    System.out.println("\n--- Cadastro de Novo Doador ---");
                    
                    String nome = EntradaUtils.lerNome(scanner);

                    String cpf = EntradaUtils.lerCPF(scanner);

                    LocalDate dataNascimento = EntradaUtils.lerData(scanner);

                    Sexo sexo = EntradaUtils.lerSexo(scanner);

                    System.out.print("Endereço: ");
                    String endereco = scanner.nextLine();

                    String telefone = EntradaUtils.lerTelefone(scanner);

                    String email = EntradaUtils.lerEmail(scanner);

                    TipoSanguineo tipoSanguineo = EntradaUtils.lerTipoSanguineo(scanner);

                    double peso = EntradaUtils.lerPeso(scanner);

                    ResultadoAptidao aptidao = EntradaUtils.lerResultadoAptidao(scanner);
                        
                    boolean autorizacao = EntradaUtils.lerAutorizacao(scanner);

                    // Cria o objeto doador com os dados digitados
                    Doador novoDoador = new Doador(nome, cpf, dataNascimento, sexo, endereco, telefone, email, tipoSanguineo, peso, aptidao, autorizacao);
                    listaDoadores.add(novoDoador);

                    System.out.println("\n✅ Doador '" + novoDoador.getNome() + "' cadastrado com sucesso!");
                    break;

                case 2:
                    System.out.println("\n[2] Registrando Doação...");
                    if (listaDoadores.isEmpty()) {
                        System.out.println("❌ Nenhum doador cadastrado no sistema. Por favor, utilize a Opção 1 primeiro.");
                    } else {
                        // Para simplificar, pega o último doador cadastrado
                        Doador doadorAtual = listaDoadores.get(listaDoadores.size() - 1);
                        System.out.println("Iniciando doação de: " + doadorAtual.getNome());
                        doadorAtual.realizarDoacao(false, false, estoqueHemocentro);
                    }
                    break;

                case 3:
                    System.out.println("\n[3] Consultando Estoque...");
                    System.out.println("Total de bolsas no estoque geral: " + estoqueHemocentro.getBolsas().size());
                    System.out.println("-> Bolsas A+: " + estoqueHemocentro.consultarEstoque(TipoSanguineo.A_POSITIVO));
                    System.out.println("-> Bolsas A-: " + estoqueHemocentro.consultarEstoque(TipoSanguineo.A_NEGATIVO));
                    System.out.println("-> Bolsas B+: " + estoqueHemocentro.consultarEstoque(TipoSanguineo.B_POSITIVO));
                    System.out.println("-> Bolsas B-: " + estoqueHemocentro.consultarEstoque(TipoSanguineo.B_NEGATIVO));
                    System.out.println("-> Bolsas AB+: " + estoqueHemocentro.consultarEstoque(TipoSanguineo.AB_POSITIVO));
                    System.out.println("-> Bolsas AB-: " + estoqueHemocentro.consultarEstoque(TipoSanguineo.AB_NEGATIVO));
                    System.out.println("-> Bolsas O+: " + estoqueHemocentro.consultarEstoque(TipoSanguineo.O_POSITIVO));
                    System.out.println("-> Bolsas O-: " + estoqueHemocentro.consultarEstoque(TipoSanguineo.O_NEGATIVO));

                    // Verifica se o alerta precisa de disparar
                    estoqueHemocentro.emitirAlerta();
                    break;

                case 4:
                    System.out.println("\n[4] Informe CPF do doador:");
                    cpf = EntradaUtils.lerCPF(scanner);

                    Doador doadorProcurado = buscarDoadorPorCPF(listaDoadores, cpf);

                    if (doadorProcurado == null) {
                        System.out.println("Doador com o CPF " + cpf + " não encontrado.");
                        break;
                    }

                    int opcaoDoador = 0;

                    while (opcaoDoador != 3) {

                        System.out.println("\n===== DOADOR ENCONTRADO =====");
                        System.out.println("Nome: " + doadorProcurado.getNome());
                        System.out.println("CPF: " + doadorProcurado.getCpf());
                        System.out.println("=============================");

                        Menu.exibirMenuDoador();

                        try {
                            opcaoDoador = Integer.parseInt(scanner.nextLine());
                        } catch (NumberFormatException e) {
                            opcaoDoador = 0;
                        }

                        switch (opcaoDoador) {

                            case 1:
                                System.out.println("\n===== FICHA DE DOADOR =====");
                                System.out.println("Nome: " + doadorProcurado.getNome());
                                System.out.println("CPF: " + doadorProcurado.getCpf());
                                System.out.println("Data de nascimento: " + doadorProcurado.getDataNascimento());
                                System.out.println("Sexo: " + doadorProcurado.getSexo());
                                System.out.println("Endereço: " + doadorProcurado.getEndereco());
                                System.out.println("Telefone: " + doadorProcurado.getTelefone());
                                System.out.println("Email: " + doadorProcurado.getEmail());
                                System.out.println("Tipo sanguíneo: " + doadorProcurado.getTipoSanguineo());
                                System.out.println("Peso: " + doadorProcurado.getPeso() + " kg");
                                break;

                            case 2:

                                int opcaoAtualizacoesDoador = 0;
                                while  (opcaoAtualizacoesDoador != 5) {
                                    Menu.exibirMenuAtualizacoesDoador();

                                    try {
                                        opcaoAtualizacoesDoador = Integer.parseInt(scanner.nextLine());
                                    } catch (NumberFormatException e) {
                                        opcaoAtualizacoesDoador = 0;
                                    }

                                    switch (opcaoAtualizacoesDoador) {
                                        case 1:
                                            System.out.print("\nDigite o novo endereço: ");
                                            String novoEndereco = scanner.nextLine();
                                            doadorProcurado.atualizarEndereco(novoEndereco);
                                            System.out.println("Endereço atualizado com SUCESSO!");
                                            break;
                                        case 2:
                                            System.out.print("\nDigite o novo número de telefone: ");
                                            String novoTelefone = EntradaUtils.lerTelefone(scanner);
                                            doadorProcurado.atualizarTelefone(novoTelefone);
                                            System.out.println("Telefone atualizado com SUCESSO!");
                                            break;
                                        case 3:
                                            System.out.print("\nDigite o novo email: ");
                                            String novoEmail = EntradaUtils.lerEmail(scanner);
                                            doadorProcurado.atualizarEmail(novoEmail);
                                            System.out.println("Email atualizado com SUCESSO!");
                                            break;
                                        case 4:
                                            System.out.print("\nDigite o novo peso: ");
                                            Double novoPeso = EntradaUtils.lerPeso(scanner);
                                            doadorProcurado.atualizarPeso(novoPeso);
                                            System.out.println("Peso atualizado com SUCESSO!");
                                            break;
                                        case 5:
                                            System.out.println("\nVoltando ao menu de doador...");
                                            break;
                                        default:
                                            System.out.println("Opção inválida.");
                                            break;
                                    }

                                }

                                break;

                            case 3:
                                System.out.println("\nVoltando ao menu principal...");
                                break;

                            default:
                                System.out.println("Opção inválida.");
                                break;
                        }
                    }

                    break;


                case 5:
                    System.out.println("\nEncerrando o sistema BemDoado... Obrigado e até logo!");
                    break;

                default:
                    System.out.println("\n❌ Opção inválida. Por favor, digite um número de 1 a 5.");
                    break;
            }
        }
        
        scanner.close(); 
    }
}