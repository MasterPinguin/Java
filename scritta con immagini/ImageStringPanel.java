import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class ImageStringPanel extends JPanel {
    private static final long serialVersionUID = 1L;

    private String numbers;
    BufferedImage[] numberImages = new BufferedImage[10];
    BufferedImage coin = null;

    public ImageStringPanel(String numbers) {
        this.numbers = numbers;
        
        try {
        coin = ImageIO.read(new File("img/c.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            for (int i = 0; i < 10; i++) {
            numberImages[i] = ImageIO.read(new File( "img/" + i + ".png"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int x = 0;
        for (int i = 0; i < numbers.length(); i++) {
            int num = Character.getNumericValue(numbers.charAt(i));
            g.drawImage(numberImages[num], x, 0, 35, 50, null);
            x += 35;
        }
        g.drawImage(coin, x, 0, 49, 49, null);
    }
}
