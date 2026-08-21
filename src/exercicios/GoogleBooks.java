package exercicios;

import java.util.Scanner;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

public class GoogleBooks {
	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);
		String apiKey = System.getenv("GOOGLEBOOKS_API_KEY");

		System.out.println("Digite o nome de um livro para busca: ");
		String nomeDoLivro = sc.nextLine();


		String endereco = "https://www.googleapis.com/books/v1/volumes?q=" + nomeDoLivro + ":keyes&key=" + apiKey;

		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder()
			.uri(URI.create(endereco))
			.build();

		HttpResponse<String> response = client
			.send(request, BodyHandlers.ofString());

		System.out.println(response.body());

	}
}