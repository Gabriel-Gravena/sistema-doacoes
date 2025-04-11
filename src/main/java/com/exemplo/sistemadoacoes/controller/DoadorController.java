package com.exemplo.sistemadoacoes.controller;


import com.exemplo.sistemadoacoes.model.Doador;
import com.exemplo.sistemadoacoes.service.DoadorService;

import java.util.List;

public class DoadorController {
    private DoadorService doadorService = new DoadorService();

    public void cadastrarDoador(Doador doador) {
        doadorService.cadastrarDoador(doador);
    }

    public void removerDoador(Doador doador) {
        doadorService.removerDoador(doador);
    }

    public List<Doador> exibirTodosOsDoadores() {
        return doadorService.getDoadores();
    }

    public List<Doador> exibirDoadoresPorNome(String nome) {
         return doadorService.getDoadoresPorNome(nome);
    }
}
