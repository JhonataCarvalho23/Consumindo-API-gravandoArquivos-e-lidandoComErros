package br.com.alura.screenmatch.principal;

import java.util.Scanner;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

public class PrincipalComBusca{
	public static void main(String[] args) throws Exception {

	String apiKey = System.getenv("OMDB_API_KEY");
	Scanner sc = new Scanner(System.in);


	System.out.println("Digite o nome de um filme para fazer uma busca");
	String busca = sc.nextLine();

	String endereco = "https://www.omdbapi.com/?t=" + busca + "&apikey=" + apiKey + "&";

	HttpClient client = HttpClient.newHttpClient();
	HttpRequest request = HttpRequest.newBuilder()
      .uri(URI.create(endereco))
      .build();

    HttpResponse<String> response = client
    	.send(request, BodyHandlers.ofString());

    System.out.println(response.body());
}
}