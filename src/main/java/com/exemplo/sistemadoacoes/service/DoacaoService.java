package com.exemplo.sistemadoacoes.service;

import com.exemplo.sistemadoacoes.model.Doacao;
import com.exemplo.sistemadoacoes.model.Doador;

import java.util.List;
import java.util.Optional;

public class DoacaoService {
    private DoadorService doadorService = new DoadorService();

    public DoacaoService(DoadorService doadorService) {
        this.doadorService = doadorService;
    }

    public Doacao registrarDoacao(Doador doador, double valorDoacao) {
        if(valorDoacao <= 0){
            throw new IllegalArgumentException("O valor doacao nao pode ser negativo");
        }

        if(!doadorService.getDoadores().contains(doador)){
            throw new IllegalArgumentException("O doador não existe no sistema");
        }

        Doacao doacao = new Doacao(doador, valorDoacao);

        doador.adicionarDoacao(doacao);
        return doacao;
    }

    public double CalcularValorTotalDoacoes(List<Doador> doadores) {
        return doadores.stream()
                .mapToDouble(Doador::getTotalDoado)
                .sum();
    }

}
