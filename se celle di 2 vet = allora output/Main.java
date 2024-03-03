/*
Dopo aver riempito 2 vettori di N elementi, verifica se i due array sono uguali, in
altre parole se alla stessa posizione in entrambi gli array corrisponde lo stesso
contenuto. Restituisci la risposta.
*/
import java.util.Scanner;

public class Main
{
	public static void main(String[] args) 
	{
	    int x=0;
		int vet1[] = new int[6];
		int vet2[] = new int[6];
		int cmp[] = new int[6];
		
		Scanner xx = new Scanner(System.in);  
		
		for(int i=0 ; i<vet1.length ; i++)
        {
            System.out.println("inserisci l'elemento "+i+" del primo vettore");
            vet1[i] = xx.nextInt();   
            
            System.out.println("inserisci l'elemento "+i+" del secondo vettore");
            vet2[i] = xx.nextInt(); 
            
            if(vet1[i]==vet2[i])
            {
                cmp[x]=i+1;
                x++;
            }
        }
        
        if(cmp[0]!=0)
        {
            System.out.println(" ");
            System.out.println("visualizzazione delle posizioni e degli elementi uguali nel vettore ");
            System.out.println(" ");
            for(int i=0 ; i<x ; i++)
            {
               System.out.println("nell elemento "+cmp[i]+" di entrambi i vettori c'e' l'elemento in comune: "+vet1[cmp[i]]);
            }
        }
        else
        {
            System.out.println(" ");
            System.out.println("nel vettori non ci sono elementi comuni");
            System.out.println(" ");
        }
	}
}