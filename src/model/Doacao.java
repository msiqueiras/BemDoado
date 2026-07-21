package model;

import java.time.LocalDate;

public class Doacao {
    private LocalDate dataColeta;
    private boolean votoAutoExclusao;
    private boolean intercorrencias;

    public Doacao(LocalDate dataColeta,
                  boolean votoAutoExclusao, 
                  boolean intercorrencias) {
        this.dataColeta = dataColeta;
        this.votoAutoExclusao = votoAutoExclusao;
        this.intercorrencias = intercorrencias;
    }


// Getters e Setters
    public LocalDate getDataColeta() { return dataColeta; }
    public void setDataColeta(LocalDate dataColeta) { this.dataColeta = dataColeta; }

    public boolean getVotoAutoexclusao() { return votoAutoExclusao; }
    public void setVotoAutoexclusao(boolean votoAutoexclusao) { this.votoAutoExclusao = votoAutoexclusao; }

    public boolean getIntercorrencias() { return intercorrencias; }
    public void setIntercorrencias(boolean intercorrencias) { this.intercorrencias = intercorrencias; }
}