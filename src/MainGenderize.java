import br.com.exercicio.api.Genderize;
import br.com.exercicio.api.GenderizeJson;
import br.com.exercicio.api.excecoes.GeneroNaoEstimadoException;
import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class MainGenderize {
    public static void main(String[] args) throws IOException, InterruptedException {

        Scanner entrada = new Scanner(System.in);
        System.out.println("Informe um nome: ");
        String nomeInformado = entrada.nextLine();
        nomeInformado = nomeInformado.replace(" ", "");
        entrada.close();

        String urlConsultaAPI = "https://api.genderize.io/?name=" + nomeInformado;

        try {

            HttpClient client = HttpClient.newHttpClient();

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(urlConsultaAPI))
                    .build();

            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            //System.out.println(response.body());

            String json = response.body();

            Gson gson = new Gson();

            GenderizeJson genderizeJson = gson.fromJson(json, GenderizeJson.class);

            if (genderizeJson.gender() == null){
                throw new GeneroNaoEstimadoException("Não conseguimos estimar um genero... :(");
            }

            Genderize genderize = new Genderize(genderizeJson);

            System.out.println(genderize);

        }catch (GeneroNaoEstimadoException e){
            System.out.println(e.getMessage());
        }catch (Exception e){
            System.out.println("Erro ao consultar... :(");
        }
    }
}
