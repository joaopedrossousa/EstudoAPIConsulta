import br.com.exercicio.api.ConsultaPais;
import br.com.exercicio.api.ConsultaPaisJson;
import br.com.exercicio.api.excecoes.PaisNaoEncontradoException;
import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class MainAPIRestCountries {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Informe o País que Deseja Consultar: ");
        String paisInformado = scanner.nextLine();

        System.out.println();

        String urlConsultaAPI = "https://restcountries.com/v3.1/name/" + paisInformado;

        try {

            HttpClient client = HttpClient.newHttpClient();

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(urlConsultaAPI))
                    .build();

            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            //validando retorno api
            //System.out.println(response.statusCode());
            //System.out.println(response.body());

            if (response.statusCode() == 404){
                throw new PaisNaoEncontradoException("País não encontrado :(");
            }

            String json = response.body();

            Gson gson = new Gson();

            ConsultaPaisJson[] consultaPaisJson = gson.fromJson(json, ConsultaPaisJson[].class);

            if (consultaPaisJson.length == 0){
                throw new PaisNaoEncontradoException("País não encontrado :(");
            }

            ConsultaPais consultaPais = new ConsultaPais(consultaPaisJson[0]);

            System.out.println(consultaPais);

        } catch (PaisNaoEncontradoException e) {
            System.out.println(e.getMessage());
        } catch (Exception e){
            System.out.println("Erro ao consultar...Tente novamente! ");
        }
    }
}
