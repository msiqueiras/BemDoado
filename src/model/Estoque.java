package model;
import java.util.ArrayList;
import java.util.List;

public class Estoque {
    
    private List<BolsaSangue> bolsas;
    private int estoqueMinimo;
    
    public Estoque(int estoqueMinimo) {
        this.bolsas = new ArrayList<>();
        this.estoqueMinimo = estoqueMinimo;
    }
    
    public int consultarEstoque(TipoSanguineo tipo) {
        int quantidade = 0;
        for (BolsaSangue bolsa : this.bolsas) {
            if (bolsa.getTipoSanguineo() == tipo) {
                quantidade ++;
            }
        }
        return quantidade;
    }
    
    public void emitirAlerta() {
       if (this.bolsas.size() < this.estoqueMinimo) {
        System.out.println("ALERTA: o estoque geral de sangue está abaixo do mínimo exigido! ");
        System.out.println(" -> Total atual: " + this.bolsas.size() + " bolsas | Mínimo exigido: " + this.estoqueMinimo + " bolsas.");
       }
    }
    
        public void adicionarBolsa(BolsaSangue bolsa) {
            this.bolsas.add(bolsa); 
            System.out.println("Bolsa " + bolsa.getIdentificadorBolsa() + " adicionada com sucesso ao estoque!");
        }


    public void removerBolsa(BolsaSangue bolsa) {
        if (this.bolsas.contains(bolsa)) {
            this.bolsas.remove(bolsa);
            System.out.println(" Saída de bolsa " + bolsa.getIdentificadorBolsa() + " registrada.");

            emitirAlerta();
        } 
        else {
            System.out.println("Erro: Esta bolsa não foi encontrada no estoque.");
        }
    }

    // Getters e Setters
    public List<BolsaSangue> getBolsas() { return bolsas; }
    public void setBolsas(List<BolsaSangue> bolsas) { this.bolsas = bolsas; }

    public int getEstoqueMinimo() { return estoqueMinimo; }
    public void setEstoqueMinimo(int estoqueMinimo) { this.estoqueMinimo = estoqueMinimo; }
}