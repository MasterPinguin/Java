//classe Finestra
import java.awt.*;
import javax.swing.*;  

public class Finestra extends JFrame
{
    public Finestra(int x, int y, int lar, int alt)
    {
       setVisible(true); 
       setSize(lar,alt);
       setLocation(x,y); 
    }
}