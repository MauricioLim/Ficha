package com.ficha.exception.atributo;

public class AtributoDuplicadoException extends RuntimeException {
    public AtributoDuplicadoException(String descricao) {
        super("Atributo já cadastrado: " + descricao);
    }
}