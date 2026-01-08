package br.com.exercicio.api.excecoes;

public class PaisNaoEncontradoException extends RuntimeException {
    public PaisNaoEncontradoException(String message) {
        super(message);
    }
}
