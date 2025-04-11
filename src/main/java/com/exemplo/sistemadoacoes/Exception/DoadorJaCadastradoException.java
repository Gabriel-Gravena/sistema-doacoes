package com.exemplo.sistemadoacoes.Exception;

public class DoadorJaCadastradoException extends RuntimeException {
    public DoadorJaCadastradoException(String mensagem) {
        super(mensagem);
    }
}
