package com.exemplo.sistemadoacoes.model;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class Doador {
    private final String nome;

    private String email;

    private String telefone;

    private final LocalDate dataNascimento;

    private List<Doacao> doacoes = new ArrayList<>();

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

    public List<Doacao> getDoacoesList(){
        return new ArrayList<>(doacoes);
    }

    public double getTotalDoado() {
        return doacoes.stream()
                .mapToDouble(Doacao::getValorDoacao)
                .sum();
    }

    public void adicionarDoacao(Doacao doacao) {
        doacoes.add(doacao);
    }

    public abstract String getDocumentoIdentificador();

    public abstract boolean validarIdentificacao();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Doador doador = (Doador) o;
        return getDocumentoIdentificador().equals(doador.getDocumentoIdentificador());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDocumentoIdentificador());
    }

    @Override
    public String toString() {
        return String.format("Doador: nome='%s', email='%s', telefone='%s', idade=%d, doacoes=%f",
                getNome(), getEmail(), getTelefone(), getIdade(), getTotalDoado());
    }
}
