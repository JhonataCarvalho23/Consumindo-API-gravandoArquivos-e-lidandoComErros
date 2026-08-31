package exercicios.exercicio2;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.Scanner;

record Pessoa(String nome, int idade, String cidade) {}

public class Exercicio2 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("\nDigite seu nome: ");
        String nome = sc.nextLine();

        System.out.println("\nDigite a cidade que você mora: ");
        String cidade = sc.nextLine();

        String jsonPessoa = "{\"nome\":\"" + nome + "\",\"cidade\":\"" + cidade + "\"}";

        Gson gson = new GsonBuilder().setLenient().create();
        Pessoa pessoa = gson.fromJson(jsonPessoa, Pessoa.class);

        System.out.println("Objeto Pessoa: " + pessoa);
    }
}