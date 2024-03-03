/*
Dopo aver caricato in memoria una matrice di interi quadrata di ordine n (con n inserito da
tastiera non superiore a 10), sommare gli elementi della diagonale principale.
*/
import java.util.Scanner;

public class Main
{
	public static void main(String[] args) 
	{
	    int n, som=0;
	    
	    Scanner x = new Scanner(System.in);
	    
	    do
	    {
	        System.out.println("inserisci il valore di n:");
	        n = x.nextInt();      
	    }
	    while(n>10);
	    
		int mat[][] = new int[n][n];
		
		for(int j=0 ; j<n ; j++)
        {
            for(int i=0 ; i<n ; i++)
            {
                mat[j][i] = (int)(Math.random()*100);
                if(j==i)
                {
                    som=som+mat[j][i];
                }
            }
        }
        
        System.out.println("la somma della diagonale principale della matrice è: "+som);
	}
}