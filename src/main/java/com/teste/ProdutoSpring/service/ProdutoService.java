package com.teste.ProdutoSpring.service;

import com.teste.ProdutoSpring.ProdutoInterface;
import com.teste.ProdutoSpring.model.Produto;
import com.teste.ProdutoSpring.utils.Generate;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class ProdutoService implements ProdutoInterface {

    private static final Logger logger = LoggerFactory.getLogger(ProdutoService.class);

    private Map<Integer, Produto> produtos = new HashMap<>();
    private int proximoId = 1;

    Generate generate = new Generate();

    public void criarProduto(){
        for (int i = 0; i<10; i++) {
            Produto produto = new Produto(generate.getNomesProdutos()[i],
                    generate.getPrecosProdutos()[i], generate.getQuantidadeProduto()[i]);
            adicionarProduto(produto);
            logger.info("Produto Cadastrado: " + produto.toString());
        }
    }

    public void adicionarProduto(Produto produto) {
        produto.setId(proximoId);
        produtos.put(proximoId, produto);
        proximoId++;
    }

    public Optional<Produto> buscarProdutoPorId(int id) {
        Optional<Produto> produtoOptional = Optional.ofNullable(produtos.get(id));
        if(produtoOptional.isPresent()){
            logger.info("Produto cadastrado: " + produtoOptional );
            return produtoOptional;
        }
        logger.info("Produto com o id " + id + " não cadastrado!");
        return Optional.empty();
    }

    public void atualizarQuantidadeEstoque(int id, int novaQuantidade) {
        Optional<Produto> produtoOptional = buscarProdutoPorId(id);
        if (produtoOptional.isPresent()) {
            Produto produto = produtoOptional.get();
            produto.setQuantidadeEstoque(novaQuantidade);
            produtos.put(id, produto);
            logger.info("Produto atualizado: " + produto);
        }
    }

}
