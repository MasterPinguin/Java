import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class Main {
public static void main(String[] args) {
        String number = "100";

        ImageStringPanel num = new ImageStringPanel(number);
        num.setPreferredSize(new Dimension(300, 80));

        JFrame frame = new JFrame("Image String");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(num);
        frame.pack();
        frame.setVisible(true);
    }
}