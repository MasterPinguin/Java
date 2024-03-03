/*
Scrivere una classe java che contenga al suo interno un metodo main, nel quale si
chiede all'utente di inserire un vettore di numeri reali V e si calcolano il valore
minimo e il secondo minimo, stampandoli sullo schermo.
*/
import java.util.Scanner;

public class Main
{
	public static void main(String[] args) 
	{
	    int x,i=0;
		int vett[] = new int[10];
		
		Scanner xx = new Scanner(System.in);  
		
		for( i=0 ; i<vett.length ; i++)
        {
            System.out.println("inserisci l'elemento "+i+" del vettore");
            vett[i] = xx.nextInt(); 
        }
        
        for(int y=0 ; y<2 ; y++)
        {
            for(i=0 ; i<vett.length- 1 ; i++)
            {
                if(vett[i]<vett[i + 1])
                {
                    x=vett[i];
                    vett[i]=vett[i + 1];
                    vett[i + 1]=x;
                }
            }
        }
        
        System.out.println("il valore minimo è"+vett[i]);
        System.out.println("il valore secondo minimo è"+vett[i - 1]);
	}
}