package model;
import java.time.LocalDate;

public class BolsaSangue {
    
    private String identificadorBolsa;
    private TipoSanguineo tipoSanguineo;
    private double volumeSangue;
    private int validadeDias;
    private LocalDate dataValidade;

    public BolsaSangue(String identificadorBolsa, TipoSanguineo tipoSanguineo, double volumeSangue, int validadeDias) {
        this.identificadorBolsa = identificadorBolsa;
        this.tipoSanguineo = tipoSanguineo;
        this.volumeSangue = volumeSangue;
        this.validadeDias = validadeDias;
       calcularValidade();
    }
    
    public void calcularValidade() {
        this.dataValidade = LocalDate.now().plusDays(this.validadeDias);
    }
    
    public boolean verificarValidade() {
       LocalDate hoje = LocalDate.now();
       if (hoje.isAfter(this.dataValidade)) {
        System.out.println(" Atenção: A bolsa " + this.identificadorBolsa + " está VENCIDA!");
        return false;
       }
       return true;
    }


    // Getters e Setters
    public String getIdentificadorBolsa() { return identificadorBolsa; }
    public void setIdentificadorBolsa(String identificadorBolsa) { this.identificadorBolsa = identificadorBolsa; }

    public TipoSanguineo getTipoSanguineo() { return tipoSanguineo; }
    public void setTipoSanguineo(TipoSanguineo tipoSanguineo) { this.tipoSanguineo = tipoSanguineo; }

    public double getVolumeSangue() { return volumeSangue; }
    public void setVolumeSangue(double volumeSangue) { this.volumeSangue = volumeSangue; }

    public int getValidadeDias() { return validadeDias; }
    public void setValidadeDias(int validadeDias) { this.validadeDias = validadeDias; }

    public LocalDate getDataValidade() { return dataValidade; }
    public void setDataValidade(LocalDate dataValidade) { this.dataValidade = dataValidade; }
}