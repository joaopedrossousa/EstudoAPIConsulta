import br.com.exercicio.api.AdvicesClip;
import br.com.exercicio.api.AdvicesClipJson;
import br.com.exercicio.api.AdvicesClipTraduzida;
import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class MainAdvicesClip {
    public static void main(String[] args) throws IOException, InterruptedException {

        String urlConsultaAPI = "https://api.adviceslip.com/advice";

        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(urlConsultaAPI))
                .build();

        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());

        //System.out.println(response.body());

        Gson gson = new Gson();

        String json = response.body();

        AdvicesClipJson advicesClipJson = gson.fromJson(json, AdvicesClipJson.class);

        AdvicesClip advicesClip = new AdvicesClip(advicesClipJson);

        System.out.println();

        System.out.println(advicesClip);

        System.out.println();

        AdvicesClipTraduzida tradutor = new AdvicesClipTraduzida();

        String traducao = tradutor.traduzir(advicesClip.getConselho());

        System.out.println("Conselho traduzido:");
        System.out.println(traducao);








    }
}
