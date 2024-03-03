import java.awt.*;
import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Finestra con immagine di sfondo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ImageIcon backgroundImage = new ImageIcon("img/si.jpg");
        JLabel background = new JLabel(backgroundImage);
        background.setLayout(new BorderLayout());

        JButton button1 = new JButton("Pulsante 1");
        JButton button2 = new JButton("Pulsante 2");
        background.add(button1, BorderLayout.WEST);
        background.add(button2, BorderLayout.EAST);

        frame.setContentPane(background);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
