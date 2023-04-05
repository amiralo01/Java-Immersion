import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URL;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("\u001b[32mConsumindo uma \u001b[1m\u001b[33mAPI\u001b[0m\u001b[32m de imagens da \u001b[1m\u001b[34mNASA\u001b[0m\u001b[32m ou do \u001b[1m\u001b[34mIMDB\u001b[0m\u001b[32m com Java:\u001b[0m");
        System.out.println(" \u001b[34m------------------------------------\u001b[0m ");

        // Realizar uma conexão HTTP e pegar os dados de filmes.
        String url = "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies.json";

        // Realizar um conexão HTTP e pegar os dados de imagens da NASA.
        // String url = "https://api.nasa.gov/planetary/apod?api_key=jho6C5BuYNnxIWMAVI1ERrTQ1n6A2OHi3zC6nXh0&start_date=2023-01-01&end_date=2023-04-02";
        
        var http = new ClientHttp();
        String json = http.searchData(url);


        // Exibir e manipular os dados

        // Pra extrair e manipular os dados da NASA:
        // var extractor = new ExtractorFromNASA();

        // Pra extrair e manipular os dados do IMDB:
        var extractor = new ExtractorContent_IMDB();


        List<Content> contents = extractor.extractorContent(json);
    
        // Pegar até 5 imagens.
        for (int i = 0; i < 10; i++) {

            // Criando um diretório se não existir e se existir mandar as figurinhas para lá
            var directory = new File("stickers/");
            directory.mkdir();

            Content content = contents.get(i);
            //"\u001b[1m" para Negrito
            //"\u001b[0m" para finalizar o Negrito
            // Extrai as imagens da NASA.
            
            String TextSticker;
            InputStream myImage;

            TextSticker = "The Bests!";
            myImage = new FileInputStream(new File("Overlay/I_The_Bests_-removebg-Sem fundo!.png"));

            InputStream inputStream = new URL(content.urlImage()).openStream();
            String Filename = "stickers/" + content._Title() + ".png";

            var Generator = new StickerGenerator();
            Generator.create(inputStream, Filename, TextSticker, myImage); 

            // Título das Imagens
            System.out.println("\u001b[1m\u001b[32mTitle: \u001b[0m " + content._Title());

            System.out.println("\n");
        }
    }
}