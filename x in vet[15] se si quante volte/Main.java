/*
Dato un vettore di 15 elementi, inserire un numero da tastiera e controllare se esiste
nel vettore. In caso affermativo, contare quante volte compare all’interno del vettore
e visualizzare a video la risposta e l’eventuale numero di volte che compare.
*/
import java.util.Scanner;

public class Main
{
	public static void main(String[] args) 
	{
	    int x,y=0;
		int vett[] = new int[15];
		
		Scanner xx = new Scanner(System.in);  
		
		for(int i=0 ; i<vett.length ; i++)
        {
            vett[i] = (int)(Math.random()*10);
        }
        
        do
        {
            System.out.println("inserisci il numero da cercare nel vettore (il numero deve essere compreso tra 0 e 10):");
            x = xx.nextInt(); 
        }
        while(x<0 || x>10);
        
        for(int i=0 ; i<vett.length ; i++)
        {
            if(vett[i]==x)
            {
                y++;
            }
        }
        if(y!=0)
        {
           System.out.println("l'elemento inserito da tastiera: "+x+" è contenuto nel vettore "+y+" volte");
        }
        else
        {
           System.out.println("l'elemento inserito da tastiera: "+x+" non è contenuto nel vettore");
        }
	}
}