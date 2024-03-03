/*
Dopo aver riempito un vettore di 10 elementi utilizzando la funzione random con
numeri interi compresi tra 0 e 100, copiare i valori inferiori a 50 in un vettore e quelli
superiori in un altro vettore. Visualizzare entrambi i vettori. Poi fare la somma degli
elementi del primo vettore risultante e la somma degli elementi del secondo vettore
risultante e dire quale somma è maggiore.
*/
public class Main
{
	public static void main(String[] args) 
	{
	    int x=0,y=0,s1=0,s2=0;
		int vett[] = new int[10];
		int min[] = new int[10];
		int max[] = new int[10];
		
		System.out.println(" ");
        System.out.println("visualizzazione del del vettore con numeri maggiori di 50");
        System.out.println(" ");
        
		for(int i=0 ; i<vett.length ; i++)
        {
            vett[i] = (int)(Math.random()*100);
            
            if(vett[i]>50)
            {
                max[y]=vett[i];
                s1=s1+max[y];
                System.out.println("nell elemento "+y+" del vettore di elementi maggiori c'e':"+max[y]);
                y++;
            }
            else
            {
                min[x]=vett[i];
                s2=s2+min[x];
                x++;
            }
        }
        if(y==0)
        {
            System.out.println("il vettore non ha numeri maggiori di 50");
        }
        System.out.println(" ");
        System.out.println(" ");
        System.out.println("visualizzazione del del vettore con numeri minori di 50");
        System.out.println(" ");
        
        for(int i=0 ; i<x ; i++)
        {
           System.out.println("nell elemento "+i+" del vettore di elementi minori c'e':"+min[i]);
        }
        
        if(x==0)
        {
            System.out.println("il vettore non ha numeri minori di 50");
        }
	}
}