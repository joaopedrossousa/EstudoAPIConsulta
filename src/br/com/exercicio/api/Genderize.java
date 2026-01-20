package br.com.exercicio.api;

public class Genderize {
    private String genero;
    private double probabilidade;

    public Genderize(GenderizeJson genderizeJson) {
        this.genero = genderizeJson.gender();
        if (this.genero.equals("male")){
            this.genero = "Homem";
        } else if (this.genero.equals("female")) {
            this.genero = "Mulher";
        }
        this.probabilidade = genderizeJson.probability();
    }

    @Override
    public String toString() {
        return "Genero: " + genero + "\n" +
                "Probabilidae: " + probabilidade * 100  + "%";
    }
}
