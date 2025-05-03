package com.exemplo.sistemadoacoes;

import com.exemplo.sistemadoacoes.model.PessoaFisica;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class PessoaFisicaTest {

    @Test
    @DisplayName("Deve criar pessoa física com sucesso")
    void deveCriarPessoaFisica() {
        String nome = "Roberto Oliveira";
        String email = "roberto@email.com";
        String telefone = "11944444444";
        LocalDate dataNascimento = LocalDate.of(1980, 12, 5);
        String cpf = "12345678901";

        PessoaFisica pessoaFisica = new PessoaFisica(nome, email, telefone, dataNascimento, cpf);

        assertEquals(nome, pessoaFisica.getNome());
        assertEquals(email, pessoaFisica.getEmail());
        assertEquals(telefone, pessoaFisica.getTelefone());
        assertEquals(cpf, pessoaFisica.getDocumentoIdentificador());
    }

    @Test
    @DisplayName("Deve lançar exceção quando criar pessoa física com dados inválidos")
    void deveLancarExcecaoQuandoCriarPessoaFisicaComDadosInvalidos() {
        String nome = "";
        String email = "roberto@email.com";
        String telefone = "11944444444";
        LocalDate dataNascimento = LocalDate.of(1980, 12, 5);
        String cpf = "12345678901";

        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> new PessoaFisica(nome, email, telefone, dataNascimento, cpf)
        );

        assertEquals("Dados invalidos para criação de doador.", exception.getMessage());
    }

    @Test
    @DisplayName("Deve validar CPF com sucesso")
    void deveValidarCpfComSucesso() {
        PessoaFisica pessoaFisica = new PessoaFisica(
                "Roberto Oliveira",
                "roberto@email.com",
                "11944444444",
                LocalDate.of(1980, 12, 5),
                "12345678901"
        );

        assertTrue(pessoaFisica.validarIdentificacao());
    }

}
