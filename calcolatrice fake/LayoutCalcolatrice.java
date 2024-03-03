import java.awt.*;
import javax.swing.*;
import java.util.*;  

public class LayoutCalcolatrice extends JFrame
{
    static final int windowLar=895;
    static final int windowAlt=933;
    static final int windowX=513;
    static final int windowY=75;

    public static void main(String[] args)
    {
        new LayoutCalcolatrice();
    }
   
    public LayoutCalcolatrice()
    {
        int center=JLabel.CENTER;
        int bottom=JLabel.BOTTOM;
        int left=JLabel.LEFT;
        int right=JLabel.RIGHT;
        Color color;
        int bold=Font.BOLD;
        int plain=Font.PLAIN;
        
        String digits[]=new String[] {"%","CE","C","�","�","�vx","7","8","9","�","x�","4","5","6","-","x�","1","2","3","+","�/�","+/-","0",",","="};
        
        Panel display=new Panel(), keyboard=new Panel();
        
        setLayout(new BorderLayout());
        
        display.setPreferredSize(new Dimension(0,285));
        display.setLayout(new BorderLayout());
        add(display,BorderLayout.NORTH);
        
        keyboard.setLayout(new GridLayout(5,5));
        add(keyboard,BorderLayout.CENTER);
        
        addJLabel(display, "Calcolatrice", plain, 15, center, left, new Color(245,245,245), BorderLayout.NORTH);
        addJLabel(display, null, plain, 15, center, left, new Color(245,245,245), BorderLayout.CENTER);
        addJLabel(display, "0", bold, 80, bottom, left, new Color(245,245,245), BorderLayout.EAST); 
        
        for(int i=0;i<25;i++)
        {
            if(digits[i].equals("0") | digits[i].equals("1") | digits[i].equals("2") | digits[i].equals("3") | digits[i].equals("4") | digits[i].equals("5") | digits[i].equals("6") | digits[i].equals("7") | digits[i].equals("8") | digits[i].equals("9")) 
                
                addJButton(keyboard, digits[i], bold, 30, center, center, Color.white, null);                
            else
                addJButton(keyboard, digits[i], plain, 20, center, center, new Color(242,242,242), null);
        }
        
        setSize(windowLar,windowAlt);
        setLocation(windowX,windowY);
        setVisible(true);
    }
    
    public void addJLabel(Panel p, String s, int font, int fontSize, int vAl, int hAl, Color c, String layout)
    {
        JLabel l=new JLabel(s);
        l.setFont(new Font(l.getFont().getName(),font,fontSize));
        l.setBackground(c);
        l.setOpaque(true);
        l.setVerticalAlignment(vAl);
        l.setHorizontalAlignment(hAl);
        p.add(l,layout);
    }
    
    public void addJButton(Panel p, String s, int font, int fontSize, int vAl, int hAl, Color c, String layout)
    {
        JButton l=new JButton(s);
        l.setFont(new Font(l.getFont().getName(),font,fontSize));
        l.setBorder(BorderFactory.createLineBorder(new Color(247,247,247)));
        l.setBackground(c);
        l.setOpaque(true);
        l.setVerticalAlignment(vAl);
        l.setHorizontalAlignment(hAl);
        p.add(l,layout);
    }
}