import br.com.exercicio.api.ConsultaCep;
import br.com.exercicio.api.ConsultaCepJson;
import br.com.exercicio.api.excecoes.CepNaoEncontradoException;
import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class MainConsultaCep {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Informe o CEP que deseja consultar (Apenas Numeros): ");
        String cepInformado = entrada.nextLine();
        entrada.close();

        System.out.println();

        String urlConsultaAPI = "https://viacep.com.br/ws/" + cepInformado + "/json/";

        try {


            //inicializando o http request
            HttpClient client = HttpClient.newHttpClient();

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(urlConsultaAPI))
                    .build();

            //inicializando o http response
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            //validando requisição
            //System.out.println(response.statusCode());
            if (response.statusCode() == 400){
                throw new CepNaoEncontradoException("CEP não encontrado :(" + "\n" + "Tente Novamente...");
            }

            Gson gson = new Gson();

            String json = response.body();

            ConsultaCepJson consultaCepJson = gson.fromJson(json, ConsultaCepJson.class);

            if (consultaCepJson.erro().equals("true")){
                throw new CepNaoEncontradoException("CEP não encontrado :(" + "\n" + "Tente Novamente...");
            }

            ConsultaCep consultaCep = new ConsultaCep(consultaCepJson);

            System.out.println(consultaCep);

        }catch (CepNaoEncontradoException e){
            System.out.println(e.getMessage());
        }

    }
}
