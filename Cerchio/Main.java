import java.util.Scanner;
import java.lang.Math;

class Cerchio
{
    // attributi
    int r,d;

    // metodo1
    public Cerchio(int R)
    {
        r = R;
    }
    // metodo2
    public double Area()
    {
        return ((r*r) * Math.PI);
    }
    // metodo3
    public int Diametro()
    {
        d = (r*2);
        return d;
    }
    // metodo4
    public double Circonferenza()
    {
        return (d * Math.PI);
    }
}

 // ProgTriangolo
public class Main
{
    public static void main(String argv[])
    {
        Scanner k = new Scanner(System.in);
        int R;
        
        System.out.println("Inserisci il raggio: ");
        R = k.nextInt();
        
        // dichiarazione dellgli oggetti
        Cerchio a;
        
        // instanziare  l'oggetto
        a = new Cerchio(R); 
        
        // creazione dell'istanza
        
        System.out.println("L'Area del cerchio è = " + a.Area() );
        System.out.println("La diagonale è = " + a.Diametro() );
        System.out.println("Il perimetro è = " + a.Circonferenza() );
    }
}
