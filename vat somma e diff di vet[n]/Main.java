/*
Calcola i vettori somma e differenza di due vettori di N componenti con N <= 10.
*/
import java.util.Scanner;

public class Main
{
	public static void main(String[] args) 
	{
		int vet1[] = new int[10];
		int vet2[] = new int[10];
		int som[] = new int[10];
		int diff[] = new int[10];
		
		Scanner xx = new Scanner(System.in);  
		
		for(int i=0 ; i<vett.length ; i++)
        {
            System.out.println("inserisci l'elemento "+i+" del primo vettore");
            vet1[i] = xx.nextInt();   
            
            System.out.println("inserisci l'elemento "+i+" del secondo vettore");
            vet2[i] = xx.nextInt(); 
            
            som[i]=vet1[i]+vet2[i];
            diff[i]=vet1[i]-vet2[i];
        }
        
        System.out.println(" ");
        System.out.println("visualizzazione del del vettore con la somma");
        System.out.println(" ");
        
        for(int i=0 ; i<som.length ; i++)
        {
           System.out.println("nell elemento "+i+" del vettore somma c'e':"+som[i]);
        }
        
        System.out.println(" ");
        System.out.println("visualizzazione del del vettore con la differenza");
        System.out.println(" ");
        
        for(int i=0 ; i<diff.length ; i++)
        {
           System.out.println("nell elemento "+i+" del vettore differenza c'e':"+diff[i]);
        }
	}
}