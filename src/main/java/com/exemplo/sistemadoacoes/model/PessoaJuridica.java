package com.exemplo.sistemadoacoes.model;

import java.time.LocalDate;

public class PessoaJuridica extends Doador {
    private final String cnpj;

    public PessoaJuridica(String nome, String email, String telefone, LocalDate dataNascimento, String cnpj) {
        super(nome, email, telefone, dataNascimento);
        this.cnpj = cnpj;
    }

    @Override
    public String getDocumentoIdentificador() {
        return cnpj;
    }

    @Override
    public boolean validarIdentificacao() {
        return cnpj.length() == 14; //implementar validação correta
    }

    @Override
    public String toString() {
        return String.format("Pessoa Jurídica: %s - CNPJ: %s", getNome(), cnpj);
    }
}
