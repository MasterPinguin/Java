/*
Scrivere un programma che riempito un vettore di 10 elementi, visualizzi a video gli
elementi di posizione pari.
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
        System.out.println("visualizzazione degli elementi di posizione pari");
        System.out.println(" ");
        
        for(int i=0 ; i<vett.length ; i++)
        {
            if(i%2==0)
            {
                System.out.println("nell elemento "+i+" del vettore c'e' il numero:"+vett[i]);
            }
        }
	}
}