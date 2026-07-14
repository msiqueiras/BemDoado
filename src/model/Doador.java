package model;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

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

    private long calcularIntervaloDoacao(){
        Doacao ultimaDoacao = doacoes.get(doacoes.size()-1);
        LocalDate ultimaData = ultimaDoacao.getDataColeta();
        long intervaloDoacao = ChronoUnit.MONTHS.between(ultimaData, LocalDate.now());
        return intervaloDoacao;
    }

    public boolean respeitaIntervaloDoacao(){
        Sexo sexo = getSexo();
        if (doacoes.isEmpty()){
            return true; //primeira doação da pessoa
        } else {
            long intervaloDoacao = calcularIntervaloDoacao();
            if (sexo == Sexo.FEMININO && intervaloDoacao < 3){
                return false;
            } else if (sexo == Sexo.MASCULINO && intervaloDoacao < 2){
                return false;
            }
            return true;
        }
    }

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

        } else if (!respeitaIntervaloDoacao()){
            return false;
        }

        return true;
    }

    public void realizarDoacao( boolean votoAutoExclusao, boolean intercorrencias, Estoque estoqueAtual) {
        if (!estaApto()) {
            System.out.println(" O doador " + super.getNome() + " não está apto para doar sangue no momento.");
            return;
        }


        Doacao novaDoacao = new Doacao(LocalDate.now(), votoAutoExclusao, intercorrencias);
        this.doacoes.add(novaDoacao);
        System.out.println("Doação registrada com sucesso para o doador: " + super.getNome());
        
        if (!votoAutoExclusao && !intercorrencias) {
            String idBolsa = "B-" + super.getCpf().substring(0,3) + "-" + doacoes.size();

            BolsaSangue novaBolsa = new BolsaSangue(idBolsa, this.tipoSanguineo, 450, 35);

            estoqueAtual.adicionarBolsa(novaBolsa);
        }
        else {
            System.out.println("ATENÇÃO: A bolsa de sangue foi descartada por motivos de segurança (Autoexclusão/Intercorrência).");
        }
    }

    public TipoSanguineo getTipoSanguineo() {
        return tipoSanguineo;
    }

    public void setTipoSanguineo(TipoSanguineo tipoSanguineo) {
        this.tipoSanguineo = tipoSanguineo;
    }

    public double getPeso() {
        return peso;
    }

    public void atualizarPeso(double peso) {
        this.peso = peso;
    }

    public ResultadoAptidao getCondicaoTriagem() {
        return condicaoTriagem;
    }

    public void setCondicaoTriagem(ResultadoAptidao condicaoTriagem) {
        this.condicaoTriagem = condicaoTriagem;
    }

    public boolean isAutorizacao() {
        return autorizacao;
    }
    public void setAutorizacao(boolean autorizacao) {
        this.autorizacao = autorizacao;
    }

    public List<Doacao> getDoacoes() {
        return doacoes;
    }
}