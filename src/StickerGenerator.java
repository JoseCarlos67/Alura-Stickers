import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;

public class StickerGenerator {

    void make(InputStream inputStream, String fileName) throws Exception {
        // Leitura da imagem
          //InputStream inputStream = new FileInputStream("input/movie.jpg");
          //InputStream inputStream = new URL("https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies_3.jpg").openStream();
        BufferedImage originalImage = ImageIO.read(inputStream);

        // Criar uma nova imagem (em memória)
        int width = originalImage.getWidth();
        int height = originalImage.getHeight();
        int newHeight = height + 200;
        BufferedImage newImage = new BufferedImage(width, newHeight, BufferedImage.TRANSLUCENT);

        // Copiar a nova imagem para a imagem original (em memória)
        Graphics2D graphics = (Graphics2D) newImage.getGraphics();
        graphics.drawImage(originalImage, 0, 0, null);

        // Configurar a fonte
        Font font = new Font(Font.SANS_SERIF, Font.BOLD, 99);
        graphics.setFont(font);
        graphics.setColor(Color.red);

        // Escrever na nova imagem
        String newFileName = fileName.substring(0, fileName.length() - 4); // Remove o ".png" do nome do arquivo para poder escrever na imagem.
        graphics.drawString(newFileName, 0, newHeight - 100);

        // Escrever a nova imagem em um arquivo
        if (!new File("output").exists()) {
            new File("output").mkdir();
            ImageIO.write(newImage, "png", new File("output/" + fileName));
        } else {
            ImageIO.write(newImage, "png", new File("output/" + fileName));
        }


    }
}
