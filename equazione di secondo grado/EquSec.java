/*
Scrivere un programma in Java che permetta di risolvere un'equazione di
secondo grado.
 */
import java.util.Scanner;
import java.lang.Math;

public class EquSec
{ 
    public static void main(String args[]) 
    {
        Scanner y = new Scanner(System.in);      
        int a,b,c;
        double x1,x2,d;
        System.out.println("ax2+bx+c=0");
        System.out.print("inserisci a:");
        a = y.nextInt();
        System.out.print("inserisci b:");
        b = y.nextInt(); 
        System.out.print("inserisci c:");
        c = y.nextInt();
        
        d=(b*b) + (-4*a*c);
        if(d>=0)
        {
            if(d>0)
            {
                System.out.println("il delta e’ maggiore di 0 quini:");
                d=Math.sqrt(d);
                x1=(-1*b +d)/(a*2);
                x2=(-1*b -d)/(a*2);
                System.out.println("il risultati x1,x2 sono rispettivamente:"+x1 +" e "+x2); 
            }
            else
            {
                System.out.println("il delta e’ uguale e 0 quini:");
                x2=(-1*b)/(a*2);
                System.out.println("il risultato dell'equazione e’:"+x2);
            }
            
        }
        else
        {
            System.out.println("il delta e’ minore di 0 quini:");
            System.out.println("l'equazione e' impossibile");
        }
    }
}