# 🎬 ScreenMatch: Consumindo API, Gravando Arquivos e Lidando com Erros

Projeto desenvolvido ao longo do curso de Java da Alura para aprender na prática como realizar requisições HTTP, consumir APIs externas, manipular dados em formato JSON com a biblioteca **Gson**, utilizar **Records** como DTOs, tratar exceções e gravar informações em disco.

---

## 📌 Navegação pelas Branches

A estrutura do projeto está organizada em branches para que seja possível acompanhar a evolução a cada aula:

| Branch | Status | Tópicos Principais |
| :--- | :---: | :--- |
| [`aula-01`](../../tree/aula-01) | 🛠️ Concluído | Requisições HTTP (`HttpClient`, `HttpRequest`, `HttpResponse`), integração inicial com a API do OMDb e requisições a APIs públicas (Google Books, CoinGecko, TheMealDB). |
| [`aula-02`](../../tree/aula-02) | 🛠️ Concluído | Utilização da biblioteca **Gson**, conversão de JSON para objetos Java via **Record** (`TituloOmdb`) e mapeamento para a classe de domínio (`Titulo`). |
| [`aula-03`](../../tree/aula-03) | ⏳ Em breve | Tratamento de exceções personalizadas (`ErroDeConversaoDeAnoException`), bloco `try-catch` e validação dos dados recebidos da API. |
| [`aula-04`](../../tree/aula-04) | ⏳ Em breve | Escrita e persistência de dados em arquivos `.json` usando `FileWriter` e `Gson`. |

---

## 🚀 Conteúdo Detalhado das Aulas

### 🔹 Aula 01: Requisições HTTP e Consumo de APIs
* **Conexão HTTP:** Instanciação de `HttpClient` e construção de `HttpRequest` para envio de requisições GET.
* **Leitura da Resposta:** Processamento de respostas no formato String utilizando `HttpResponse<String>`.
* **Integração com OMDb:** Construção dinâmica de URIs de busca enviando parâmetro de título.
* **Exercícios Práticos:**
  * Consumo da API do **Google Books** para pesquisa de livros.
  * Consumo da API do **CoinGecko** para cotações de criptomoedas.
  * Consumo da API **TheMealDB** para receitas culinárias.

### 🔹 Aula 02: Desserialização e Records com Gson
* **Biblioteca Gson:** Inclusão e uso da biblioteca Gson (`gson-2.14.0.jar`) para parsing de dados JSON.
* **Records como DTOs:** Implementação do Record `TituloOmdb` para mapear de forma direta e concisa as chaves da API (`Title`, `Year`, `Runtime`).
* **Mapeamento de Objetos:** Conversão do DTO `TituloOmdb` para o objeto de domínio `Titulo`, realizando as adequações de tipo (ex: de String para Integer no ano e na duração).
* **Exercícios Práticos:** Mapeamento de coleções e objetos personalizados em classes Java a partir do JSON de resposta.

---

## 💻 Tecnologias Utilizadas

* **Java 21+**
* **Gson 2.14.0**
* **OMDb API**
* **VS Code / Sublime Text**

---

## ⚙️ Como Executar o Projeto

1. **Clone o repositório:**
   ```bash
   git clone https://github.com/JhonataCarvalho23/Consumindo-API-gravandoArquivos-e-lidandoComErros.git
   ```

2. **Navegue até a branch desejada:**
   ```bash
   git checkout aula-02
   ```

3. **Execute o projeto:**
   Abra a solução na sua IDE e execute a classe principal localizada em:
   `src/br/com/alura/screenmatch/principal/PrincipalComBusca.java`
