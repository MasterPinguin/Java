/*
Scrivere un programma che dati in ingresso il raggio calcoli l'area e il perimetro
del cerchio.
*/

import java.util.Scanner;

public class Cerchio
{ 
    public static void main(String args[]) 
    {
        Scanner x = new Scanner(System.in);  	
        double r, p=3.14 ,area ,perimetro;
        r = x.nextDouble(); 
        area=(r*r)*p;
        perimetro=(r*2)*p;
        System.out.println("l’area del cerchio e’:"+ area);
        System.out.println("Il perimetro del cerchio e’:"+ perimetro);
    }
}