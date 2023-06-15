package com.teste.ProdutoSpring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.teste.ProdutoSpring.model.Produto;
import com.teste.ProdutoSpring.service.ProdutoService;
import com.teste.ProdutoSpring.utils.Generate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;

@SpringBootApplication
public class ProdutoSpringApplication {

	private static final Logger logger = LoggerFactory.getLogger(ProdutoSpringApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(ProdutoSpringApplication.class, args);

		ProdutoService produtoService = new ProdutoService();

		//Criar produtos
		produtoService.criarProduto();

		// Buscar um produto pelo ID
		Optional<Produto> produto = produtoService.buscarProdutoPorId(8);
		String mensagem = produto.isPresent() ? "Produto encontrado: " + produto : "Produto não encontrado";
		System.out.println(mensagem);

		// Atualizar a quantidade em estoque de um produto
		produtoService.atualizarQuantidadeEstoque(1, 5);

	}

}
