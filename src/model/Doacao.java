package model;

import java.time.LocalDate;

public class Doacao {
    private LocalDate dataColeta;
    private boolean votoAutoExclusao;
    private boolean intercorrencias;

    public Doacao(
            LocalDate dataColeta,
            boolean votoAutoExclusao,
            boolean intercorrencias) {

        this.dataColeta = dataColeta;
        this.votoAutoExclusao = votoAutoExclusao;
        this.intercorrencias = intercorrencias;
        }
}