//classe FinestraColorata
import java.awt.*;

public class FinestraColorata extends Finestra
{
//costruttore   
 public FinestraColorata(int x, int y, int lar, int alt, Color c)
    {
        super(x,y,lar,alt);
        getContentPane().setBackground(c);
    }    
}