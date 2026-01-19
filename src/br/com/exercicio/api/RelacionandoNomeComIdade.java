package br.com.exercicio.api;

public class RelacionandoNomeComIdade {
    private Integer idade;
    private String nome;

    public RelacionandoNomeComIdade(RelacionandoNomeComIdadeJson relacionandoNomeComIdadeJson) {
        this.idade = relacionandoNomeComIdadeJson.age();
        this.nome = relacionandoNomeComIdadeJson.name();
    }

    @Override
    public String toString() {
        return "Idade Estimada: " + idade + "\n" +
                "Nome: " + nome;
    }
}
