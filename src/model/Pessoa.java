package model;
import java.time.LocalDate;
import java.time.Period;

public class Pessoa{
    private String nome;
    private String cpf;
    private LocalDate dataNascimento;
    private Sexo sexo;
    private String endereco;
    private String telefone;
    private String email;

    public Pessoa(String nome, String cpf, LocalDate dataNascimento,
                  Sexo sexo, String endereco, String telefone, String email){
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.sexo = sexo;
        this.endereco = endereco;
        this.telefone = telefone;
        this.email = email;
    }

    public void atualizarEndereco(String endereco){
        this.endereco = endereco;
    }

    public void atualizarTelefone(String telefone){
        this.telefone = telefone;
    }

    public void atualizarEmail(String email){
        this.email = email;
    }

    public int calcularIdadeAtual(){
        return Period.between(dataNascimento, LocalDate.now()).getYears();
    }


}