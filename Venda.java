
package com.mycompany.comercio;


public class Venda {
    private String produto;
    private int quantidade;
    private double valorTotal;

    //metódo construtor
    public Venda(String produto, int quantidade, double valorTotal) {
        this.produto = produto;
        this.quantidade = quantidade;
        this.valorTotal = valorTotal;
    }

    
    
    public String getProduto() {
        return produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public double getValorTotal() {
        return valorTotal;
    }

}
