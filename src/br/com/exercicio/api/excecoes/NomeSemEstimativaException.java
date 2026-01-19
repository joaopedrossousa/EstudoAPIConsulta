package br.com.exercicio.api.excecoes;

public class NomeSemEstimativaException extends RuntimeException {
    public NomeSemEstimativaException(String message) {
        super(message);
    }
}
