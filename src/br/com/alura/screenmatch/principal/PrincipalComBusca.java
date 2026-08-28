package br.com.alura.screenmatch.principal;

import br.com.alura.screenmatch.modelos.Titulo;
import br.com.alura.screenmatch.modelos.TituloOmdb;

import java.util.Scanner;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

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

	String json = response.body(); 

	Gson gson = new GsonBuilder() 
		.setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
		.create();


    //Titulo meuTitulo = gson.fromJson(json, Titulo.class);
	TituloOmdb titulo = gson.fromJson(json, TituloOmdb.class);
    System.out.println(titulo);

	Titulo meuTitulo = new Titulo(titulo);

	System.out.println(meuTitulo);

}
}