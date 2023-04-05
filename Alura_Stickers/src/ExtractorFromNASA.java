import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ExtractorFromNASA {
    public List<Content> extractorContent(String json){

        // Extrair só os dados que interessam (título, poster, classificação)
        var parser = new JsonParser();
        List<Map<String, String>> AtributeList = parser.parse(json);

        List<Content> contents = new ArrayList<>();

        //popular a lista de conteudos
        for (Map<String, String> atributes : AtributeList){
            String title = atributes.get("title");
            String urlImage = atributes.get("url");
            String urlLargerImage = urlImage.replaceFirst("(@?\\.)([0-9A-Z,_]+).jpg$", "$1.jpg");
            var content = new Content(title, urlLargerImage);

            contents.add(content);
        }
        return contents;

    }
}
