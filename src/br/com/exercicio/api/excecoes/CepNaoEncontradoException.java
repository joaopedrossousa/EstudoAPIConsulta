package br.com.exercicio.api.excecoes;

public class CepNaoEncontradoException extends RuntimeException {
    public CepNaoEncontradoException(String message) {
        super(message);
    }
}
