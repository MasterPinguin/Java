/*
2)  Dopo aver inserito due valori numerici interi (num_1, num_2) verificando che il primo sia inferiore al secondo, 
    chiedere in input un terzo numero (num_3) compreso tra num_1 e num_2 ( num_1 < num_3 < num_2) e visualizzare tutti i multipli del terzo numero
    compresi tra i primi due numeri inseriti.

 Esempio 1: num_1 = 4
	    num_2 = 29

	    num_3 = 5

            output:   5, 10, 15, 20, 25



 Esempio 2: num_1 = 4
	    num_2 = 7

	    num_3 = 5

            output:   5
*/

import java.util.Scanner;

public class Main
{
	public static void main(String[] args) 
	{
	    int n1,n2,n3,z;
	    boolean y=true;
	    Scanner x = new Scanner(System.in); 
	    
	    System.out.println("inserisci i due numeri tra cui devono essere compresi i multipli del terzo numero inserito");
		System.out.println("inserisci il numero minore");
		n1 = x.nextInt();
		
		do
		{
		    if(y==true)
		    {
		        System.out.println("inserisci il numero maggiore");
		    }
    		else
    		{
    		    System.out.println("reinserisci il numero poiche non era maggiore");
    		}
    		n2 = x.nextInt();
    		y=false;
		}
		while(n1>=n2);
		
		y=true;
		
		do
		{
		    if(y==true)
		    {
		        System.out.println("inserisci il numero compreso");
		    }
    		else
    		{
    		    System.out.println("reinserisci il numero poiche non è compreso tra i due numeri precedentemente inseriti");
    		}
    		n3 = x.nextInt();
    		y=false;
		}
		while(n3<n1 || n3>n2);
		
		System.out.println("i multipli dell'ultimo numero compresi tra i primi due numeri inseriti sono");
		
		for(z=n3; z>=n1 && z<=n2; z=z+n3)
		{
		    System.out.print(z+"  ");
		}
	}
}