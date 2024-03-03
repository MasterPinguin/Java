/*
Scrivere un programma in Java che permetta di calcolare il costo di un prodotto
da scontare in base al suo valore. Se il valore supera o è uguale a 500 euro allora
lo sconto da applicare è del 5% altrimenti è del 3%.
 */
import java.util.Scanner;

public class Sconto
{ 
    public static void main(String args[]) 
    {
        Scanner y = new Scanner(System.in);      
        double p,s,c;
        System.out.print("inserisci il prezzo del prodotto da scontare:");
        p = y.nextDouble();
        
        if(p>=500)
        {
            s=(p/100)*5;
        }
        else
        {
            s=(p/100)*3;
        }
        
        c=p-s;
        
        System.out.print("il prezzo del prodotto viene scontato di:"+s+"€"+"con un prezzo finale di:"+c+"€");
    }
}

