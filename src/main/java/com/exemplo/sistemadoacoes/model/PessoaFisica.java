package com.exemplo.sistemadoacoes.model;

import java.time.LocalDate;

public class PessoaFisica extends Doador{
    private final String cpf;

    public PessoaFisica(String nome, String email, String telefone, LocalDate dataNascimento, String cpf) {
        super(nome, email, telefone, dataNascimento);
        this.cpf = cpf;
    }

    @Override
    public String getDocumentoIdentificador() {
        return cpf;
    }

    @Override
    public boolean validarIdentificacao() {
        return cpf.length() == 11; //implementar validação correta
    }

    @Override
    public String toString() {
        return String.format("Pessoa Física: %s - CPF: %s", getNome(), cpf);
    }
}
