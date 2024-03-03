/*
Carica un vettore di N componenti, con N <= 10, poi memorizza le componenti in un
nuovo vettore nell’ordine inverso. Stampa il vettore così ottenuto.
*/
import java.util.Scanner;

public class Main
{
	public static void main(String[] args) 
	{
	    int y;
		int vett[] = new int[10];
		int v[] = new int[10];
		
		Scanner xx = new Scanner(System.in);  
		
		for(int i=0 ; i<vett.length ; i++)
        {
            System.out.println("inserisci l'elemento "+i+" del vettore");
            vett[i] = xx.nextInt();      
        }
        
        y=9;
        
        for(int i=0 ; i<vett.length ; i++)
        {
            v[y]=vett[i];
            y--;
        }
        
        System.out.println(" ");
        System.out.println("visualizzazione del del vettore");
        System.out.println(" ");
        
        for(int i=0 ; i<v.length ; i++)
        {
            System.out.println("nell elemento "+i+" del vettore c'e' il numero:"+v[i]);
        }

	}
}