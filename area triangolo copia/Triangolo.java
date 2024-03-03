/*
Scrivere un programma che calcoli l'area del triangolo
*/

import java.util.Scanner;

class Triangolo
{ 
    public static void main(String args[]) 
    {
        Scanner y = new Scanner(System.in);  	
        int a,b,x;
        System.out.println("ax+b=0");
        System.out.print("inserisci a:");
        a = y.nextInt();
        System.out.print("inserisci b:");
        b = y.nextInt();      
        x=-b/a;
        System.out.println("il risultato dell'equazione e’:"+ x);
    }
}




















