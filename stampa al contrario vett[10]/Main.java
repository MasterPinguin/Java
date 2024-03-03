/*
Continuo esercizio 1. Visualizzare a video gli elementi del vettore partendo
dall’ultima posizione.
*/

import java.util.Scanner;

public class Main
{
	public static void main(String[] args) 
	{
		int vett[] = new int[10];
		
		Scanner x = new Scanner(System.in);
		
		for(int i=0 ; i<vett.length ; i++)
        {
            System.out.println("inserisci l'elemento "+i+" del vettore");
            vett[i] = x.nextInt();      
        }
        
        System.out.println(" ");
        System.out.println("visualizzazione del vettore al contrario ");
        System.out.println(" ");
        
        for(int i=vett.length ; i>0 ; i--)
        {
            System.out.println("nell elemento "+i+" del vettore c'e' il numero:"+vett[i]);
        }
	}
}