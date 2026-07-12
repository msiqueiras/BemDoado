import model.BolsaSangue;
import model.Estoque;
import model.TipoSanguineo;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        System.out.println("Bem-vindo ao sistema BemDoado!");

        Estoque meuEstoque = new Estoque(10);
        
        BolsaSangue novaBolsa = new BolsaSangue(
                "B001", 
                TipoSanguineo.O_POSITIVO, 
                450.0, 
                35, 
                LocalDate.now().plusDays(35)
        );

        meuEstoque.adicionarBolsa(novaBolsa);
        
        System.out.println("Bolsa adicionada com sucesso!");
        System.out.println("ID da Bolsa: " + meuEstoque.getBolsas().get(0).getIdentificadorBolsa());
    }
}
