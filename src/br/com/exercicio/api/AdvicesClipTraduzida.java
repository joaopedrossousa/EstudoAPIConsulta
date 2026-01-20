package br.com.exercicio.api;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;

public class AdvicesClipTraduzida {

    public String traduzir(String textoEmIngles) throws IOException, InterruptedException {

        String textoCodificado =
                URLEncoder.encode(textoEmIngles, StandardCharsets.UTF_8);

        String urlConsultaAPI = "https://libretranslate.de/translate";

        String corpoRequisicao =
                "q=" + textoCodificado +
                        "&source=en" +
                        "&target=pt";

        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(urlConsultaAPI))
                .header("Content-Type", "application/x-www-form-urlencoded")
                .POST(HttpRequest.BodyPublishers.ofString(corpoRequisicao))
                .build();

        HttpResponse<String> response =
                client.send(request, HttpResponse.BodyHandlers.ofString());
        
        System.out.println("Resposta da API de tradução:");
        System.out.println(response.body());

        if (response.statusCode() != 200) {
            throw new RuntimeException("Erro ao traduzir texto.");
        }

        Gson gson = new Gson();
        TraducaoJson traducaoJson =
                gson.fromJson(response.body(), TraducaoJson.class);

        if (traducaoJson == null || traducaoJson.translatedText() == null) {
            throw new RuntimeException("Resposta de tradução inválida.");
        }

        return traducaoJson.translatedText();
    }
}
