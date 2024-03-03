import java.awt.*;
import java.io.*;
import javax.imageio.*;
import javax.swing.*;
import java.awt.event.*;

public class Main {
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new JFrame("Finestra con immagine di sfondo e bottoni");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(1200, 700);
                frame.setResizable(false);
                Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
                frame.setLocation(dim.width/2-frame.getSize().width/2, dim.height/2-frame.getSize().height/2);

                JPanel panel = new JPanel();
                panel.setLayout(new BorderLayout());

                Image backgroundImage = null;
                try {
                    backgroundImage = ImageIO.read(new File("img/sfondo.jpg"));
                } catch (IOException e) {
                    e.printStackTrace();
                }

                JLabel background = new JLabel(new ImageIcon(backgroundImage));
                background.setLayout(new BorderLayout());

                ImageIcon button1Image = new ImageIcon("img/bottone.png");
                JLabel button1 = new JLabel(button1Image);
                button1.setSize(button1Image.getIconWidth(), button1Image.getIconHeight());
                button1.addMouseListener(new MouseAdapter() {
                    public void mouseClicked(MouseEvent e) {
                        // Codice da eseguire quando viene cliccato il primo pulsante
                        System.out.println("Primo pulsante cliccato!");
                    }
                });

                ImageIcon button2Image = new ImageIcon("img/si.png");
                JLabel button2 = new JLabel(button2Image);
                button2.setSize(button2Image.getIconWidth(), button2Image.getIconHeight());
                button2.addMouseListener(new MouseAdapter() {
                    public void mouseClicked(MouseEvent e) {
                        // Codice da eseguire quando viene cliccato il secondo pulsante
                        System.out.println("Secondo pulsante cliccato!");
                    }
                });

                JPanel buttonsPanel = new JPanel();
                buttonsPanel.setOpaque(false);
                buttonsPanel.setLayout(new FlowLayout());
                buttonsPanel.add(button1);
                buttonsPanel.add(button2);

                background.add(buttonsPanel, BorderLayout.CENTER);

                JLabel text = new JLabel();
                text.setText("1.234");
                background.add(text, BorderLayout.WEST);

                JLabel image = new JLabel(new ImageIcon("img/c.png")); 
                background.add(image, BorderLayout.SOUTH);

                frame.setContentPane(background);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }
}
