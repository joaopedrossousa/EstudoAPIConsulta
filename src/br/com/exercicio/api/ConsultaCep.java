package br.com.exercicio.api;

public class ConsultaCep {
    private String localidade;
    private String uf;
    private String estado;
    private String regiao;
    private String ddd;

    public ConsultaCep(ConsultaCepJson consultaCepJson){
        this.localidade = consultaCepJson.localidade();
        this.uf = consultaCepJson.uf();
        this.estado = consultaCepJson.estado();
        this.regiao = consultaCepJson.regiao();
        this.ddd = consultaCepJson.ddd();
    }

    @Override
    public String toString() {
        return "-----------------------" + "\n" +
                "Nome Cidade: " + localidade + "\n" +
                "UF: " + uf + "\n" +
                "Estado: " + estado + "\n" +
                "Região: " + regiao + "\n" +
                "DDD: " + ddd + "\n" +
                "-----------------------";
    }
}

