package br.com.exercicio.api;

public class ConsultaPais {
    private String nomeOficialPais;
    private String capitalPais;
    private String regiao;
    private Double populacao;


    public ConsultaPais(ConsultaPaisJson consultaPaisJson) {
        this.nomeOficialPais = consultaPaisJson.name().official();
        this.capitalPais = consultaPaisJson.capital()[0];
        this.regiao = consultaPaisJson.region();
        this.populacao = consultaPaisJson.population();
    }

    @Override
    public String toString() {
        return "Nome Oficial: " + nomeOficialPais + " \n" +
                "Capital: " + capitalPais + "\n" +
                "Região: " + regiao + "\n" +
                "População: " + populacao + "\n";
    }
}
