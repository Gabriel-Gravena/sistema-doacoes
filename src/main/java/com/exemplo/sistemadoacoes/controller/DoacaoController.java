package com.exemplo.sistemadoacoes.controller;

import com.exemplo.sistemadoacoes.model.Doacao;
import com.exemplo.sistemadoacoes.model.Doador;
import com.exemplo.sistemadoacoes.service.DoacaoService;
import com.exemplo.sistemadoacoes.service.DoadorService;

import java.util.List;

public class DoacaoController {
    private DoacaoService doacaoService;

    public DoacaoController(DoadorService doadorService) {
        this.doacaoService = new DoacaoService(doadorService);
    }

    public Doacao registrarDoacao(Doador doador, double valorDoacao) {
        return doacaoService.registrarDoacao(doador, valorDoacao);
    }

    public double calcularTotalDoacoes(List<Doador> doadores) {
        return doacaoService.CalcularValorTotalDoacoes(doadores);
    }
}
