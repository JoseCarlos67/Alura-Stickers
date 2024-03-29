import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ClientHTTP {

    public String searchData(String url) {

        try {

            URI address = URI.create(url);
            var client = HttpClient.newHttpClient();
            var request = HttpRequest.newBuilder(address).GET().build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            String body = response.body();
            return body;

        } catch (IndexOutOfBoundsException | InterruptedException ex ) {

            throw new RuntimeException(ex);

        } catch (IOException e) {

            throw new RuntimeException(e);

        }


    }

}
