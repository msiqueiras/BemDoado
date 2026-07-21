package views;

public class Menu {
    public static void exibirMenuPrincipal(){
        System.out.println("\n----------------------------------");
        System.out.println("          MENU PRINCIPAL          ");
        System.out.println("----------------------------------");
        System.out.println("1 - Cadastrar Doador");
        System.out.println("2 - Registrar Doação");
        System.out.println("3 - Consultar Estoque de Sangue");
        System.out.println("4 - Consultar Doador");
        System.out.println("5 - Sair do Sistema");
        System.out.print("Escolha uma opção: ");
    }

    public static void exibirMenuDoador(){
        System.out.println("\n----------------------------------");
        System.out.println("          MENU DOADOR          ");
        System.out.println("----------------------------------");
        System.out.println("1 - Visualizar dados completos");
        System.out.println("2 - Atualizar dados");
        System.out.println("3 - Consultar histórico de doações");
        System.out.println("4 - Voltar ao menu principal");
        System.out.print("Escolha uma opção: ");
    }

    public static void exibirMenuAtualizacoesDoador(){
        System.out.println("\n----------------------------------");
        System.out.println("      O QUE DESEJA ATUALIZAR?      ");
        System.out.println("----------------------------------");
        System.out.println("1 - Atualizar endereço");
        System.out.println("2 - Atualizar telefone");
        System.out.println("3 - Atualizar email ");
        System.out.println("4 - Atualizar peso");
        System.out.println("5 - Voltar ao menu de doador");
        System.out.print("Escolha uma opção: ");
    }
}