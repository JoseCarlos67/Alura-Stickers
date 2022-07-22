import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;
import javax.imageio.ImageIO;


public class GeradoraDeFigurinha {
    
    void cria(InputStream inputStream, String nomeArquivo) throws Exception {

        // Leitura da imagem
        // InputStream inputStream = new FileInputStream(new File("entrada/filme.jpg"));
        // InputStream inputStream = new URL("https://m.media-amazon.com/images/M/MV5BMTMxNTMwODM0NF5BMl5BanBnXkFtZTcwODAyMTk2Mw@@.jpg").openStream();
        BufferedImage imgOriginal =  ImageIO.read(inputStream);

        // Cria nova imagem em memória com transparência e com tamanho novo
        int width = imgOriginal.getWidth();
        int height = imgOriginal.getHeight();
        int newHeight = height + 200;
        BufferedImage newImage = new BufferedImage(width, newHeight, BufferedImage.TRANSLUCENT);

        // Copiar a imagem original para nova imagem (em memória)
        Graphics2D graphics = (Graphics2D) newImage.getGraphics();
        graphics.drawImage(imgOriginal, 0, 0, null);

        // Configurar a fonte
        var font = new Font(Font.SANS_SERIF, Font.BOLD, 84);
        graphics.setColor(Color.YELLOW);
        graphics.setFont(font);

        // Escrever uma frase na nova imagem
        var imgLargura = width/2;
        graphics.drawString("Top", imgLargura, newHeight - 100);
        

        // Escrever a nova imagem em um arquivo
        ImageIO.write(newImage, "png", new File(nomeArquivo));

    }

} // Fim da classe GeradoraDeFigurinha
