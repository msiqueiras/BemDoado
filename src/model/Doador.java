package model;
import java.time.LocalDate;
import java.util.ArrayList;

public class Doador extends Pessoa{
    private TipoSanguineo tipoSanguineo;
    private double peso;
    private ResultadoAptidao condicaoTriagem;
    private boolean autorizacao;
    private ArrayList<Doacao> doacoes = new ArrayList<>();

    public Doador(
            String nome,
            String cpf,
            LocalDate dataNascimento,
            Sexo sexo,
            String endereco,
            String telefone,
            String email,
            TipoSanguineo tipoSanguineo,
            double peso,
            ResultadoAptidao condicaoTriagem,
            boolean autorizacao) {

        super(nome, cpf, dataNascimento, sexo, endereco, telefone, email);

        this.tipoSanguineo = tipoSanguineo;
        this.peso = peso;
        this.condicaoTriagem = condicaoTriagem;
        this.autorizacao = autorizacao;
    }

    public boolean possuiAutorizacao() {
        int idade = calcularIdadeAtual();

        if (idade == 16 || idade == 17) {
            return autorizacao;
        }

        return true;
    }

    // public boolean respeitaIntervaloDoacao(){}

    public boolean estaApto() {
        int idade = calcularIdadeAtual();

        if (idade < 16 || idade > 69) {
            return false;

        } else if (!possuiAutorizacao()) {
            return false;

        } else if (condicaoTriagem == ResultadoAptidao.INAPTO_TEMPORARIO ||
                condicaoTriagem == ResultadoAptidao.INAPTO_PERMANENTE){
            return false;

        } else if (peso < 50.00) {
            return false;

        }
        return true;
    }

}