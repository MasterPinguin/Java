/*
Riempire un vettore di N elementi, fare la somma e calcolare la media
*/

public class Main
{
	public static void main(String[] args) 
	{
	    int med,som=0,x;
		int vett[] = new int[10];
		
		for(int i=0 ; i<vett.length ; i++)
        {
            vett[i] = (int)(Math.random()*100);
            som=som+vett[i];
        }
        x=vett.length;
        med=som/x;
        
        System.out.println("la somma è"+som);
        System.out.println("la media è"+med);
	}
}