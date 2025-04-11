package com.exemplo.sistemadoacoes.model;

import java.util.UUID;

public class Doacao {
    private final Doador doador;

    private final String id;

    private double valorDoacao;

    public Doacao(Doador doador, double valorDoacao) {
        if (doador == null || valorDoacao <= 0) {
            throw new IllegalArgumentException("Dados inválidos para criação da doação.");
        }
        this.doador = doador;
        this.id = UUID.randomUUID().toString();
        this.valorDoacao = valorDoacao;
    }

    public Doador getDoador() {
        return doador;
    }

    public String getId() {
        return id;
    }

    public double getValorDoacao() {
        return valorDoacao;
    }

}
