import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.font.FontRenderContext;
import java.awt.font.TextLayout;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
// import java.io.FileInputStream;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class StickerGenerator {
    public void create(InputStream inputStream, String Filename, String text, InputStream inputOverlayimage) throws Exception {
        // leitura da imagem
        // Exemplo para arquivo:
        // FileInputStream inputStream = new FileInputStream(new File("Alura_Stickers/entrada/filme.jpg"));
        // Exemplo para extrair a imagem a partir da página web
        // InputStream inputStream = new URL("https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies_8.jpg").openStream();
        BufferedImage original = ImageIO.read(inputStream);

        // cria nova imagem em memória com transparência e com tamanho
        int width = original.getWidth();
        int height = original.getHeight();
        // Extrai a altura da imagem original e acrescenta 200 pixels
        int newheight = height + 200;
        BufferedImage newImage = new BufferedImage(width, newheight, BufferedImage.TRANSLUCENT);

        // copiar imagem original para nova imagem (em memória)
        Graphics2D graphics = (Graphics2D) newImage.getGraphics();
        graphics.drawImage(original, 0, 0, null);

        // Sobreposição da imagem
        BufferedImage imageOverlay = ImageIO.read(inputOverlayimage);
        int positionImageOverlay_Y = newheight - imageOverlay.getHeight();
        graphics.drawImage(imageOverlay, 0, positionImageOverlay_Y, null);

        // configurar a fonte
        var font_ = new Font("Impact", Font.BOLD, 89);
        graphics.setFont(font_);
        graphics.setColor(Color.WHITE);

        // escrever uma frase na nova imagem
        // Calcula o tamanho da letra e a centraliza
        FontMetrics fontMetrics = graphics.getFontMetrics();
        Rectangle2D retangulo = fontMetrics.getStringBounds(text, graphics);
        int Textwidth = (int) retangulo.getWidth();
        int Textpositionx = (width - Textwidth)/2;
        int Textpositiony = newheight - 80;
        graphics.drawString(text, Textpositionx, Textpositiony);

        // Criação de uma outline para a String
        FontRenderContext fontRenderContext = graphics.getFontRenderContext();
        var TextLayout = new TextLayout(text, font_, fontRenderContext);
        Shape outline = TextLayout.getOutline(null);
        AffineTransform transform = graphics.getTransform();
        transform.translate(Textpositionx, Textpositiony);
        graphics.setTransform(transform);

        var outlineStroke = new BasicStroke(width * 0.004f);
        graphics.setStroke(outlineStroke);

        // Desehando o contorno
        graphics.setColor(Color.BLACK);
        graphics.draw(outline);
        graphics.setClip(outline);

        // escrever a nova imagem em um arquivo
        ImageIO.write(newImage, "png", new File(Filename));

    }
}