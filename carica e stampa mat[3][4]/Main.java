/*
Scrivere un programma che dopo aver riempito una matrice NxM, visualizzi a video gli
elementi della matrice. Es. N=3 e M=4
*/
public class Main
{
	public static void main(String[] args) 
	{
		int mat[][] = new int[3][4];		
		for(int j=0 ; j<3 ; j++)
        {
            for(int  i=0 ; i<4 ; i++)
            {
                mat[j][i] = (int)(Math.random()*100); 
                System.out.println("il valore nella cella ["+j+"] ["+i+"] è: "+mat[j][i]);
            }
        }
	}
}