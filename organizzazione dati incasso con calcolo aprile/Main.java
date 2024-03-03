/*
I dati sugli incassi di 3 reparti di un grande magazzino nei primi 6 mesi dell’anno sono
organizzati in una matrice, il numero di riga indica il numero del reparto, il numero di colonna
indica il mese. Calcolare l’incasso totale del mese di aprile.
*/
import java.util.Scanner;

public class Main
{
	public static void main(String[] args) 
	{
	    int som=0;
		int mat[][]=new int[6][3];
		
		Scanner x = new Scanner(System.in);
		
		System.out.println("        reparto1    reparto2    reparto3");
		for(int j=0 ; j<3 ; j++)
        {
            System.out.print("mese 0"+(j+1));
            
            for(int i=0 ; i<5 ; i++)
            {
                mat[j][i] = (int)(Math.random()*90000);
                System.out.print("  "+mat[j][i]+"     ");
                if(i==4)
                {
                    som=som+mat[j][i];
                }
            }
            System.out.println(" ");
        }
        
        System.out.println("l’incasso totale del mese di aprile è: "+som);
	}
}
