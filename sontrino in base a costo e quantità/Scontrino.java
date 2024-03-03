/*
Scrivere un programma in Java che dato in ingresso il costo di prodotto e
quantità di tale prodotto visualizzi a video il costo dello scontrino.
 */
import java.util.Scanner;

public class Scontrino
{ 
    public static void main(String args[]) 
    {
        Scanner y = new Scanner(System.in);      
        double p,c;
        int q;
        System.out.print("inserisci il prezzo del prodotto:");
        p = y.nextDouble();
        System.out.print("inserisci il numero di prodotti acquistati:");
        q = y.nextInt(); 
        
        c =p*q;
        System.out.print("il prezzo del prodotto finale e' di:" +c+ "€");
    }
}