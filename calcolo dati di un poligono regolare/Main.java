import java.util.Scanner;
import java.lang.Math;

class PoligonoRegolare
{
    // attributi
    int nl;
    double l, a, A, P, NF;

    // metodo1
    public PoligonoRegolare(double lato, int nlati)
    {
        l = lato;
        nl = nlati;
    }
    
    // metodo2
    public double Perimetro()
    {
        P = l*nl;
        return P;
    }
    
    // metodo3
    public double Area()
    {
        NF = 1/(2* Math.tan(Math.PI/nl));
        a = NF*l;
        A = (P*a)/ 2;
        return A;
    }

    // metodo4
    public double Apotema()
    {
        NF = 1/(2* Math.tan(Math.PI/nl));
        a = NF*l;
        return a;
    }
    
    // metodo5
    public String Tipo()
    {
        if(nl==3) return ("triangolo");
        else if(nl==4) return ("quadrato");
        else if(nl==5) return ("pentagono");
        else if(nl==6) return ("esagono");
        else if(nl==7) return ("ettagono");
        else if(nl==8) return ("ottagono");
        else if(nl==9) return ("ennagono");
        else if(nl==10) return ("decagono");
        else if(nl==11) return ("endecagono");
        else return ("dodecagono");
    }

}

 // ProgPoligonoRegolare
public class Main
{
    public static void main(String argv[])
    {
        int nlati;
        double lato;
        boolean y=true;
        
        Scanner k = new Scanner(System.in);
    
        System.out.println("Inserisci il lato: ");
        lato = k.nextDouble();
        
        do
        {
            if(y==true)
            {
                System.out.println("Inserisci il numero dei lati: ");
            }
            else
            {
                System.out.println("Reinserisci il numero dei lati poiche non è compreso tra 3 e 12: ");
            }
            
            nlati = k.nextInt();
            y=false;
        }
        while(nlati<3 || nlati>12);
        
        // dichiarazione dellgli oggetti
        PoligonoRegolare a;
        
        // instanziare  l'oggetto
        a = new PoligonoRegolare(lato, nlati); 
        
        // creazione dell'istanza
        
        System.out.println("Il perimetro del Poligono Regolare è = " + a.Perimetro() );
        System.out.println("L'Area del Poligono Regolare è = " + a.Area() );
        System.out.println("L'Apotema del Poligono Regolare  è = " + a.Apotema() );
        System.out.println("Il Poligono Regolare è un = " + a.Tipo() );
    }
}
