/*
Dato un vettore di 6 elementi visualizzare il valore massimo e tutti gli elementi del vettore.
*/
import java.util.Scanner;

public class Main
{
	public static void main(String[] args) 
	{
	    int x=0,y=0;
		int vett[] = new int[6];
		
		Scanner xx = new Scanner(System.in);  
		
		for(int i=0 ; i<vett.length ; i++)
        {
            System.out.println("inserisci l'elemento "+i+" del vettore");
            vett[i] = xx.nextInt();      
        }
        
        for(int i=0 ; i<vett.length ; i++)
        {
            if(vett[i]>x)
            {
                x=vett[i];
                y=i;
            }
        }
        System.out.println(" ");
        System.out.println("il numero piu grande del vettore risiede nella cella: "+y+" e il numero e': "+ x);  
        System.out.println(" ");
        System.out.println("visualizzazione del resto del vettore");
        System.out.println(" ");
        for(int i=0 ; i<vett.length ; i++)
        {
            if(i==y)
            {
            }
            else
            {
                System.out.println("nell elemento "+i+" del vettore c'e' il numero:"+vett[i]);
            }
        }

	}
}