package model;
import java.util.ArrayList;
import java.util.List;

public class Estoque {
    
    private List<BolsaSangue> bolsas;
    private int estoqueMinimo;

    // Construtor
    public Estoque(int estoqueMinimo) {
        this.bolsas = new ArrayList<>();
        this.estoqueMinimo = estoqueMinimo;
    }

    // Métodos definidos no diagrama
    public void emitirAlerta() {
        //Lógica para verificar se a quantidade de bolsas está abaixo do estoqueMinimo e emitir um aviso
    }

    public void consultarEstoque(TipoSanguineo tipo) {
        //Lógica para contar e retornar quantas bolsas existem de um determinado TipoSanguineo
    }

    public void adicionarBolsa(BolsaSangue bolsa) {
        this.bolsas.add(bolsa);
    }

    public void removerBolsa(BolsaSangue bolsa) {
        this.bolsas.remove(bolsa);
    }

    // Getters e Setters
    public List<BolsaSangue> getBolsas() {
        return bolsas;
    }

    public void setBolsas(List<BolsaSangue> bolsas) {
        this.bolsas = bolsas;
    }

    public int getEstoqueMinimo() {
        return estoqueMinimo;
    }

    public void setEstoqueMinimo(int estoqueMinimo) {
        this.estoqueMinimo = estoqueMinimo;
    }
}
