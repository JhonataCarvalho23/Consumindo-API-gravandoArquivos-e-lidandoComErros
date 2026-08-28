package exercicios.exercicio1;

import com.google.gson.Gson;
import java.util.Scanner;

record Pessoa(String nome, int idade, String cidade) {}

public class Main {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.println("Digite seu nome: ");
		String nome = sc.nextLine();

		System.out.println("Digite sua idade: ");
		int idade = sc.nextInt();
		sc.nextLine();

		System.out.println("Digite a sua cidade: ");
		String cidade = sc.nextLine();

		String json = String.format("{\"nome\":\"%s\",\"idade\":\"%d\",\"cidade\":\"%s\"}", nome, idade, cidade);

		System.out.println(json);

		Gson gson = new Gson();

		Pessoa pessoa = gson.fromJson(json, Pessoa.class);

		System.out.println("Objeto pessoa: " + pessoa);
	}
}