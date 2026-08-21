package exercicios;

import java.util.Scanner;
import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpClient;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;


public class TheMealDB {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);

		System.out.println("Diga o nome da comida que você deseja ver a receita: ");
		String alimento = sc.nextLine();

		String endereco = "https://www.themealdb.com/api/json/v1/1/search.php?s=" + alimento;

		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder()
			.uri(URI.create(endereco))
			.build();

		HttpResponse<String> response = client
			.send(request, BodyHandlers.ofString());

		System.out.println(response.body());
	}
}