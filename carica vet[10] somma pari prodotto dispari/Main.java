/*
Scrivere un programma che dopo aver caricato un vettore di N componenti, con
N<= 10, calcoli il prodotto delle componenti di posto pari e la somma di quelle
dispari.
*/

import java.util.Scanner;

public class Main
{
	public static void main(String[] args) 
	{
	    int som=0,prod=1;
		int vett[] = new int[10];
		
		Scanner x = new Scanner(System.in);
		
		for(int i=0 ; i<vett.length ; i++)
        {
            System.out.println("inserisci l'elemento "+i+" del vettore");
            vett[i] = x.nextInt();      
        }
        
        for(int i=0 ; i<vett.length ; i++)
        {
            if(i%2==0)
            {
                prod=prod*vett[i];
            }
            else
            {
                som=som+vett[i];
            }
        }
        System.out.println("il prodotto dei componenti di posto pari del vettore e':"+prod);
        System.out.println("la somma dei componenti di posto dispari del vettore e':"+som);
	}
}