package com.teste.ProdutoSpring;

import com.teste.ProdutoSpring.model.Produto;

import java.util.Optional;

public interface ProdutoInterface {

    void adicionarProduto(Produto produto);
    Optional<Produto> buscarProdutoPorId(int id);
    void atualizarQuantidadeEstoque(int id, int novaQuantidade);

}
