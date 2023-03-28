import javax.swing.*;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws Exception {

        // Fazer uma conexão HTTP e buscar os top 10 filmes
        String url = "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies.json";
        URI address = URI.create(url);
        var client = HttpClient.newHttpClient();
        var request = HttpRequest.newBuilder(address).GET().build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        String body = response.body();

        // Extarir somente os dados necessários (título, poster, nota)
        JsonParser parser = new JsonParser();
        List<Map<String, String>> moviesList = parser.parse(body);

        // Exibir e manipular os dados
        StickerGenerator sg = new StickerGenerator();
        for (Map<String, String> movie: moviesList) {
            String urlImage = movie.get("image");
            String fileName = movie.get("title") + ".png";
            InputStream inputStream = new URL(urlImage).openStream();

            sg.make(inputStream, fileName);
            //System.out.println(movie.get("title"));
            //System.out.println(movie.get("image"));
            //System.out.println(movie.get("imDbRating"));
            //System.out.println();
        }
        
    }
}