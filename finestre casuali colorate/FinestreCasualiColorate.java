//main FinestreCasualiColorate

import java.util.Scanner;
import java.awt.*;

public class FinestreCasualiColorate
{    
    public static void main (String args[])
    {
        Scanner input=new Scanner(System.in);
        
        int n,x,y,lar,alt,red,green,blue;
        
        System.out.println("Specificare il numero di finestre da creare: ");
        n = input.nextInt();
        
        
        for (int i=0;i<n;i++)
        {
            x=(int)(Math.random()*1920);
            y=(int)(Math.random()*1080);
            lar=(int)(Math.random()*1000);
            alt=(int)(Math.random()*1000);
            red=(int)(Math.random()*255);
            green=(int)(Math.random()*255);
            blue=(int)(Math.random()*255);
            
            new FinestraColorata(x,y,lar,alt,new Color(red,green,blue));
        }        
    }
}