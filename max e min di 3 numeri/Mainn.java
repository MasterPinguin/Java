/*
1) Dati 3 numeri interi in input (inserimento dei valori con la classe BufferedReader) 
   visualizzare il maggiore ed il minore.
*/

import java.io.*;

public class Mainn
{
	public static void main(String[] args) 
	{   
	    String l;
        int n1,n2,n3,min,magg;
        
        InputStreamReader x = new InputStreamReader(System.in);
        BufferedReader y = new BufferedReader(x);
        
        System.out.println("inserisci il primo numero");
        try
        {
            l = y.readLine();
            n1 = Integer. valueOf(l) .intValue() ;
        }
        catch(Exception e)
        {
            System.out.println("\nNumero non corretto!");
            return;
        }
        
        System.out.println("inserisci il secondo numero");
        try
        {
            l = y.readLine();
            n2 = Integer. valueOf(l) .intValue() ;
        }
        catch(Exception e)
        {
            System.out.println("\nNumero non corretto!");
            return;
        }
        
        System.out.println("inserisci il terzo numero");
        try
        {
            l = y.readLine();
            n3 = Integer. valueOf(l) .intValue() ;
        }
        catch(Exception e)
        {
            System.out.println("\nNumero non corretto!");
            return;
        }
        
        if(n1<n2)
        {
            if(n1<n3)
            {
                min=n1;
                if(n2>n3)
                {
                    magg=n2;
                }
                else
                {
                    magg=n3;
                }
            }
            else
            {
                min=n3;
                magg=n2;
            }
        }
        else
        {
            if(n2<n3)
            {
                min=n2;
                if(n1>n3)
                {
                    magg=n1;
                }
                else
                {
                    magg=n3;
                }
            }
            else
            {
                min=n3;
                magg=n1;
            }
        }
        
        System.out.println("il numero minore e'"+min);
        System.out.println("il numero maggiore e'"+magg);
	}
}