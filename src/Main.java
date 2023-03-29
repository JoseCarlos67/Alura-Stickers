import java.io.InputStream;
import java.net.URL;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {

        // Fazer uma conexão HTTP e buscar os top 10 filmes
        //String url = "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies.json";
        //ContentExtractor extractor = new ImdbContentExtractor();

        String url = "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/NASA-APOD-JamesWebbSpaceTelescope.json";
        ContentExtractor extractor = new NasaContentExtractor();

        var http = new ClientHTTP();
        String json = http.searchData(url);

        // Exibir e manipular os dados
        List<Contents> contents = extractor.extractContents(json);
        var sg = new StickerGenerator();

        for (Contents content : contents) {
            InputStream inputStream = new URL(content.getUrlImage()).openStream();
            String fileName = content.getTitle() + ".png";
            sg.make(inputStream, fileName);
        }

    }

}