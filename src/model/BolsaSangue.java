package model;
import java.time.LocalDate;

public class BolsaSangue {
    
    private String identificadorBolsa;
    private TipoSanguineo tipoSanguineo;
    private double volumeSangue;
    private int validadeDias;
    private LocalDate dataValidade;

    // Construtor
    public BolsaSangue(String identificadorBolsa, TipoSanguineo tipoSanguineo, double volumeSangue, int validadeDias, LocalDate dataValidade) {
        this.identificadorBolsa = identificadorBolsa;
        this.tipoSanguineo = tipoSanguineo;
        this.volumeSangue = volumeSangue;
        this.validadeDias = validadeDias;
        this.dataValidade = dataValidade;
    }

    public void verificarValidade() {
        //lógica para verificar se a dataValidade já passou
    }

    public void calcularValidade() {
        //lógica para calcular a dataValidade somando os validadeDias à data atual ou de recolha
    }

    // Getters e Setters
    public String getIdentificadorBolsa() {
        return identificadorBolsa;
    }

    public void setIdentificadorBolsa(String identificadorBolsa) {
        this.identificadorBolsa = identificadorBolsa;
    }

    public TipoSanguineo getTipoSanguineo() {
        return tipoSanguineo;
    }

    public void setTipoSanguineo(TipoSanguineo tipoSanguineo) {
        this.tipoSanguineo = tipoSanguineo;
    }

    public double getVolumeSangue() {
        return volumeSangue;
    }

    public void setVolumeSangue(double volumeSangue) {
        this.volumeSangue = volumeSangue;
    }

    public int getValidadeDias() {
        return validadeDias;
    }

    public void setValidadeDias(int validadeDias) {
        this.validadeDias = validadeDias;
    }

    public LocalDate getDataValidade() {
        return dataValidade;
    }

    public void setDataValidade(LocalDate dataValidade) {
        this.dataValidade = dataValidade;
    }
}