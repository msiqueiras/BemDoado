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
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Inicializar os dados base do sistema
        Estoque estoqueHemocentro = new Estoque(5);
        List<Doador> listaDoadores = new ArrayList<>();
        int opcao = 0;

        public Doador buscarDoadorPorCPF(List<Doador> listaDoadores, String cpf){
            for (Doador doador : listaDoadores){
                if (cpf.equals(doador.getCpf())) {
                        return doador;
                }
            }
            return null;
        }


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
                    try {
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

                        System.out.print("Possui autorização de um responsável? (true ou false): ");
                        boolean autorizacao = Boolean.parseBoolean(scanner.nextLine());

                        // Cria o objeto doador com os dados digitados
                        Doador novoDoador = new Doador(nome, cpf, dataNascimento, sexo, endereco, telefone, email, tipoSanguineo, peso, aptidao, autorizacao);
                        listaDoadores.add(novoDoador);

                        System.out.println("✅ Doador '" + novoDoador.getNome() + "' cadastrado com sucesso!");

                    } catch (IllegalArgumentException e) {
                        System.out.println("❌ Erro: Algum dos valores digitados (Sexo, Tipo Sanguíneo ou Aptidão) está incorreto. Preste atenção no texto de exemplo.");
                    }
                    break;

                case 2:
                    System.out.println("\n[2] A Registar Doação...");
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
                    System.out.println("\n[3] A Consultar Estoque...");
                    System.out.println("Total de bolsas no estoque geral: " + estoqueHemocentro.getBolsas().size());
                    System.out.println("-> Bolsas A+: " + estoqueHemocentro.consultarEstoque(TipoSanguineo.A_POSITIVO));
                    System.out.println("-> Bolsas O+: " + estoqueHemocentro.consultarEstoque(TipoSanguineo.O_POSITIVO));

                    // Verifica se o alerta precisa de disparar
                    estoqueHemocentro.emitirAlerta();
                    break;

                case 4:
                    int opcao_doador = 0;
                    while (opcao_doador < 3 && opcao_doador >= 0) {
                        System.out.println("\n[4] Informe CPF do doador:");
                        String cpf = EntradaUtils.lerCPF(scanner);
                        for (Doador doador : listaDoadores) {
                            if (cpf.equals(doador.getCpf())) {
                                System.out.println("\n ===== DOADOR ENCONTRADO =====");
                                System.out.println("Nome: " + doador.getNome());
                                System.out.println("CPF: " + doador.getCpf());
                                System.out.println("\n =============================");

                                Menu.exibirMenuDoador();

                                try {
                                    opcao_doador = Integer.parseInt(scanner.nextLine());
                                } catch (NumberFormatException e) {
                                    opcao_doador = 0;
                                }

                                if (opcao_doador == 1) {
                                    System.out.println("===== FICHA DE DOADOR =====");
                                    System.out.println("Nome: " + doador.getNome());
                                    System.out.println("CPF: " + doador.getCpf());
                                    System.out.println("Data de nascimento: " + doador.getDataNascimento());
                                    System.out.println("Sexo: " + doador.getSexo());
                                    System.out.println("Endereço: " + doador.getEndereco());
                                    System.out.println("Telefone: " + doador.getTelefone());
                                    System.out.println("Email: " + doador.getEmail());
                                    System.out.println("Tipo sanguíneo: " + doador.getTipoSanguineo());
                                    System.out.println("Peso: " + doador.getPeso() + " kg");

                                    //} else if (opcao_doador == 2){}

                                } else {
                                    System.out.println(" ❌ Doador de CPF " + cpf + "não encontrado.")
                                }
                            }
                        }
                    }
                    break


                case 5:
                    System.out.println("\nA encerrar o sistema BemDoado... Obrigado e até logo!");
                    break;

                default:
                    System.out.println("\n❌ Opção inválida. Por favor, introduz um número de 1 a 5.");
                    break;
            }
        }
        
        scanner.close(); 
    }
}