import javax.swing.*;
import java.awt.*;

class Input
{
  public static void main(String argv[])
  {
    JFrame f = new JFrame("Input");
    JPanel p = new JPanel();

    JTextField nome = new JTextField(20);
    JTextField prezzo = new JTextField("0", 10);

    p.add(new JLabel("Inserisci il nome: ", JLabel.RIGHT));
    nome.setBackground(Color.yellow);
    p.add(nome);

    p.add(new JLabel("Inserisci il prezzo: ", JLabel.RIGHT));
    prezzo.setForeground(Color.red); //colore del testo rosso
    p.add(prezzo);

    f.add(p);

    f.setSize(200,200);
    f.setLocation(100,100);

    f.setVisible(true);
  }
}