/*
Costruire la tavola pitagorica per i numeri da 0 a 9.
*/
public class Main
{
	public static void main(String[] args) 
	{
		int mat[][] = new int[10][10];
		System.out.println("0  1  2  3  4  5  6  7  8  9");
		for(int j=0 ; j<10 ; j++)
        {
            for(int i=0 ; i<10 ; i++)
            {
                mat[j][i] = j*i;
                if(mat[j][i]>=10)
                {
                    System.out.print(mat[j][i]+" ");
                }
                else
                {
                    System.out.print(mat[j][i]+"  ");
                }
            }
            System.out.println("");
        }
	}
}