/*
Scrivere un programma in Java che dati tre valori di tipo intero visualizzi quello
massimo e quello minimo (utilizzare gli operatori logici).
 */
import java.util.Scanner;

public class MaxMin
{ 
    public static void main(String args[]) 
    {
        Scanner y = new Scanner(System.in);      
        int a,b,c;
        System.out.print("inserisci il primo numero:");
        a = y.nextInt();
        System.out.print("inserisci il secondo numero:");
        b = y.nextInt(); 
        System.out.print("inserisci il terzo numero:");
        c = y.nextInt();
        
        if(a>b)
        {
            if(a>c)
            {
                System.out.println("il numero maggiore e':"+a);
            }
            else
            {
                System.out.println("il numero maggiore e':"+c);
            }
            
            if(b<c)
            {
                System.out.println("il numero minore e':"+b);
            }
            else
            {
                System.out.println("il numero minore e':"+c);
            }
            
        }
        
        else
        {
            if(b>c)
            {
                System.out.println("il numero maggiore e':"+b);
            }
            else
            {
                System.out.println("il numero maggiore e':"+c);
            }
            
            if(a<c)
            {
                System.out.println("il numero minore e':"+a);
            }
            else
            {
                System.out.println("il numero minore e':"+c);
            }
        }
    }
}