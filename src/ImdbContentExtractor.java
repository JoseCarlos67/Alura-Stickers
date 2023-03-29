import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ImdbContentExtractor implements ContentExtractor {

    public List<Contents> extractContents(String json) {

        // Extarir somente os dados necessários
        JsonParser parser = new JsonParser();
        List<Map<String, String>> attributeList = parser.parse(json);

        List<Contents> contents = new ArrayList<>();

        // Popular a lista de conteúdos
        for (Map<String, String> attributes : attributeList) {
            String title = attributes.get("title");
            String urlImage = attributes.get("image");
            var content = new Contents(title, urlImage);

            contents.add(content);
        }
        return contents;

    }

}
