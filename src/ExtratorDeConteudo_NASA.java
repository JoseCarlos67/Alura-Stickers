import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ExtratorDeConteudo_NASA implements ExtratorDeConteudo {
   
    public List<Conteudo> extraiConteudos(String json) {

        // Extrai só os dados que interessam 
        var parser = new JsonParser();
        List<Map<String, String>> ListaDeAtributos = parser.parse(json);

        List<Conteudo> conteudos = new ArrayList<>();

        // Popular a lista de conteudos
        
        for (Map<String, String> atributos : ListaDeAtributos) {
        
            String titulo = atributos.get("title");
            String urlImagem = atributos.get("url");
            var conteudo = new Conteudo(titulo, urlImagem);

            conteudos.add(conteudo);

        }

        return conteudos;
    }

} // Fim da classe ExtratorDeConteudo_NASA