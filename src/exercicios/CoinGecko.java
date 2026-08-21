package exercicios;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

public class CoinGecko {
	public static void main(String[] args) throws Exception {
		String apiKey = System.getenv("COINGECKO_API_KEY");
		String endereco = "https://api.coingecko.com/api/v3/simple/price?ids=bitcoin&vs_currencies=usd";

		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder()
			.uri(URI.create(endereco))
			.header("x-cg-demo-api-key", apiKey)
			.build();

		HttpResponse<String> response = client
			.send(request, BodyHandlers.ofString());

		System.out.println(response.body());
	}
}