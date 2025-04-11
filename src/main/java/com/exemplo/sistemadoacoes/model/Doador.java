package com.exemplo.sistemadoacoes.model;

import java.time.LocalDate;
import java.time.Period;
import java.util.Objects;

public abstract class Doador {
    private final String nome;

    private String email;

    private String telefone;

    private final LocalDate dataNascimento;

    public Doador(String nome, String email, String telefone, LocalDate dataNascimento) {
        if (nome == null || nome.isBlank() || email == null || email.isBlank() || telefone == null || telefone.isBlank() || dataNascimento == null) {
            throw new IllegalArgumentException("Dados invalidos para criação de doador.");
        }else {
            this.nome = nome;
            this.email = email;
            this.telefone = telefone;
            this.dataNascimento = dataNascimento;
        }
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public int getIdade() {
        return Period.between(dataNascimento, LocalDate.now()).getYears();
    }

    public abstract String getDocumentoIdentificador();

    public abstract boolean validarIdentificacao();

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Doador doador = (Doador) o;
        return Objects.equals(nome, doador.nome) && Objects.equals(email, doador.email) && Objects.equals(telefone, doador.telefone) && Objects.equals(dataNascimento, doador.dataNascimento);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, email, telefone, dataNascimento);
    }
}
