import java.util.Scanner;
import java.lang.Math;

class Triangolo
{
    // attributi
    int a,b,c,p;

    // metodo1
    public Triangolo(int l1,int l2,int l3)
    {
        a = l1;
        b = l2;
        c = l3;
    }
    // metodo2
    public int calcolaPerimetro()
    {
        p = (a+b+c);
        return p;
    }
    // metodo3
    public double calcolaArea()
    {
        double z=p/2;
        return (Math.sqrt(z*(z-a)*(z-b)*(z-c)));
    }
    // metodo4
    public String tipoTriangolo()
    {
        if(a==b && a==c) return ("equilatero");
        else if(a!=b && a!=c && c!=b) return ("scaleno");
        else return ("isoscele");
    }
}

 // ProgTriangolo
public class Main
{
    public static void main(String argv[])
    {
        Scanner k = new Scanner(System.in);
        int l1,l2,l3;
        
        System.out.println("Inserisci il primo lato: ");
        l1 = k.nextInt();
        System.out.println("Inserisci il secondo lato: ");
        l2 = k.nextInt();
        System.out.println("Inserisci il terzo lato: ");
        l3 = k.nextInt();
        
        // dichiarazione dellgli oggetti
        Triangolo a;
        
        // instanziare  l'oggetto
        a = new Triangolo(l1,l2,l3); 
        
        // creazione dell'istanza
        
        System.out.println("Perimetro del triangolo =" + a.calcolaPerimetro() );
        System.out.println("Area del triangolo =" + a.calcolaArea() );
        System.out.println("il triangolo è un triangolo " + a.tipoTriangolo() );
    }
}