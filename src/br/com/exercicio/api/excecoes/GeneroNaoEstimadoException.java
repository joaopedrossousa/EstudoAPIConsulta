package br.com.exercicio.api.excecoes;

public class GeneroNaoEstimadoException extends RuntimeException {
    public GeneroNaoEstimadoException(String message) {
        super(message);
    }
}
