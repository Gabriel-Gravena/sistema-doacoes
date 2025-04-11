package com.exemplo.sistemadoacoes.service;

import com.exemplo.sistemadoacoes.model.Doador;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class DoadorService {
    List<Doador> doadores;

    public DoadorService() {
        doadores = new ArrayList<>();
    }

    public void cadastrarDoador(Doador doador) {
        if (doador == null) {
            throw new IllegalArgumentException("Doador não pode ser nulo.");
        }

        if (!doador.validarIdentificacao()) {
            throw new IllegalArgumentException("Identificação inválida para o tipo de doador.");
        }

        if (doadores.contains(doador)) {
            throw new IllegalArgumentException("Doador já cadastrado.");
        }

        doadores.add(doador);
    }

    public void removerDoador(Doador doador) {
        if (doador == null) {
            throw new IllegalArgumentException("Doador não pode ser nulo.");
        }

        if(!doadores.contains(doador)) {
            throw new IllegalArgumentException("O doador não existe.");
        }

        doadores.remove(doador);
    }

    public List<Doador> getDoadores(){
        return new ArrayList<>(doadores);
    }

    public List<Doador> getDoadoresPorNome(String nome) {
        if(nome == null || nome.isBlank()) {
            throw new IllegalArgumentException  ("O nome fornecido é inválido.");
        }

        if(doadores.isEmpty()) {
            throw new IllegalStateException("Nenhum doador cadastrado.");
        }

        List<Doador> doadoresPorNome = doadores.stream()
                                        .filter(d -> d.getNome().equalsIgnoreCase(nome))
                                        .toList();

        if (doadoresPorNome.isEmpty()) {
            throw new IllegalArgumentException("Nenhum doador encontrado com o nome fornecido.");
        }

        return doadoresPorNome;
    }

}
