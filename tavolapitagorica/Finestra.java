import java.awt.*;
import javax.swing.*;  

public class Finestra extends JFrame
{
    static final int labelLar=70;
    static final int labelAlt=70;
    static final int windowLar=900;
    static final int windowAlt=800;
    static final int windowX=200;
    static final int windowY=50;
    static final int labelSpace=70;

    public static void main(String[] args)
    {
        new Finestra();
    }
   
    public Finestra()
    {
        setLayout(null);
        
        addJLabel((""+0),0,0,labelLar,labelAlt,Color.white);
        for(int i=1;i<11;i++)
        {
            addJLabel((""+i),(i*labelSpace),0,labelLar,labelAlt,Color.white);
        }
        
        for(int i=1;i<11;i++)
        {
            addJLabel((""+i),0,(i*labelSpace),labelLar,labelAlt,Color.white);
            
            for(int j=1;j<11;j++)
            {
                if((i*j)%2==0)                
                    addJLabel((""+(i*j)),(j*labelSpace),(i*labelSpace),labelLar,labelAlt,Color.yellow);
                else
                    addJLabel((""+(i*j)),(j*labelSpace),(i*labelSpace),labelLar,labelAlt,Color.orange);
            }
        }
        
        setSize(windowLar,windowAlt);
        setLocation(windowX,windowY);
        setVisible(true);
    }
    
    public void addJLabel(String s, int x, int y, int lar, int alt, Color c)
    {
        JLabel l=new JLabel(s);
        l.setLocation(x,y);
        l.setSize(lar,alt);
        l.setBackground(c);
        l.setOpaque(true);
        l.setVerticalAlignment(JLabel.CENTER);
        l.setHorizontalAlignment(JLabel.CENTER);
        add(l);
    }
}