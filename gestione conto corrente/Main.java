/*
Creare una classe per la gestione di un conto corrente chiamata ContoCorrente. 
Ciascun conto corrente possiede un numero di conto (di tipo intero), un intestatario e un saldo. 
Vogliamo inoltre realizzare due costruttori, uno che presenti i parametri per tutti gli attributi 
e un secondo senza il saldo, intendendolo azzerato. Inoltre vogliamo realizzare i metodi get() per 
leggere il contenuto degli attributi secondo l’information hiding.

Usare l'operatore this.
*/
import java.util.Scanner;
import java.lang.Math;

class ContoCorrente
{
    // attributi
    int conto, saldo=0;
    String inte, x;

    // metodo
    public ContoCorrente(int conto, int saldo, String inte)
    {
        this.conto=conto;
        this.saldo=saldo;
        this.inte=inte;
    }
    
    public ContoCorrente(int conto, String inte)
    {
        this.conto=conto;
        this.inte=inte;
    }
    
    // metodo1
    public int getConto()
    {
        return conto;
    }
    
    // metodo2
    public String getInte()
    {
        return inte;
    }
    
    // metodo3
    public String getSaldo()
    {
        x = Integer.toString(saldo);
        
        if(saldo == 0) return ("sei povero");
        else return x;
    }

}

 // ContoCorrente
public class Main
{
    public static void main(String argv[])
    {
        int conto, saldo;
        String inte;
        boolean y=true;
        
        Scanner k = new Scanner(System.in);
        
        System.out.println("Inserisci il nome dell'intestatario: ");
        inte = k.nextLine();
    
        System.out.println("Inserisci il numero del conto: ");
        conto = k.nextInt();
        
        System.out.println("Inserisci il saldo: ");
        saldo = k.nextInt();
        
        System.out.println(" ");
        // dichiarazione dellgli oggetti
        ContoCorrente a;
        
        // instanziare  l'oggetto
        if(saldo==0)
        {
            a = new ContoCorrente(conto, inte);
        }
        else
        {
            a = new ContoCorrente(conto, saldo, inte);
        }
        
        // creazione dell'istanza
        
        System.out.print("Il conto " + a.getConto() );
        System.out.print(" è intestato a " + a.getInte() );
        System.out.print(" con un saldo di " + a.getSaldo() );
    }
}
