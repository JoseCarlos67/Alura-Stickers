import java.io.InputStream;
import java.net.URL;
import java.util.List;

public class App { 

    public static void main(String[] args) throws Exception   { 

        // Faz uma conexão HTTP
        
        // API da Nasa
        String url = "https://api.nasa.gov/planetary/apod?api_key=BLeapqOHd6fZD7rEKyro9WuncuzHWOdonVJ65WCq&start_date=2022-06-12&end_date=2022-06-30";
        // API do IMDB
        // String url = "https://api.mocki.io/v2/549a5d8b/Top250Movies";

        ClienteHTTP http = new ClienteHTTP();
        String json = http.buscaDados(url);

        // Exibir e manipular os dados
        ExtratorDeConteudo extrator = new  ExtratorDeConteudo_NASA();
        // ExtratorDeConteudo_IMDB extrator = new ExtratorDeConteudo_IMDB();
        List<Conteudo> conteudos = extrator.extraiConteudos(json);

        var geradora = new GeradoraDeFigurinha();

        for (Conteudo conteudo : conteudos) {

            InputStream inputStream = new URL(conteudo.getUrlImagem()).openStream();
            String nomeArquivo = "saida/" + conteudo + ".png";
           
            geradora.cria(inputStream, nomeArquivo);

            System.out.println("\u001b[97m \u001b[104mNome:\u001b[m " + conteudo.getTitulo());
            // System.out.println(filme.get("image"));
            // System.out.println(filme.get("imDbRating"));
            System.out.println();
        }

    } // Fim do método main

} // Fim da classe App
