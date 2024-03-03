import java.util.Scanner;

class Quadrato
{
    // attributi
    int lato;

    // metodo1
    public Quadrato(int l)
    {
        lato = l;
    }
    // metodo2
    public double calcolaArea()
    {
        return (lato*lato);
    }
    // metodo3
    public double calcolaPerimetro()
    {
        return (lato*4);
    }
    // metodo4
    public double calcolaDiagonale()
    {
        return (lato*Math.PI);
    }
}

 // ProgQuadrato
public class Main
{
    public static void main(String argv[])
    {
        Scanner k = new Scanner(System.in);
        int l;
        
        System.out.println("Inserisci il lato: ");
        l = k.nextInt();
        
        // dichiarazione dellgli oggetti
        Quadrato a;
        
        // instanziare  l'oggetto
        a = new Quadrato(l); 
        
        // creazione dell'istanza
        
        System.out.println("Area del quadrato =" + a.calcolaArea() );
        System.out.println("Perimetro del quadrato =" + a.calcolaPerimetro() );
        System.out.println("Diagonale del quadrato =" + a.calcolaDiagonale() );
    }
}

