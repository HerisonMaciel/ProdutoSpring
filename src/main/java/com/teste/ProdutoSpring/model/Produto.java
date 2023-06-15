package com.teste.ProdutoSpring.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;


@Data
@NoArgsConstructor
public class Produto {

    private int id;
    private String nome;
    private BigDecimal preco;
    private int quantidadeEstoque;

    public Produto(String nome, BigDecimal preco, int quantidadeEstoque) {
        this.nome = nome;
        this.preco = preco;
        this.quantidadeEstoque = quantidadeEstoque;
    }
}
