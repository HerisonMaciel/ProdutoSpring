package com.teste.ProdutoSpring.utils;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Random;

import static java.math.RoundingMode.UP;

@Data
public class Generate {

    private String[] nomesProdutos;
    private BigDecimal[] precosProdutos;
    private int[] quantidadeProduto;

    public Generate(){
        this.nomesProdutos = preencherNomes();
        this.precosProdutos = randomPreco();
        this.quantidadeProduto = randomQuantidade();
    }

    private final int tamanho = 10;

    private Random random = new Random();

    private String[] preencherNomes(){
        return new String[]{"Notebook", "Mouse", "Teclado", "Monitor", "Gabinete",
                "HD", "Memoria ram", "Fone de Ouvido", "Placa mãe", "Webcam"};
    }

    private BigDecimal[] randomPreco(){

        BigDecimal precos[] = new BigDecimal[tamanho];

        for (int i = 0; i < 10; i++) {
            double precoAleatorio = random.nextDouble(100.00, 10000.00);
            BigDecimal numeroBigDecimal = new BigDecimal(precoAleatorio);
            precos[i] = numeroBigDecimal.setScale(2, UP);
        }

        return precos;
    }

    private int[] randomQuantidade(){

        int quantidade[] = new int[tamanho];

        for (int i = 0; i < 10; i++) {
            int quantAleatorio = random.nextInt(10, 100);
            quantidade[i] = quantAleatorio;
        }

        return quantidade;
    }
}
