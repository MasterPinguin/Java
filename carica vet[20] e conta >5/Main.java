/*
Dopo aver caricato in memoria un array di numeri interi con 20 componenti, contare le
componenti che hanno valore superiore a 5.
*/

import java.util.Scanner;

public class Main
{
	public static void main(String[] args) 
	{
	    int x=0;
		int vett[] = new int[20];
		
		Scanner xx = new Scanner(System.in);
		
		for(int i=0 ; i<vett.length ; i++)
        {
            System.out.println("inserisci l'elemento "+i+" del vettore");
            vett[i] = xx.nextInt();      
        }
        
        for(int i=0 ; i<vett.length ; i++)
        {
            if(vett[i]>5)
            {
                x=x++;
            }
        }
        System.out.println("il numero di componenti maggiori di 5 e' di :"+x);
	}
}