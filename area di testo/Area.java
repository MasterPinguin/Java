import javax.swing.*;
import java.awt.*;
import java.awt.Color;

class Area
{
  public static void main(String argv[])
  {
    JFrame f = new JFrame("Area di testo");
    JPanel p = new JPanel();
    
    JTextArea messaggi = new JTextArea(10, 30);
    p.add(messaggi);
    
    f.getContentPane().add(p);
    f.setSize(500,300);
    f.setLocation(100,0);
    f.setVisible(true);
  }
}