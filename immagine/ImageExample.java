import javax.swing.*;
import java.awt.*;

public class ImageExample {
    public static void main(String[] args) {
        ImageIcon image = new ImageIcon("images/image.jpg");
        JLabel label = new JLabel(image);

        JFrame frame = new JFrame("Image Example");
        frame.getContentPane().add(label, BorderLayout.CENTER);
        frame.pack();
        frame.setVisible(true);
    }
}