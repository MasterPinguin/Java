/*
I dati sugli stipendi di 5 dipendenti nei primi 3 mesi dell’anno sono organizzati in una matrice,
il numero di riga indica il numero del dipendente, il numero di colonna indica il mese.
Calcolare la somma degli stipendi pagati al secondo dipendente.
*/
import java.util.Scanner;

public class Main
{
	public static void main(String[] args) 
	{
	    int som=0;
		int mat[][] = new int[3][5];
		
		Scanner x = new Scanner(System.in);
		
		System.out.println("  dipendente1  dipendente2  dipendente3  dipendente4  dipendente5");
		for(int j=0 ; j<3 ; j++)
        {
            System.out.print("mese 0"+j+1);
            
            for(int i=0 ; i<5 ; i++)
            {
                mat[j][i] = (int)(Math.random()*2000);
                System.out.print("  "+mat[j][i]+"       ");
                if(j==2)
                {
                    som=som+mat[j][i];
                }
            }
            System.out.println("");
        }
        
        System.out.println("la somma degli stipendi del secondo dipendente è: "+som);
	}
}