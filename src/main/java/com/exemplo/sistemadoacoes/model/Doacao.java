package com.exemplo.sistemadoacoes.model;

public class Doacao {
    private final Doador doador;

    private final String id;

    private double valorDoacao;

    public Doacao(Doador doador, String id, double valorDoacao) {
        if (doador == null || id == null || id.isBlank() || valorDoacao <= 0) {
            throw new IllegalArgumentException("Dados inválidos para criação da doação.");
        }
        this.doador = doador;
        this.id = id;
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
