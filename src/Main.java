

import java.time.LocalDate;

import model.Doador;
import model.Estoque;
import model.ResultadoAptidao;
import model.Sexo;
import model.TipoSanguineo;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Bem-vindo ao sistema BemDoado! ===");

        Estoque estoqueHemocentro = new Estoque(5);

        Doador doadorBruno = new Doador(
            "Bruno Farias Amaral", "12345678900", LocalDate.of(2003, 5, 15), 
            Sexo.MASCULINO, "Rua UFPA, 123", "91999999999", "bruno@email.com", 
            TipoSanguineo.A_POSITIVO, 75.0, ResultadoAptidao.APTO, true
        );

        System.out.println("\n--- Iniciando Doação ---");
        doadorBruno.realizarDoacao(false, false, estoqueHemocentro);
        
        System.out.println("\n--- Resumo do Estoque ---");
        int quantidadeBolsasA = estoqueHemocentro.consultarEstoque(TipoSanguineo.A_POSITIVO);
        System.out.println("Quantidade de bolsas A+ disponíveis: " + quantidadeBolsasA);
    }
}